package com.salon.repository;


import com.salon.model.Specialization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationRepo extends CrudRepository<Specialization,Long> {
//    Set<Specialization>findAllByMaster(Master master);
//    Set<Specialization>findAllByUser(User user);

    //Specialization findById(long id);
}
