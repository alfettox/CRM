package org.wiley.dao;

/* *
 * Abdullah Tariq, Riyad Argoub, Giovanni De Franceschi
 * Wiley Edge 2023
 * */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wiley.entity.Product;

@Repository
public interface ProductsRepo extends JpaRepository<Product, Integer> {
}
