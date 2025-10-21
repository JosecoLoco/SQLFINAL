package com.tuempresa.invoicing.model;

import java.time.*;
import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;
import org.openxava.calculators.CurrentLocalDateCalculator;
import org.openxava.calculators.CurrentYearCalculator;

import com.yourcompany.invoicing.calculators.NextNumberForYearCalculator;

import lombok.*;

@Entity 
@Getter 
@Setter
@View(members="year, number, date, customer, remarks")
public class Invoice {
    
    @Id
    @GeneratedValue(generator="system-uuid")
    @Hidden
    @GenericGenerator(name="system-uuid", strategy="uuid")
    @Column(length=32)
    String oid;
    
    @Column(length=4)
    @DefaultValueCalculator(CurrentYearCalculator.class)
    int year;
    
    @Column(length=6)
    @DefaultValueCalculator(
        value=NextNumberForYearCalculator.class, 
        properties=@PropertyValue(name="year")
    )
    int number;
    
    @org.openxava.annotations.Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class)
    LocalDate date;
    
    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    Customer customer;
    
    @Stereotype("MEMO")
    String remarks;
}