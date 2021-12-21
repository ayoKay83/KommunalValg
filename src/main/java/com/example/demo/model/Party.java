package com.example.demo.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;

@Entity
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "party_id")
    private Long partyId;

    private char partyLetter;
    private String partyName;

    @OneToMany(mappedBy = "party")
    @JsonBackReference
    private List<Politician> politicianList;

    public Party(){}

    public Party(Long partyId, char partyLetter, String partyName, List<Politician> politicianList) {
        this.partyId = partyId;
        this.partyLetter = partyLetter;
        this.partyName = partyName;
        this.politicianList = politicianList;
    }



    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public char getPartyLetter() {
        return partyLetter;
    }

    public void setPartyLetter(char partyLetter) {
        this.partyLetter = partyLetter;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public List<Politician> getPoliticianList() {
        return politicianList;
    }

    public void setPoliticianList(List<Politician> politicianList) {
        this.politicianList = politicianList;
    }
}
