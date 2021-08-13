package com.banque.kata.Controller;


import com.banque.kata.Entities.Historique;
import com.banque.kata.Services.IClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private IClientService clientService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/depot/{clientId}/{montant}", method = RequestMethod.POST)
    public ResponseEntity<String> depotSolde(@PathVariable("clientId") Long clientId, @PathVariable("montant") Double montant) {
        logger.debug("Invocation de la resource : POST /depot/{clientId}/{montant}");
        String res = clientService.depot(clientId, montant);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = "/retrait/{clientId}/{montant}", method = RequestMethod.POST)
    public ResponseEntity<String> retraitSolde(@PathVariable("clientId") Long clientId, @PathVariable("montant") Double montant) {
        logger.debug("Invocation de la resource : POST /depot/{clientId}/{montant}");
        String res = clientService.retrait(clientId, montant);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = "/history/{clientId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getHistory(@PathVariable("clientId") Long clientId) {
        logger.debug("Invocation de la resource : GET /history/{clientId}");
        ArrayList<Historique> historyList = (ArrayList<Historique>) clientService.ShowHistoryPerClient(clientId);
        if (historyList == null) {
            logger.info("Impossible de récupérer l'historique");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
