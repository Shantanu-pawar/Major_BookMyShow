package Application.bookMyShow.Service;

import Application.bookMyShow.DTOs.UserEntryDTO;
import Application.bookMyShow.Entity.UserEntity;
import Application.bookMyShow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(UserEntryDTO userEntryDTO){
    // here we need to convert from DTO to object and save in DB - cause DTOs don't able to access the repo.

        // this is the convenient way to build the obj and save it
        UserEntity userEntity = UserEntity.builder()
                .mobNo(userEntryDTO.getMobNo())
                .age(userEntryDTO.getAge())
                .name(userEntryDTO.getName())
                .address(userEntryDTO.getAddress())
                .email(userEntryDTO.getEmail())
                .build();

        // this set's all the attributes in one go
        userRepository.save(userEntity);

    }
}
