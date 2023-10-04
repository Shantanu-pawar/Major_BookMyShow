package Application.bookMyShow.Controller;

import Application.bookMyShow.DTOs.TheaterEntryDTO;
import Application.bookMyShow.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterController {
    @Autowired
    TheaterService theaterService;

    @PostMapping("/add")
    public ResponseEntity<String> addTheater(@RequestBody TheaterEntryDTO theaterEntryDTO){
        try {
            String response = theaterService.addTheater(theaterEntryDTO);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            String result = "While creating theter some problm occuring";
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
