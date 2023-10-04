package Application.bookMyShow.ConverterFunctions;

import Application.bookMyShow.DTOs.TheaterEntryDTO;
import Application.bookMyShow.Entity.TheaterEntity;

public class TheaterConverter {

    public static TheaterEntity convertTheaterDtoToEntity(TheaterEntryDTO theaterEntryDTO){
        TheaterEntity theaterEntity = TheaterEntity.builder()
                .name(theaterEntryDTO.getName())
                .location(theaterEntryDTO.getLocation()).build();

        return theaterEntity;
    }
}
