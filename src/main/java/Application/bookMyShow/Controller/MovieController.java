package Application.bookMyShow.Controller;

import Application.bookMyShow.DTOs.MovieEntryDTO;
import Application.bookMyShow.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody MovieEntryDTO movieEntryDTO){
        try{
            String response = movieService.addMovie(movieEntryDTO);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            String result = "Error Occured - Movie not able to add";
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
