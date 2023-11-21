package org.wiley.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* *
 * Giovanni De Franceschi
 * Wiley Edge 2023
 * */

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "customerId")
    private int customerId;

    @Column(name = "fName", length = 50)
    private String fName;

    @Column(name = "lName", length = 50)
    private String lName;

    @Column(name = "phoneNum", length = 10)
    private String phoneNum;

    @Column(name = "shippingAddress", length = 100)
    private String shippingAddress;

    @Column(name = "email", length = 30)
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();

//    public List<Order> getOrders() {
//        return orders;
//    }

//    public void setOrders(List<Order> orders) {
//        this.orders = orders;
//    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (customerId != customer.customerId) return false;
        if (!Objects.equals(fName, customer.fName)) return false;
        if (!Objects.equals(lName, customer.lName)) return false;
        if (!Objects.equals(phoneNum, customer.phoneNum)) return false;
        if (!Objects.equals(shippingAddress, customer.shippingAddress))
            return false;
        return Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        int result = customerId;
        result = 31 * result + (fName != null ? fName.hashCode() : 0);
        result = 31 * result + (lName != null ? lName.hashCode() : 0);
        result = 31 * result + (phoneNum != null ? phoneNum.hashCode() : 0);
        result = 31 * result + (shippingAddress != null ? shippingAddress.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
