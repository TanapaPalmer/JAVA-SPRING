package com.codingdojo.BurgerTrackerOne.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.BurgerTrackerOne.models.Burger;

@Repository
public interface BurgerTrackerRepository extends CrudRepository<Burger, Long>{
    // this method retrieves all the burger from the database
    List<Burger> findAll();

}
