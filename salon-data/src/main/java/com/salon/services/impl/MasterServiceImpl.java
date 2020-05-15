package com.salon.services.impl;

import com.salon.dto.MasterDto;
import com.salon.model.Master;
import com.salon.repository.MasterRepo;

import com.salon.services.MasterService;
import com.salon.ui.model.response.SpecializationResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Optional;
import java.util.Set;

@Service
public class MasterServiceImpl implements MasterService {

    private MasterRepo masterRepo;
    private ModelMapper modelMapper;

    public MasterServiceImpl(MasterRepo masterRepo
            ,ModelMapper modelMapper) {
        this.masterRepo = masterRepo;
        this.modelMapper=modelMapper;
    }

    @Override
    public Set<MasterDto> findAll() {
        //return convertToSetMasterDto(masterRepo.findAll());
        return convertToSetMasterDto(masterRepo.findByIsActiveTrue());
    }

    @Override
    public MasterDto findById(Long id) {
        Optional<Master> master = masterRepo.findById(id);
        return convertToMasterDto(master.get());
    }

    @Override
    public MasterDto save(MasterDto masterDto) {
        Master master = convertToMaster(masterDto);
        Master saveMaster = masterRepo.save(master);
        MasterDto saveMasterDto = convertToMasterDto(saveMaster);
        return saveMasterDto;
    }

    @Override
    public void delete(MasterDto object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

//----------------------------------------------------------------
    private Master convertToMaster(MasterDto masterDto){
        return modelMapper.map(masterDto,Master.class);
    }

    private MasterDto convertToMasterDto(Master master)   {
        return modelMapper.map(master,MasterDto.class);
    }

    private Set<MasterDto>convertToSetMasterDto(Iterable<Master>masters){
        Type listType=new TypeToken<Set<MasterDto>>() {}.getType();
        return modelMapper.map(masters,listType);
    }
}
