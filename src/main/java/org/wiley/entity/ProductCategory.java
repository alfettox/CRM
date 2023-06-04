package org.wiley.entity;

import javax.persistence.*;

/* *
 * Abdullah Tariq, Riyad Argoub, Giovanni De Franceschi
 * Wiley Edge 2023
 * */
@Entity
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catId", nullable = false)
    private Long id;

    @Column (name= "productCat")
    private String productCat;

    @Column (name ="catImage")
    private String catImage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
