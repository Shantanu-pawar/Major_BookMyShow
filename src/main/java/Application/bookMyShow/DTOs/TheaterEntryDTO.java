package Application.bookMyShow.DTOs;

import lombok.Data;

@Data
public class TheaterEntryDTO {
     private String name;
     private String location;

     // extra attributes we actually required.
     private int premiumSeatCount;

     private int classicSeatCount;

}