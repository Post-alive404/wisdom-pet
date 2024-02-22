package com.dden.wisdompet.data.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * ProductEntity
 *
 * @author Denys Parshutkin
 * @version 1.0.0
 */

@Entity
@Table(name = "PRODUCTS")
@Data
@ToString
public class ProductEntity {
    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "NAME", unique = true)
    private String name;
    @Column(name = "PRICE")
    private BigDecimal price;
    @Column(name = "VENDOR_ID", nullable = false)
    private long vendorId;



}
