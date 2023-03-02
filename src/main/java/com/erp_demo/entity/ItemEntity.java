package com.erp_demo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "item")
public class ItemEntity {

    @Id
    private UUID id = UUID.randomUUID();
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    private Float price;
    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceEntity> invoices = new ArrayList<>();


    // constructors
    public ItemEntity() {}


    public ItemEntity(ProductEntity product, Float price) {
        this.product = product;
        this.price = price;
    }

    public ItemEntity(String id) {
        this.id = UUID.fromString(id);
    }


    // getters and setters
    public UUID getId() {
        return id;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemEntity item = (ItemEntity) o;
        return Double.compare(item.price, price) == 0 && id.equals(item.id) && product.equals(item.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, price);
    }

    // toString
    @Override
    public String toString() {
        return "ItemEntity{" +
                "id=" + id +
                ", products=" + product +
                ", price=" + price +
                '}';
    }
}
