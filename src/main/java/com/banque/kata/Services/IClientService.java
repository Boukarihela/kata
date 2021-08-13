package com.banque.kata.Services;

import com.banque.kata.Entities.Client;
import com.banque.kata.Entities.Historique;

import java.util.List;

public interface IClientService {

    String depot ( Long clientId ,Double solde );

    String retrait ( Long clientId,Double solde);

    List<Historique> ShowHistoryPerClient(Long clientId);
}
