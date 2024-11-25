package mk.finki.ukim.wp.labb2.service.impl;

import mk.finki.ukim.wp.labb2.model.Album;
import mk.finki.ukim.wp.labb2.repository.jpa.AlbumRepository;
import mk.finki.ukim.wp.labb2.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Album findById(Long id) {
        return albumRepository.findById(id).orElse(null);
    }
}
