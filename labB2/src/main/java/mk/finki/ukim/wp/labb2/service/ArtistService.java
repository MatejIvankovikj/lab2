package mk.finki.ukim.wp.labb2.service;

import mk.finki.ukim.wp.labb2.model.Artist;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ArtistService{
    List<Artist> listArtists();
    Optional<Artist> ArtistFindById(Long id);
}