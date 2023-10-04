package Application.bookMyShow.DTOs;

import Application.bookMyShow.Enums.Genre;
import Application.bookMyShow.Enums.Language;
import lombok.Data;

@Data // must require annotation to set getter setter and contructors.
public class MovieEntryDTO {

    private String movieName;
    private double rating;
    private int duration;
    private Genre genre;
    private Language language;
}
