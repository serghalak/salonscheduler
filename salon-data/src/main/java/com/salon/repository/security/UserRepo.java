package com.salon.repository.security;



import com.salon.model.security.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo
        extends PagingAndSortingRepository<User, Long> {

      User findByEmail(String email);
      User findByPhoneNumber(String phoneNumber);

      User findByUsername(String username);
      User findByUserId(String userId);
      User findByActivateCode(String code);

//    Page<User> findByActive(Boolean isActive, Pageable pageable);
}
