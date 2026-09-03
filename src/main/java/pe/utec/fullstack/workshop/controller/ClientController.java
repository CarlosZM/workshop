package pe.utec.fullstack.workshop.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import pe.utec.fullstack.workshop.controller.auth.UserInfoDetails;
import pe.utec.fullstack.workshop.controller.query.AddressQueryParams;
import pe.utec.fullstack.workshop.controller.request.CreateAddressRequest;
import pe.utec.fullstack.workshop.controller.request.UpdateAddressRequest;
import pe.utec.fullstack.workshop.domain.ClientService;
import pe.utec.fullstack.workshop.domain.business.Client;
import pe.utec.fullstack.workshop.domain.business.ClientAddress;

@RestController
@RequestMapping("/api/me")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientMapping mapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Client getClientInfo() {
        return new Client();
    }

    @GetMapping("/address")
    @ResponseStatus(HttpStatus.OK)
    public PagedModel<ClientAddress> getAddresses(AddressQueryParams addressQueryParams,
                                                  @AuthenticationPrincipal(errorOnInvalidType = true) UserInfoDetails userDetails) {
        return this.clientService.findWithFilterAndPagination(addressQueryParams, userDetails);
    }

    @GetMapping("/address/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientAddress getAddress(@PathVariable Integer id,
                                    @AuthenticationPrincipal UserDetails userDetails) {
        return this.clientService.findByAddressId(id, userDetails);
    }

    @PostMapping("/address")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientAddress createBalance(
            @Valid @RequestBody CreateAddressRequest req,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        return this.clientService.createAddress(
                this.mapper.convert(req),
                userDetails
        );
    }

    @PutMapping("/address/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientAddress updateBalance(
            @PathVariable Integer id,
            @Valid @RequestBody UpdateAddressRequest req,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        return this.clientService.updateAddress(id,
                this.mapper.convert(req),
                userDetails);
    }

    @DeleteMapping("/address/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBalance(
            @PathVariable Integer id,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        this.clientService.deleteAddress(id, userDetails);
    }
}
