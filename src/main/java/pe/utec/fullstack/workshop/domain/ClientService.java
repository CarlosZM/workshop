package pe.utec.fullstack.workshop.domain;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PagedModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pe.utec.fullstack.workshop.controller.ClientMapping;
import pe.utec.fullstack.workshop.controller.query.AddressQueryParams;
import pe.utec.fullstack.workshop.controller.query.PageParams;
import pe.utec.fullstack.workshop.domain.business.ClientAddress;
import pe.utec.fullstack.workshop.repository.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapping clientMapping;

    public PagedModel<ClientAddress> findWithFilterAndPagination(AddressQueryParams addressQueryParams, UserDetails userDetails) {

        Specification<AddressEntity> specification = this.addressRepository.buildQuery(addressQueryParams, userDetails);
        Pageable pageable = PageRequest.of(Optional.ofNullable(addressQueryParams.getPagination()).map(PageParams::getSize).orElse(1), Optional.ofNullable(addressQueryParams.getPagination()).map(PageParams::getPage).orElse(10), Sort.by("name"));

        return new PagedModel(this.addressRepository.findAll(specification, pageable).map(this.clientMapping::convert));
    }

    private AddressEntity getById(Integer addressId, Integer clientId) {

        AddressEntity address = this.addressRepository.findByIdAndEnabledIsFalse(addressId);

        if (!clientId.equals(address.getClient().getId())) {
            throw new EntityNotFoundException("ADDRESS NOT FOUND FOR USER");
        }
        return address;
    }

    public ClientAddress findByAddressId(Integer id, UserDetails userDetails) {

        Integer clientId = 1;

        return this.clientMapping.convert(this.getById(id, clientId));
    }

    public ClientAddress createAddress(ClientAddress address, UserDetails userDetails) {

        Integer clientId = 1;

        AddressEntity newAddress = this.clientMapping.convert(address);

        newAddress.setClient(this.clientRepository.getReferenceById(clientId));
        newAddress.setCreatedAt(LocalDateTime.now());
        newAddress.setCreatedBy(clientId);
        newAddress.setEnabled(true);

        return this.clientMapping.convert(
                this.addressRepository.saveAndFlush(
                        newAddress
                )
        );
    }

    public ClientAddress updateAddress(Integer id, ClientAddress address, UserDetails userDetails) {

        Integer clientId = 1;

        AddressEntity oldAddress = this.getById(id, clientId);

        oldAddress = this.clientMapping.copy(oldAddress, address);

        oldAddress.setUpdatedAt(LocalDateTime.now());
        oldAddress.setUpdatedBy(clientId);

        return this.clientMapping.convert(
                this.addressRepository.saveAndFlush(
                        oldAddress
                )
        );
    }

    public void deleteAddress(Integer id, UserDetails userDetails) {
        Integer clientId = 1;

        AddressEntity oldAddress = this.getById(id, clientId);
        oldAddress.setEnabled(false);

        this.addressRepository.saveAndFlush(
                oldAddress
        );

    }
}
