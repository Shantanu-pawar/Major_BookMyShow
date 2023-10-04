package Application.bookMyShow.ConverterFunctions;

import Application.bookMyShow.DTOs.UserEntryDTO;
import Application.bookMyShow.Entity.UserEntity;
import org.apache.catalina.User;

// the main purpose to create converter function here cause we're following clean code practices
public class UserConverter {

    // static is kept to avoid calling via objects  - space will be saved; this is the idea;
    public static UserEntity convertDtoToEntity(UserEntryDTO userEntryDTO){

        // in this builder function order does not matter
        UserEntity userEntity =  UserEntity.builder()
                .age(userEntryDTO.getAge()).mobNo(userEntryDTO.getMobNo())
                .name(userEntryDTO.getName()).email(userEntryDTO.getEmail()).address(userEntryDTO.getAddress())
                .build();

        return userEntity;
    }
}
