package mk.finki.ukim.wp.labb2.repository.jpa;


import mk.finki.ukim.wp.labb2.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
