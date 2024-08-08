package com.ventaPro.ventaPro.entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Productos")
@Setter @Getter @EqualsAndHashCode @NoArgsConstructor @ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Precio")
    private double price;

    @Column(name="Nombre")
    private String title;

    @Column(name="Cantidad_Stock")
    private int stock;

    @Column(name="Descripcion")
    private String description;

    @Column(name="Categoria")
    private String category;

    @Column(name="Marca")
    private String brand;

//    @ManyToOne
//    @JoinColumn(name = "cart_id", referencedColumnName = "id")
//    private Cart cart;
}
