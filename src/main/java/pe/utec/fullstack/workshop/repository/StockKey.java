package pe.utec.fullstack.workshop.repository;

import jakarta.persistence.Embeddable;

@Embeddable
public class StockKey {

    public Integer productId;

    public Integer warehouseId;
}
