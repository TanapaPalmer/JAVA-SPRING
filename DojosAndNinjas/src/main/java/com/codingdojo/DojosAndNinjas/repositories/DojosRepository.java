package com.codingdojo.DojosAndNinjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.DojosAndNinjas.models.DojosModel;

public interface DojosRepository extends CrudRepository<DojosModel, Long> {

	List<DojosModel> findAll();
}