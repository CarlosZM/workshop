package pe.utec.fullstack.workshop.controller;

import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import pe.utec.fullstack.workshop.controller.query.AddressQueryParams;
import pe.utec.fullstack.workshop.controller.request.CreateAddressRequest;
import pe.utec.fullstack.workshop.controller.request.UpdateAddressRequest;
import pe.utec.fullstack.workshop.domain.ClientService;
import pe.utec.fullstack.workshop.domain.business.Client;
import pe.utec.fullstack.workshop.domain.business.ClientAddress;
import pe.utec.fullstack.workshop.repository.AddressEntity;


@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ClientMapping {


    ClientAddress convert(CreateAddressRequest request);

    ClientAddress convert(UpdateAddressRequest request);

    ClientAddress convert(AddressEntity entity);

    AddressEntity convert(ClientAddress address);

    AddressEntity copy(@MappingTarget AddressEntity oldAddress, ClientAddress address);
}
