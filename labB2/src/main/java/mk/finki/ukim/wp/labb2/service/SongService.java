package mk.finki.ukim.wp.labb2.service;

import mk.finki.ukim.wp.labb2.model.Artist;
import mk.finki.ukim.wp.labb2.model.Song;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SongService{
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    Song findById(Long id);

    void save(Song song);
    void delete(Long id);
}