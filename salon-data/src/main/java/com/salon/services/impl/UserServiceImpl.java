package com.salon.services.impl;

import com.salon.dto.UserDto;
import com.salon.model.Authority;
import com.salon.model.User;
import com.salon.repository.AuthorityRepo;
import com.salon.repository.UserRepo;
import com.salon.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    private AuthorityRepo authorityRepo;
    private ModelMapper modelMapper;
    //private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(
            UserRepo userRepo
            , ModelMapper modelMapper
            ,AuthorityRepo authorityRepo) {
        this.userRepo = userRepo;
        this.modelMapper=modelMapper;
        this.authorityRepo=authorityRepo;
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

        User user = convertToUser(userDto);
        user.setAuthority(getAuthority(userDto));

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
}
