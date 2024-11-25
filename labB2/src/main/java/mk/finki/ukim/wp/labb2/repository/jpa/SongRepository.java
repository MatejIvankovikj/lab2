package mk.finki.ukim.wp.labb2.repository.jpa;

import mk.finki.ukim.wp.labb2.model.Artist;
import mk.finki.ukim.wp.labb2.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

}
