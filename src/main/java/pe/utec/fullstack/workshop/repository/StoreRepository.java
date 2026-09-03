package pe.utec.fullstack.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<StockEntity, Integer>, JpaSpecificationExecutor<StockEntity> {


}
