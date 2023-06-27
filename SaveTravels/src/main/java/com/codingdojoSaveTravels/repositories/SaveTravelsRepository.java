package com.codingdojoSaveTravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojoSaveTravels.models.Expense;

@Repository
public interface SaveTravelsRepository extends CrudRepository<Expense, Long>{
	
	List<Expense> findAll();
}
