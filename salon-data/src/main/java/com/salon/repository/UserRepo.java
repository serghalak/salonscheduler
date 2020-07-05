package com.salon.repository;



import com.salon.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo
        extends PagingAndSortingRepository<User, Long> {

      User findByEmail(String email);
      User findByPhoneNumber(String phoneNumber);

      User findByUserName(String userName);
      User findByUserId(String userId);
      User findByActivateCode(String code);

//    Page<User> findByActive(Boolean isActive, Pageable pageable);
}
