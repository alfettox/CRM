package org.wiley.entity;

/* *
 * Abdullah Tariq, Riyad Argoub, Giovanni De Franceschi
 * Wiley Edge 2023
 * */

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "productId")
    private int productId;

    @ManyToOne
    @JoinColumn(name = "productCatId", referencedColumnName = "catId")
    private ProductCategory productCategory;

    @Column(name = "productName", length = 45)
    private String productName;

    @Column(name = "productPrice", precision = 10, scale = 2)
    private BigDecimal productPrice;

    @ManyToMany(mappedBy = "ordersList")
    private List<Order> orders;

    @ManyToMany(mappedBy = "productsSuppliers")
    private List<Supplier> ordersSuppliers;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Supplier> getOrdersSuppliers() {
        return ordersSuppliers;
    }

    public void setOrdersSuppliers(List<Supplier> ordersSuppliers) {
        this.ordersSuppliers = ordersSuppliers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productId != product.productId) return false;
        if (!Objects.equals(productCategory, product.productCategory))
            return false;
        if (!Objects.equals(productName, product.productName)) return false;
        if (!Objects.equals(productPrice, product.productPrice))
            return false;
        return Objects.equals(orders, product.orders);
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + (productCategory != null ? productCategory.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (orders != null ? orders.hashCode() : 0);
        return result;
    }

}
