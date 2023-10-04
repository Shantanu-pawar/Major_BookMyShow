package Application.bookMyShow.Service;

import Application.bookMyShow.ConverterFunctions.UserConverter;
import Application.bookMyShow.DTOs.UserEntryDTO;
import Application.bookMyShow.Entity.UserEntity;
import Application.bookMyShow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDTO userEntryDTO) throws Exception, NullPointerException{
/* here we need to convert from DTO to object and save in DB - cause DTOs don't able to access the repo.
so we've created a converter function to do this work seperately.   */


        // since it's static function so we'll call via class name
        UserEntity userEntity = UserConverter.convertDtoToEntity(userEntryDTO);
        userRepository.save(userEntity);
        return "User added successfully.";
    }
}
