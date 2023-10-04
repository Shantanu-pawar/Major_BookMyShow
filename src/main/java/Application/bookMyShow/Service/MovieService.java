package Application.bookMyShow.Service;

import Application.bookMyShow.ConverterFunctions.MovieConverter;
import Application.bookMyShow.DTOs.MovieEntryDTO;
import Application.bookMyShow.Entity.MovieEntity;
import Application.bookMyShow.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieEntryDTO movieEntryDTO) throws NullPointerException, Exception{
        MovieEntity movieEntity = MovieConverter.ConvertMovieDtotoEntity(movieEntryDTO);

        movieRepository.save(movieEntity);
        return "Movie added successfully";
    }

}
