package org.wiley.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wiley.entity.Order;

/* *
 * Abdullah Tariq, Riyad Argoub, Giovanni De Franceschi
 * Wiley Edge 2023
 * */

@Repository
public interface CustomersRepo extends JpaRepository<Order, Integer> {
}
