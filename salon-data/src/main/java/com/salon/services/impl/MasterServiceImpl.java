package com.salon.services.impl;


import com.salon.dto.ClientDto;
import com.salon.dto.MasterDto;

import com.salon.model.Client;
import com.salon.model.Master;
import com.salon.repository.MasterRepo;
import com.salon.services.MasterService;
import org.modelmapper.ModelMapper;

import java.util.Set;

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
        return null;
    }

    @Override
    public MasterDto findById(Long aLong) {
        return null;
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


    private Master convertToMaster(MasterDto masterDto){
        return modelMapper.map(masterDto,Master.class);
    }

    private MasterDto convertToMasterDto(Master master)   {
        return modelMapper.map(master,MasterDto.class);
    }
}
