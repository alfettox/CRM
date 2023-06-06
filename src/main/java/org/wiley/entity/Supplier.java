package org.wiley.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/* *
 * Abdullah Tariq, Riyad Argoub, Giovanni De Franceschi
 * Wiley Edge 2023
 * */

@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @Column(name = "supplierId")
    private int supplierId;

    @Column(name = "supPhoneNum")
    private int supPhoneNum;

    @Column(name = "supEmail", length = 40)
    private String supEmail;

    @ManyToMany
    @JoinTable(
            name = "productSupplier",
            joinColumns = @JoinColumn(name = "supplierId"),
            inverseJoinColumns = @JoinColumn(name = "productId")
    )
    private List<Product> productsSuppliers;

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getSupPhoneNum() {
        return supPhoneNum;
    }

    public void setSupPhoneNum(int supPhoneNum) {
        this.supPhoneNum = supPhoneNum;
    }

    public String getSupEmail() {
        return supEmail;
    }

    public void setSupEmail(String supEmail) {
        this.supEmail = supEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Supplier supplier = (Supplier) o;

        if (supplierId != supplier.supplierId) return false;
        if (supPhoneNum != supplier.supPhoneNum) return false;
        if (!Objects.equals(supEmail, supplier.supEmail)) return false;
        return Objects.equals(productsSuppliers, supplier.productsSuppliers);
    }

    @Override
    public int hashCode() {
        int result = supplierId;
        result = 31 * result + supPhoneNum;
        result = 31 * result + (supEmail != null ? supEmail.hashCode() : 0);
        result = 31 * result + (productsSuppliers != null ? productsSuppliers.hashCode() : 0);
        return result;
    }

}



