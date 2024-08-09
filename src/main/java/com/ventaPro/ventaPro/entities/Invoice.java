package com.ventaPro.ventaPro.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "Facturas")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString @EqualsAndHashCode

public class Invoice {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;

    private Double total;
    private Date createdAt;

}
