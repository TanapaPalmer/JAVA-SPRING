package com.codingdojo.Lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	
	// ALL SONGS
	public List<Song> findAll();
	
	// FIND BY ARTIST NAME
	public List<Song> findByArtistContaining(String artist);
	
	// FIND TOP 10 SONGS - ORDER THE RATE NUMBERS FROM 10-0
	public List<Song> findTop10ByOrderByRatingDesc();
}