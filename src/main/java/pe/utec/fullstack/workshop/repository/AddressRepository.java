package pe.utec.fullstack.workshop.repository;

import org.hibernate.query.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import pe.utec.fullstack.workshop.controller.auth.UserInfoDetails;
import pe.utec.fullstack.workshop.controller.query.AddressQueryParams;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer>, JpaSpecificationExecutor<AddressEntity> {

    //public Page<AddressEntity> findAllByUserIdNameContainsAndAliasContainsAndStreetNameContainsAndLatitudeBetween();

    default Specification<AddressEntity> buildQuery(AddressQueryParams addressQueryParams, UserInfoDetails userDetails) {

        Specification<AddressEntity> specification = (root, query, builder) -> builder.like(root.get("name"), String.format("*%s*", emptyString(addressQueryParams.getName())));

        specification = Specification.where(specification).and((root, query, builder) -> builder.like(root.get("alias"), String.format("*%s*", emptyString(addressQueryParams.getAlias()))));

        specification = Specification.where(specification).and((root, query, builder) -> builder.like(root.get("streetName"), String.format("*%s*", emptyString(addressQueryParams.getAlias()))));

        specification = Specification.where(specification).and((root, query, builder) -> builder.equal(root.get("id"), userDetails.getId()));

        return specification;
    }

    AddressEntity findByIdAndEnabledIsFalse(Integer id);

    default String emptyString(String text) {
        return Optional.ofNullable(text)
                .orElse("");
    }

}
