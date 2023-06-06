//package org.wiley.entity;
//
///**
// * Giovanni De Franceschi
// * Wiley Edge
// **/
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Embeddable
//public class OrderProductKey implements Serializable {
//    @Column(name = "orderId")
//    private int orderId;
//
//    @Column(name = "productId")
//    private int productId;
//
//    public OrderProductKey() {
//    }
//
//    public OrderProductKey(int orderId, int productId) {
//        this.orderId = orderId;
//        this.productId = productId;
//    }
//
//    public int getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(int orderId) {
//        this.orderId = orderId;
//    }
//
//    public int getProductId() {
//        return productId;
//    }
//
//    public void setProductId(int productId) {
//        this.productId = productId;
//    }
//
//    // Implement equals and hashCode methods
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        OrderProductKey that = (OrderProductKey) o;
//        return orderId == that.orderId && productId == that.productId;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(orderId, productId);
//    }
//}
