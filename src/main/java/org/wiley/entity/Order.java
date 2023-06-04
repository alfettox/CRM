package org.wiley.entity;

import javax.persistence.*;

/* *
 * Abdullah Tariq, Riyad Argoub, Giovanni De Franceschi
 * Wiley Edge 2023
 * */
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId", nullable = false)
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "productId")
    private Integer productId;

    @Column (name="customerId")
    private Integer customerId;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
