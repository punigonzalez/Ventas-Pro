package com.ventaPro.ventaPro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="Carritos")
@Getter @Setter @ToString @EqualsAndHashCode @NoArgsConstructor @AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Precio")
    private Double price;

    @Column(name="Cantidad")
    private Integer amount;

    @Column(name="Entregado")
    private Boolean delivered;

   @ManyToOne
   @JoinColumn(name = "client_id", referencedColumnName = "id")
   @JsonIgnore
   private Client client;

    @ManyToOne
    @JoinColumn (name = "product_id", referencedColumnName = "id")
    @JsonIgnore
    private Product product;
}



