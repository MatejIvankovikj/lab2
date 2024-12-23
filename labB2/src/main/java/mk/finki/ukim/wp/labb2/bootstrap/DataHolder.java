package mk.finki.ukim.wp.labb2.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.wp.labb2.model.Album;
import mk.finki.ukim.wp.labb2.model.Artist;
import mk.finki.ukim.wp.labb2.model.Song;
import mk.finki.ukim.wp.labb2.repository.jpa.AlbumRepository;
import mk.finki.ukim.wp.labb2.repository.jpa.ArtistRepository;
import mk.finki.ukim.wp.labb2.repository.jpa.SongRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class DataHolder {
    public static List<Artist> artistList;
    public static List<Song> songs;
    public static List<Album> albums;

    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;

    public DataHolder(SongRepository songRepository, ArtistRepository artistRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }


    @PostConstruct
    public void init() {
        artistList = new ArrayList<>();
        artistList.add(new Artist("Adele", "", "Anglija"));
        artistList.add(new Artist("Lady", "Gaga", "Amerika"));
        artistList.add(new Artist("Arctic", "Monkeys", "Grcka"));
        artistList.add(new Artist("Pero", "Zdero", "Bardovci"));
        artistList.add(new Artist("Matej", "Ivankovic", "Makedonija"));

        if (this.artistRepository.count() == 0) {
            this.artistRepository.saveAll(artistList);
        }

        songs = new ArrayList<>();
        songs.add(new Song("Tastatura", "rock", 2017, artistList.stream().filter(a -> a.getFirstName().startsWith("M")).collect(Collectors.toList())));
        songs.add(new Song("Jabolka", "metal", 2019, artistList.stream().filter(a -> a.getFirstName().startsWith("I")).collect(Collectors.toList())));
        songs.add(new Song("Kolachi", "pop", 2014, artistList.stream().filter(a -> a.getFirstName().startsWith("D")).collect(Collectors.toList())));

        albums=new ArrayList<>();
        albums.add(new Album("Album 1", "Rock", "2023"));
        albums.add(new Album("Album 2", "Pop", "2016"));
        albums.add(new Album("Album 3", "Metal", "2019"));
        albums.add(new Album("Album 4", "Trance", "2020"));
        albums.add(new Album("Album 5", "Disco", "2022"));

        if (this.albumRepository.count() == 0) {
            this.albumRepository.saveAll(albums);
        }

        Random random = new Random();
        songs.forEach(song -> {
            int randomIndex = random.nextInt(albumRepository.findAll().size());
            Album randomAlbum = albumRepository.findAll().get(randomIndex);
            song.setAlbum(randomAlbum);
        });


        if (this.songRepository.count() == 0) {
            this.songRepository.saveAll(songs);
        }
    }

}
