package com.ventaPro.ventaPro.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="Clientes")
@Getter @Setter @ToString @EqualsAndHashCode @NoArgsConstructor



public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Nombre")
    private String name;

    @Column(name = "Apellido")
    private String lastName;

    @Column(name = "DNI")
    private int docNumber;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cart> carts;



}



