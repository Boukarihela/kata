package com.banque.kata.Dao;

import com.banque.kata.Entities.Client;
import com.banque.kata.Entities.Historique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriqueDao extends JpaRepository<Historique, Long> {

}
