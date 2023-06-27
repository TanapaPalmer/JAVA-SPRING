package com.codingdojo.DojosAndNinjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.DojosAndNinjas.models.DojosModel;
import com.codingdojo.DojosAndNinjas.models.NinjasModel;

public interface NinjasRepository extends CrudRepository<NinjasModel, Long> {
	
	List<NinjasModel> findAll();
	List<NinjasModel> findAllByDojo(DojosModel dojo);
}