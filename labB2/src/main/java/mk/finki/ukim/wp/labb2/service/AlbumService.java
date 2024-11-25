package mk.finki.ukim.wp.labb2.service;


import mk.finki.ukim.wp.labb2.model.Album;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AlbumService {
    List<Album> findAll();
    Album findById(Long id);
}
