package com.banque.kata.Entities;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Client {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private Double sold;
    public Client(Long id, String firstname, String lastname, Double sold) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.sold = sold;
    }
    @OneToMany(mappedBy = "client")
    private List<Historique> historiques = new ArrayList<>();
}
