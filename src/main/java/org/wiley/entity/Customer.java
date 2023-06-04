package org.wiley.entity;

import javax.persistence.*;

/* *
 * Abdullah Tariq, Riyad Argoub, Giovanni De Franceschi
 * Wiley Edge 2023
 * */
@Entity
class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId", nullable = false)
    private Long id;

    @Column (name="fName")
    private String fName;

    @Column (name="lName")
    private String lName;

    @Column (name="phoneNum")
    private String phoneNum;

    @Column (name="shippingAddress")
    private String shippingAddress;

    @Column (name="email")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
