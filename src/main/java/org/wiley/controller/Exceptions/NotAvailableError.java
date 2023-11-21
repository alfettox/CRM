package org.wiley.controller.Exceptions;

import org.wiley.entity.Product;

/* *
 * Giovanni De Franceschi
 * Wiley Edge 2023
 * */
public class NotAvailableError extends Exception {
    public NotAvailableError(Product product) {
        super("Product " + product.getProductName() + " is not available");
    }

}
