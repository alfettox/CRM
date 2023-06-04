package org.wiley.controller;

import org.wiley.entity.Product;

/* *
 * Abdullah Tariq, Riyad Argoub, Giovanni De Franceschi
 * Wiley Edge 2023
 * */
public class NotAvailableError extends Exception {
    public NotAvailableError(Product product) {
        super("Product " + product.getProductName() + " is not available");
    }

}
