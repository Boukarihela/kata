package com.banque.kata.Entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Historique {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String operation;
    @CreationTimestamp
    private LocalDateTime date;
    private Double montant;

    @ManyToOne()
    @JoinColumn(name = "client_id")
    private Client client;
}
