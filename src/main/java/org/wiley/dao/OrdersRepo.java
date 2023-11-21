package org.wiley.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.wiley.entity.Order;

import java.util.List;

/* *
 * Giovanni De Franceschi
 * Wiley Edge 2023
 * */
@Repository
public interface OrdersRepo extends JpaRepository<Order, Integer> {

    @Query("SELECT o FROM Order o WHERE o.customer.customerId = :customerId")
    List<Order> getOrdersByCustomerId(@Param("customerId") Integer customerId);

}
