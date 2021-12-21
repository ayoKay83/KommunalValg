package com.example.demo.controller;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Party;
import com.example.demo.model.Politician;
import com.example.demo.repository.PartyRepo;
import com.example.demo.repository.PoliticianRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Part;
import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin("*")
public class RestController {

    private PoliticianRepo politicianRepo;
    private PartyRepo partyRepo;

    public RestController(PoliticianRepo politicianRepo, PartyRepo partyRepo) {
        this.politicianRepo = politicianRepo;
        this.partyRepo = partyRepo;
    }
    @GetMapping("/parties")
    public ResponseEntity<List<Party>> findAllParties() {
        List<Party> parties = new ArrayList<>();
        partyRepo.findAll().forEach(party -> parties.add(party));
        return ResponseEntity.status(HttpStatus.OK).body(parties);
    }
    @GetMapping("/parties/{partyId}")
    public ResponseEntity<Optional<Party>> findSpecificParty(@PathVariable Long partyId){
        Optional<Party> party = partyRepo.findById(partyId);
        return ResponseEntity.status(HttpStatus.OK).body(party);
    }

    @GetMapping("/politicians")
    public ResponseEntity<List<Politician>> findAllPoliticians() {
        List<Politician> politicians = new ArrayList<>();
        politicianRepo.findAll().forEach(politician -> politicians.add(politician));
        return ResponseEntity.status(HttpStatus.OK).body(politicians);
    }

    @GetMapping("/politicians/{partyId}")
    public Iterable<Politician> politicianByPartyId(@PathVariable Long partyId) {
        return politicianRepo.findPoliticiansByPartyPartyId(partyId);
}


    @PostMapping(value="/politicians/{partyId}", consumes = "application/json")
    public ResponseEntity<Politician> newPolitician(@PathVariable Long partyId, @RequestBody Politician newPolitician) {
        newPolitician.setParty(partyRepo.findById(partyId).get());
        politicianRepo.save(newPolitician);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPolitician);
    }
    @PutMapping("politicians/{politicianId}")
    public ResponseEntity<Politician> updatePolitician(@PathVariable Long politicianId, @RequestBody Politician politician) {
        politician.setPoliticianId(politicianId);
        politicianRepo.save(politician);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/politicians/{politicianId}")
        public ResponseEntity<String> deletePolitician(@PathVariable Long politicianId) {
        Optional<Politician> optionalPolitician = politicianRepo.findById(politicianId);
        if (optionalPolitician.isPresent()){
            politicianRepo.deleteById(politicianId);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}

