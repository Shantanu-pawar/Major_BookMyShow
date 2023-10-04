package Application.bookMyShow.ConverterFunctions;

import Application.bookMyShow.DTOs.MovieEntryDTO;
import Application.bookMyShow.Entity.MovieEntity;

public class MovieConverter {

    public static MovieEntity ConvertMovieDtotoEntity(MovieEntryDTO movieEntryDTO){

        MovieEntity movieEntity = MovieEntity.builder()
                .movieName(movieEntryDTO.getMovieName())
                .rating(movieEntryDTO.getRating())
                .duration(movieEntryDTO.getDuration())
                .genre(movieEntryDTO.getGenre()).language(movieEntryDTO.getLanguage()).build();

        return movieEntity;
    }
}
