package com.dden.wisdompet.web.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Vendor
 *
 * @author Denys Parshutkin
 * @version 1.0.0
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vendor {
    private Long vendorId;
    private String vendorName;
    private String vendorContact;
    private String vendorPhone;
    private String vendorEmail;
    private String vendorAddress;

}
