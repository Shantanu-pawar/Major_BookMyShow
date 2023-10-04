package Application.bookMyShow.DTOs;


import lombok.Data;

@Data // must require annotation to set getter setter and contructors.
public class UserEntryDTO {

    private String name;
    private int age;
    private String email;
    private String mobNo;
    private String address;
}
