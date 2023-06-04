package org.wiley.entity;

import javax.persistence.*;

/* *
 * Abdullah Tariq, Riyad Argoub, Giovanni De Franceschi
 * Wiley Edge 2023
 * */
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplierId", nullable = false)
    private Long id;

    @Column(name="supPhoneNum")
    private String supPhoneNum;

    @Column (name="supEmail")
    private String supEmail;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
