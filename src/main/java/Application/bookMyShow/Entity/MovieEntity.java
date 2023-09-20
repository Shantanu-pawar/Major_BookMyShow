package Application.bookMyShow.Entity;

import Application.bookMyShow.Enums.Genre;
import Application.bookMyShow.Enums.Language;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
@Data
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String movieName;

    private double rating;

    private int duration;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @Enumerated(value = EnumType.STRING)
    private Language language;

    // this is parent wrt to show
    @OneToMany(mappedBy = "movieEntity", cascade = CascadeType.ALL)
    // and since there is multiple list of shows for the movie that's why we're creating this list
    private List<ShowEntity> showEntityList = new ArrayList<>();
    // remember always pass the other entity in this list
}
