package com.codingdojo.BookClub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.BookClub.models.BookClub;

@Repository
public interface BookClubRepository extends CrudRepository<BookClub, Long> {

	List<BookClub> findAll();
}
