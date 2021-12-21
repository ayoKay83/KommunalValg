package com.example.demo.controller;

import com.example.demo.model.Party;
import com.example.demo.model.Politician;
import com.example.demo.repository.PoliticianRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RestControllerTest {

        @Mock //vi laver et mockup af vores repo
        PoliticianRepo politicianRepo;

        @InjectMocks
        RestController restController;

        @BeforeEach
        void setup(){
            MockitoAnnotations.initMocks(this);

            List<Politician> politicians = new ArrayList<>();

            Party party1 = new Party(1L, 'A', "Socialdemokratiet", politicians);
            Party party2 = new Party(2L, 'C', "Det Konservative Folkeparti", politicians);

            Politician politician1 = new Politician(1L, "Børge Mogensen",party1, 46);
            Politician politician2 = new Politician(2L, "Anders Andersen", party1, 76);
            Politician politician3 = new Politician(3L, "Signe Heidi", party2, 764);

            politicians.add(politician1);
            politicians.add(politician2);
            politicians.add(politician3);

            Mockito.when(politicianRepo.findAll()).thenReturn(politicians);

        }

    @Test
    void findAllPoliticians() {
    }

    @Test
    void newPolitician() {
    }

    @Test
    void updatePolitician() {
    }
}