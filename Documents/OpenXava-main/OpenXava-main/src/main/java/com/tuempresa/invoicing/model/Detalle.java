package com.tuempresa.invoicing.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


 
@Embeddable @Getter @Setter

public class Detalle {
 
    int cantidad;
 
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    Product producto;
 
}