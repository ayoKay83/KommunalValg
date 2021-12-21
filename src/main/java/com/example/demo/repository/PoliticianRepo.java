package com.example.demo.repository;

import com.example.demo.model.Politician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoliticianRepo extends CrudRepository<Politician, Long> {

    Iterable<Politician> findPoliticiansByPartyPartyId(Long partyId);
}
