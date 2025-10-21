package com.tuempresa.invoicing.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter

@View(name="Simple", 
members="numero, nombre"
)
public class Customer {
	
	@Id
	@Column(length = 5)
	int number ;
	
	@Column(length=50)
	@Required
	String name;
	
	@Embedded @NoFrame
	Address addreess;

}
