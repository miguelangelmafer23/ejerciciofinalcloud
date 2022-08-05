package com.bosonit.BackWeb.Trip.infraestructure.repository;

import com.bosonit.BackWeb.Trip.domain.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {
}
