package com.banque.kata.Services.impl;

import com.banque.kata.Dao.ClientDao;
import com.banque.kata.Dao.HistoriqueDao;
import com.banque.kata.Entities.Client;
import com.banque.kata.Entities.Historique;
import com.banque.kata.Services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("clientServiceImpl")
@Transactional
public class ClientServiceImpl implements IClientService {

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private HistoriqueDao historiqueDao;


    @Override
    public String depot(Long clientId, Double montant) {
        String res = "Trancastion effectué avec Success";
        if (montant == 0.0)
            return "montant est null";
        Optional<Client> clientOpt = this.clientDao.findById(clientId);
        if (clientOpt.isPresent()) {
            clientOpt.get().setSold(clientOpt.get().getSold() + montant);
            this.clientDao.save(clientOpt.get());
            saveHistorique("Operation de depot", montant, clientOpt.get());
        } else {
            res = "Client inexistant";
        }
        return res;
    }

    @Override
    public String retrait(Long clientId, Double montant) {
        String res = "Trancastion effectué avec Success";
        if (montant == 0.0)
            return "montant est null";
        Optional<Client> clientOpt = this.clientDao.findById(clientId);
        if (clientOpt.isPresent()) {
            clientOpt.get().setSold(clientOpt.get().getSold() - montant);
            this.clientDao.save(clientOpt.get());
            saveHistorique("Operation de retrait", montant, clientOpt.get());
        } else {
            res = "Client inexistant";
        }
        return res;
    }

    @Override
    public List<Historique> ShowHistoryPerClient(Long clientId) {
        Optional<Client> clientOpt = this.clientDao.findById(clientId);
        if (clientOpt.isPresent()) {
            return clientOpt.get().getHistoriques();
        } else {
            return new ArrayList<>();
        }
    }

    private void saveHistorique(String operation, Double sold, Client client) {
        Historique historique = new Historique();
        historique.setClient(client);
        historique.setOperation(operation);
        historique.setMontant(sold);
        this.historiqueDao.save(historique);

    }
}
