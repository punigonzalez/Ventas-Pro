package com.ventaPro.ventaPro.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="Carritos")
@Getter @Setter @ToString @EqualsAndHashCode @NoArgsConstructor

public class Cart {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne ()
    @Column(name="Id Cliente")
    private long client_id;

    @Column(name="Precio")
    private double price;

    @Column(name="Cantidad")
    private int amount;

    @Column(name="Entregado")
    private boolean delivered;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;

}
