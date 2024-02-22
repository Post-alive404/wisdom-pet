package com.dden.wisdompet.web.models;

import com.dden.wisdompet.data.entities.VendorEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Product
 *
 * @author Denys Parshutkin
 * @version 1.0.0
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    private Long productId;
    private String productName;
    private BigDecimal productPrice;
    private Long vendorId;
}
