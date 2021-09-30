package com.lopessystem.pocimproveapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lopessystem.pocimproveapi.model.enumerations.Gender;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.Period;

/**
 * The type Person.
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "person")
public class Person {

    //TODO Create properly dto to avoid use entity class

    /**
     * The Id.
     */
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The Name.
     */
    @NotEmpty
    private String name;

    /**
     * The Birth date.
     */
    @NotNull
    @PastOrPresent
    @Column(name = "birth_date")
    private LocalDate birthDate;

    /**
     * The Active.
     */
    private Boolean active;

    /**
     * The Social name.
     */
    @Column(name = "social_name")
    private String socialName;

    /**
     * The Mother name.
     */
    @Column(name = "mother_name")
    private String motherName;

    /**
     * The Father name.
     */
    @Column(name = "father_name")
    private String fatherName;

    /**
     * The Gender.
     */
    @Enumerated(EnumType.STRING)
    private Gender gender;

    /**
     * The Create date.
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "create_date")
    @CreationTimestamp
    private OffsetDateTime createDate;

    /**
     * The Update date.
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "update_date")
    @UpdateTimestamp
    private OffsetDateTime updateDate;

    @OneToOne
    @JoinColumn(name = "fk_address")
    private Address address;

    /**
     * The Age.
     */
    @Transient
    private String age;

    /**
     * Gets age.
     *
     * @return the age
     */
    public String getAge() {

        if (birthDate != null) {
            LocalDate today = LocalDate.now();
            Period diff = Period.between(birthDate, today);

            age = diff.getYears() +
                    "Y " +
                    diff.getMonths() +
                    "M " +
                    diff.getDays() +
                    "D";
        }

        return age;
    }
}
