package org.wiley.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wiley.entity.Order;

import java.util.List;

/* *
 * Abdullah Tariq, Riyad Argoub, Giovanni De Franceschi
 * Wiley Edge 2023
 * */
@Repository
public interface OrdersRepo extends JpaRepository<Order, Integer> {
//    List<Order> findByCustomerId(int customerId);
}
