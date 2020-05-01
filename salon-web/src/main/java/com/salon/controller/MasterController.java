package com.salon.controller;



import com.salon.dto.MasterDto;


import com.salon.dto.SpecializationDto;
import com.salon.services.MasterService;
import com.salon.services.impl.MasterServiceImpl;
import com.salon.ui.model.request.MasterRequest;

import com.salon.ui.model.request.SpecializationRequest;
import com.salon.ui.model.response.MasterResponse;
import com.salon.ui.model.response.SpecializationResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("api/masters")
public class MasterController {

    private MasterService masterService;
    private ModelMapper modelMapper;


    @Autowired
    public MasterController(MasterService masterService, ModelMapper modelMapper) {
        this.masterService = masterService;
        this.modelMapper = modelMapper;
    }

    @GetMapping/*(name = "",consumes = {},produces = {})*/
    public void getAllMasters(){
        System.out.println("api/masters/ all masters");
    }

    @PostMapping
    public MasterResponse createMaster(@RequestBody MasterRequest masterRequest){

        MasterDto masterDto = convertToMasterDto(masterRequest);
        MasterDto saveMasterDto = masterService.save(masterDto);
        MasterResponse saveClientResponse =convertToMasterResponse(saveMasterDto);
        return saveClientResponse;
    }



    private MasterDto convertToMasterDto(MasterRequest masterRequest){

        Set<SpecializationRequest> specializations = masterRequest.getSpecializations();
        //Type type = convertToSetSpecializations(specializations);
        Set<SpecializationDto>specializationDtos=new HashSet<>();
        for (SpecializationRequest specializationRequest : specializations){
            SpecializationDto specializationDto =
                    convertToSpecializationDto(specializationRequest);
            specializationDtos.add(specializationDto);
        }

        MasterDto map = modelMapper.map(masterRequest, MasterDto.class);
        map.setSpecializations(specializationDtos);
        return map;
    }

    private MasterResponse convertToMasterResponse(MasterDto masterDto){

        return modelMapper.map(masterDto,MasterResponse.class);
    }

//    private java.lang.reflect.Type convertToSetSpecializations(
//            Set<SpecializationRequest> specializationRequests){
//        java.lang.reflect.Type listType=
//                new TypeToken<Set<SpecializationRequest>>() {}.getType();
//        return modelMapper.map(specializationRequests, listType);
//    }

    private SpecializationDto convertToSpecializationDto(
            SpecializationRequest specializationRequest){
        return modelMapper.map(specializationRequest,SpecializationDto.class);
    }

    private SpecializationResponse convertToSpecializationResponse(
            SpecializationDto specializationDto){
        return modelMapper.map(specializationDto,SpecializationResponse.class);
    }
}
