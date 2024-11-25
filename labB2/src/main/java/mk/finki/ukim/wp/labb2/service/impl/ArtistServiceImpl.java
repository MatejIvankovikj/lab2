package mk.finki.ukim.wp.labb2.service.impl;

import mk.finki.ukim.wp.labb2.model.Artist;
import mk.finki.ukim.wp.labb2.repository.jpa.ArtistRepository;
import mk.finki.ukim.wp.labb2.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> listArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Optional<Artist> ArtistFindById(Long id) {
        return artistRepository.findById(id);
    }

}
