package com.salon.repository;


import com.salon.model.Master;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRepo extends PagingAndSortingRepository<Master,Long> {

//    List<Master> findMasterByFirstName(String firstName);
//    List<Master>findMasterByLastName(String lastName);
//    List<Master>findMasterBySpecializations(Specialization specialization);
    //User findMasterByUser(Master master);

}
