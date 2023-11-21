package org.wiley.controller;

/**
 * Giovanni De Franceschi
 * Wiley Edge
 **/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class OrderProductController {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderProductController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/products/orderid/{orderId}")
    public List<Map<String, Object>> getOrderProductsByOrderId(@PathVariable Long orderId) {
        String sql = "SELECT o.orderId, p.productId, p.productCatId, p.productName, p.productPrice, " +
                "pc.catId AS productCategoryId, pc.productCat AS productCategoryName, " +
                "o.quantity, c.customerId, c.fName AS customerFirstName, c.lName AS customerLastName, " +
                "c.phoneNum AS customerPhoneNumber, c.shippingAddress AS customerShippingAddress, " +
                "c.email AS customerEmail " +
                "FROM orders o " +
                "JOIN orderproduct op ON o.orderId = op.orderId " +
                "JOIN product p ON op.productId = p.productId " +
                "JOIN customer c ON o.customerId = c.customerId " +
                "JOIN productcategory pc ON p.productCatId = pc.catId " +
                "WHERE o.orderId = ? ";
        List<Map<String, Object>> orderProducts = jdbcTemplate.queryForList(sql, orderId);
        return jdbcTemplate.queryForList(sql, orderId);
    }
}
