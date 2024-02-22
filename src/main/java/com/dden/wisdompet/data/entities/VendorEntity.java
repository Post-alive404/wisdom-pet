package com.dden.wisdompet.data.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

/**
 * VendorEntity
 *
 * @author Denys Parshutkin
 * @version 1.0.0
 */

@Entity
@Table(name = "VENDORS")
@Data
@ToString
public class VendorEntity {
    @Id
    @Column(name = "VENDOR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "CONTACT")
    private String contact;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ADDRESS")
    private String address;

}
