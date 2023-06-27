package com.codingdojo.Lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.Lookify.models.Song;
import com.codingdojo.Lookify.repositories.SongRepository;

@Service
public class SongService {
	
	@Autowired
	private SongRepository songRepository;
	
//**********************************************************************************************
	
	// RETRIEVE ALL SONGS
	public List<Song> allSongs(){
		return songRepository.findAll();
	}
	
//**********************************************************************************************
	
	// ADD NEW SONGS
	public Song addSong(Song song) {
		return songRepository.save(song);
	}

//**********************************************************************************************
	
	// RETRIEVE AN ARTIST
	public List<Song> findByArtist(String artist) {
		return songRepository.findByArtistContaining(artist);
	}
	
//**********************************************************************************************
	
	// RETRIEVE A SONG
	public Song songById(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		}
		return null;
	}
	
//**********************************************************************************************
	
	// DELETE A SONG
	public void deleteSong(Song song) {
		songRepository.delete(song);
	}

//**********************************************************************************************
	
	// FIND TOP 10 SONGS
	public List<Song> findTopTen() {
		return songRepository.findTop10ByOrderByRatingDesc();
	}
}

