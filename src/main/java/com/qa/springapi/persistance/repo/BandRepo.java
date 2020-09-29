package com.qa.springapi.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springapi.persistance.domain.Band;

@Repository
public interface BandRepo extends JpaRepository<Band, Long> {

}
