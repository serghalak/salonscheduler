package com.salon.services.impl;

import com.salon.common.Utils;
import com.salon.dto.security.RoleDto;
import com.salon.dto.security.UserDto;
import com.salon.model.security.Role;
import com.salon.model.security.User;
import com.salon.repository.security.AuthorityRepo;
import com.salon.repository.security.UserRepo;
import com.salon.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    private AuthorityRepo authorityRepo;
    private ModelMapper modelMapper;
    private Utils utils;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(
            UserRepo userRepo
            , ModelMapper modelMapper
            , AuthorityRepo authorityRepo
            , Utils utils
            , PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
        this.authorityRepo = authorityRepo;
        this.utils = utils;
        this.passwordEncoder = passwordEncoder;
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
        //user.setAuthority(getAuthorityOnlyClient());
       user.setRoles(null);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
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


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }


    //--------------------------------------------
    private User convertToUser(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    private UserDto convertToUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

//    private Authority getAuthority(UserDto userDto) {
//        return authorityRepo
//                .findById(userDto.getAuthority().getId())
//                .get();
//    }
//
//    private Authority getAuthorityOnlyClient() {
//        return authorityRepo.findById(3L).get();
//    }

    private Set<Role>getRoles(UserDto userDto){
        Set<RoleDto> roles = userDto.getRoles();
        return null;
    }



    private void checkUserByEmail(UserDto userDto) {
        User userByEmail = userRepo.findByEmail(userDto.getEmail());
        if (userByEmail != null) {
            throw new /*DuplicateKeyException*/RuntimeException(
                    "Email: " + userDto.getEmail() + " is already exist");
        }
    }

    private void checkByUserName(UserDto userDto) {
        User userByUserName = userRepo.findByUsername(userDto.getUsername());
        if (userByUserName != null) {
            throw new /*DuplicateKeyException*/ RuntimeException(
                    "User name: " + userDto.getUsername() + " is already exist");
        }
    }

    private void checkUser(UserDto userDto) {
        checkUserByEmail(userDto);
        checkByUserName(userDto);
    }


}