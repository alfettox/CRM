package org.wiley.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* *
 * Giovanni De Franceschi
 * Wiley Edge 2023
 * */

@Entity
@Table(name = "productCategory")
public class ProductCategory {
    @Id
    @Column(name = "catId")
    private int catId;

    @Column(name = "productCat", length = 40)
    private String productCat;

    @Lob
    @Column(name = "catImage")
    private byte[] catImage;

    @OneToMany(mappedBy = "productCategory")
    private List<Product> products = new ArrayList<>();

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getProductCat() {
        return productCat;
    }

    public void setProductCat(String productCat) {
        this.productCat = productCat;
    }

    public byte[] getCatImage() {
        return catImage;
    }

    public void setCatImage(byte[] catImage) {
        this.catImage = catImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductCategory that = (ProductCategory) o;

        if (catId != that.catId) return false;
        if (!Objects.equals(productCat, that.productCat)) return false;
        return Arrays.equals(catImage, that.catImage);
    }

    @Override
    public int hashCode() {
        int result = catId;
        result = 31 * result + (productCat != null ? productCat.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(catImage);
        return result;
    }
}
