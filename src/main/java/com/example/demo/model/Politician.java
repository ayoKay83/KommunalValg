package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
public class Politician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "politician_id")
    private Long politicianId;

    private String name;

    @ManyToOne
    @JoinColumn(name="party_id", referencedColumnName = "party_id")
    private Party party;

    private int nbOfVotes;

    public Politician(){}

    public Politician(Long politicianId, String name, Party party, int nbOfVotes) {
        this.politicianId = politicianId;
        this.name = name;
        this.party = party;
        this.nbOfVotes = nbOfVotes;
    }

    public Long getPoliticianId() {
        return politicianId;
    }

    public void setPoliticianId(Long politicianId) {
        this.politicianId = politicianId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public int getNbOfVotes() {
        return nbOfVotes;
    }
    public void setNbOfVotes(int nbOfVotes) {
        this.nbOfVotes = nbOfVotes;
    }

    @Override
    public String toString() {
        return "Politician{" +
                "politicianId=" + politicianId +
                ", name='" + name + '\'' +
                ", party=" + party +
                ", nbOfVotes=" + nbOfVotes +
                '}';
    }

}
