package com.lopessystem.pocimproveapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The type Address.
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "address")
public class Address {

    /**
     * The Id.
     */
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The Line 1.
     */
    @Column(name = "line_1")
    private String line1;

    /**
     * The Line 2.
     */
    @Column(name = "line_2")
    private String line2;

    /**
     * The Postal code.
     */
    @Column(name = "postal_code")
    private String postalCode;

    /**
     * The City.
     */
    @ManyToOne
    @JoinColumn(name = "fk_city")
    private City city;
}
