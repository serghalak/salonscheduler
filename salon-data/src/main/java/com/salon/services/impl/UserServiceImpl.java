package com.salon.services.impl;

import com.salon.common.Utils;
import com.salon.dto.UserDto;
import com.salon.model.Authority;
import com.salon.model.User;
import com.salon.repository.AuthorityRepo;
import com.salon.repository.UserRepo;
import com.salon.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    private AuthorityRepo authorityRepo;
    private ModelMapper modelMapper;
    private Utils  utils;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(
            UserRepo userRepo
            , ModelMapper modelMapper
            ,AuthorityRepo authorityRepo
            ,Utils utils,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepo = userRepo;
        this.modelMapper=modelMapper;
        this.authorityRepo=authorityRepo;
        this.utils=utils;

    }

    @Override
    public Set<UserDto> findAll() {
        return null;
    }

    @Override
    public UserDto findById(Long aLong) {
        return null;
    }

    @Override
    public UserDto save(UserDto userDto) {

        //check for duplicates email or username
        checkUser(userDto);

        User user = convertToUser(userDto);
        //user.setAuthority(getAuthority(userDto));
        user.setActive(false);
        user.setAuthority(getAuthorityOnlyClient());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        user.setUserId(utils.generateUserId());
        //


        User savedUser = userRepo.save(user);
        UserDto userSavedDto = convertToUserDto(savedUser);

        return userSavedDto;
    }

    @Override
    public void delete(UserDto object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }


    //--------------------------------------------
    private User convertToUser(UserDto userDto){
        return modelMapper.map(userDto,User.class);
    }

    private UserDto convertToUserDto(User user){
        return modelMapper.map(user,UserDto.class);
    }

    private Authority getAuthority(UserDto userDto){
        return authorityRepo
                .findById(userDto.getAuthority().getId())
                .get();
    }

    private Authority getAuthorityOnlyClient(){
        return authorityRepo.findById(3L).get();
    }

    private void checkUserByEmail(UserDto userDto){
        User userByEmail = userRepo.findByEmail(userDto.getEmail());
        if(userByEmail !=null){
            throw new /*DuplicateKeyException*/RuntimeException(
                    "Email: " + userDto.getEmail()+" is already exist");
        }
    }
    private void checkByUserName(UserDto userDto){
        User userByUserName = userRepo.findByUserName(userDto.getUserName());
        if(userByUserName !=null){
            throw new /*DuplicateKeyException*/ RuntimeException(
                    "User name: " + userDto.getUserName()+" is already exist");
        }
    }

    private void checkUser(UserDto userDto){
        checkUserByEmail(userDto);
        checkByUserName(userDto);
    }
}
