package com.tuempresa.invoicing.model;

import java.math.*;

import javax.persistence.*;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter

public class Product {
	
	@Id
	@Column(length=3)
	int number;
	
	@Required
	@Column(length=50)
	String Description;
	
	@ManyToOne(
		fetch=FetchType.LAZY,
		optional=true)
	@DescriptionsList		
	Category category;
	
	@Money
	BigDecimal price;
	
	@Files
	@Column(length=32)
	String photos;
	
	@TextArea
	String remarks;

}
