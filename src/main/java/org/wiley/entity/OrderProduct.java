//import org.wiley.entity.Order;
//import org.wiley.entity.OrderProductKey;
//import org.wiley.entity.Product;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "orderproduct")
//public class OrderProduct {
//    @EmbeddedId
//    private OrderProductKey id;
//
//    @ManyToOne
//    @MapsId("orderId")
//    @JoinColumn(name = "orderId")
//    private Order order;
//
//    @ManyToOne
//    @MapsId("productId")
//    @JoinColumn(name = "productId")
//    private Product product;
//
//    private int quantity;
//
//    // Constructors, getters, and setters
//
//    public OrderProduct() {
//    }
//
//    public OrderProduct(Order order, Product product, int quantity) {
//        this.order = order;
//        this.product = product;
//        this.quantity = quantity;
//        this.id = new OrderProductKey(order.getOrderId(), product.getProductId());
//    }
//
//    public OrderProductKey getId() {
//        return id;
//    }
//
//    public void setId(OrderProductKey id) {
//        this.id = id;
//    }
//
//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//}
