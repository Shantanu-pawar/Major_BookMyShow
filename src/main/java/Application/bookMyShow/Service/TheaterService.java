package Application.bookMyShow.Service;

import Application.bookMyShow.ConverterFunctions.TheaterConverter;
import Application.bookMyShow.DTOs.TheaterEntryDTO;
import Application.bookMyShow.Entity.TheaterEntity;
import Application.bookMyShow.Entity.TheaterSeatEntity;
import Application.bookMyShow.Enums.SeatTypes;
import Application.bookMyShow.Repository.TheaterSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    public String addTheater(TheaterEntryDTO theaterEntryDTO) throws Exception, NullPointerException{
        TheaterEntity theaterEntity = TheaterConverter.convertTheaterDtoToEntity(theaterEntryDTO);

//  IMP NOTE : once we convert the dto into Entity for saving now here we've to set @OnetoOne mapping attributes to save that data
        // here we're setting theater Seats at the same time while saving the theater Entity.
        List<TheaterSeatEntity> theaterSeatEntityList = createTheaterSeats(theaterEntryDTO, theaterEntity);
        return "Theater added successfully";
    }

    // this will get us the count of classic and premium seats
    public List<TheaterSeatEntity> createTheaterSeats
    (TheaterEntryDTO theaterEntryDTO, TheaterEntity theaterEntity){

        int numPremiumSeats = theaterEntryDTO.getPremiumSeatCount();
        int numClassicSeats = theaterEntryDTO.getClassicSeatCount();

        List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<>();

        // created classic seats
        for(int count = 1; count <=numClassicSeats; count++){
            // we need to make a new theaterSeatEntity
            TheaterSeatEntity theaterSeatEntity = TheaterSeatEntity.builder()
                    .seatTypes(SeatTypes.Classic)
                    .seatNo(String.valueOf(count) + "C").theaterEntity(theaterEntity).build();

             theaterSeatEntityList.add(theaterSeatEntity);
        }

//        created premium seats
        for(int count = 1; count <=numPremiumSeats; count++){

            TheaterSeatEntity theaterSeatEntity = TheaterSeatEntity.builder()
                    .seatTypes(SeatTypes.Premium).seatNo(String.valueOf(count) + "P")
                    .theaterEntity(theaterEntity).build();

            theaterSeatEntityList.add(theaterSeatEntity);
        }

        // we can save this list all together
        theaterSeatRepository.saveAll(theaterSeatEntityList);
        return theaterSeatEntityList;
    }
}
