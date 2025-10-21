package com.tuempresa.invoicing.model;

import javax.persistence.*;

import lombok.*;

@Embeddable
@Getter @Setter
public class Address {
	
	@Column(length=30)
	String stree;
	
	@Column(length=5)
	String zipCode;
	
	@Column(length=20)
	String city;
	
	@Column(length=30)
	String state;

	
}
