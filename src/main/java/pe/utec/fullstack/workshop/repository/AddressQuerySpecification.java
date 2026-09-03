package pe.utec.fullstack.workshop.repository;

import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

public interface AddressQuerySpecification {

    static PredicateSpecification<AddressEntity> hasName(String name) {
        return (root, builder) -> builder.like(root.get("name"), String.format("*%s*", name));
    }

}
