package edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model;

import java.time.LocalDate;

public class Product {
    private Long productId;
    private String name;
    private LocalDate dateApplied;
    private Integer quantityInStock;
    private Double unitPrice;


    public Product(Long productId, String name, LocalDate dateApplied, Integer quantityInStock,Double unitPrice) {
        this.productId = productId;
        this.name = name;
        this.dateApplied = dateApplied;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    public Product() {
        this(null, null, null, null, null);
    }

    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(LocalDate dateApplied) {
        this.dateApplied = dateApplied;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }
    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", dateApplied=" + dateApplied +
                ", quantityInStock=" + quantityInStock +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
