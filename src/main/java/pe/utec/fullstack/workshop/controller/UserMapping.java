package pe.utec.fullstack.workshop.controller;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import pe.utec.fullstack.workshop.controller.request.CreateAddressRequest;
import pe.utec.fullstack.workshop.controller.request.CreateUserRequest;
import pe.utec.fullstack.workshop.controller.request.UpdateAddressRequest;
import pe.utec.fullstack.workshop.domain.business.ClientAddress;
import pe.utec.fullstack.workshop.domain.business.User;
import pe.utec.fullstack.workshop.repository.AddressEntity;
import pe.utec.fullstack.workshop.repository.UserEntity;


@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapping {


    User convert(CreateUserRequest request);

    User convert(UserEntity model);

    UserEntity convert(User user);
}
