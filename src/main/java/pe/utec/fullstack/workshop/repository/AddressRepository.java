package pe.utec.fullstack.workshop.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import pe.utec.fullstack.workshop.controller.query.AddressQueryParams;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer>, JpaSpecificationExecutor<AddressEntity> {


    default Specification<AddressEntity> buildQuery(AddressQueryParams addressQueryParams, UserDetails userDetails) {
        return Specification.where(
                (root, builder) -> builder.like(root.get("name"), String.format("*%s*", emptyString(addressQueryParams.getName())))
        );
    }

    AddressEntity findByIdAndEnabledIsFalse(Integer id);

    default String emptyString(String text) {
        return Optional.ofNullable(text)
                .orElse("");
    }

}
