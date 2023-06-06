package org.wiley.dao;

/* *
 * Abdullah Tariq, Riyad Argoub, Giovanni De Franceschi
 * Wiley Edge 2023
 * */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wiley.entity.Order;
import org.wiley.entity.Product;

import java.util.List;

@Repository
public interface ProductsRepo extends JpaRepository<Product, Integer> {
    List<Product> findByOrders(Order order);

}
