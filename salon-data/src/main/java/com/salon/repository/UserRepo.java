package com.salon.repository;



import com.salon.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo
        extends PagingAndSortingRepository<User, Long> {

//    User findByPerson_Email(String email);
//    User findByPerson_PhoneNumber(String phoneNumber);
//    //User findByClient_Email(String email);
//
//    //User findById(Long id);
//    User findByUserName(String userName);
//    User findByUserId(String userId);
//    User findByActivateCode(String code);
//    //User findByMaster_PhoneNumber(String phoneNumber);
//    Page<User> findByActive(Boolean isActive, Pageable pageable);
}
