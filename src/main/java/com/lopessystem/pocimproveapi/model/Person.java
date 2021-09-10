package com.lopessystem.pocimproveapi.model;

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
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.Period;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "person")
public class Person {

    //TODO Create properly dto to avoid use entity class

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @NotNull
    @PastOrPresent
    @Column(name = "birth_date")
    private LocalDate birthDate;

    private Boolean active;

    @Column(name = "social_name")
    private String socialName;

    @Column(name = "mother_name")
    private String motherName;

    @Column(name = "father_name")
    private String fatherName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "initial_date")
    @CreationTimestamp
    private OffsetDateTime createDate;

    @Column(name = "update_date")
    @UpdateTimestamp
    private OffsetDateTime updateDate;

    @Transient
    private String age;

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
