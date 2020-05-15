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
    public Set<MasterResponse> getAllMasters(){
        Set<MasterDto> masters = masterService.findAll();
        return convertToSetMasterResponse(masters);
    }

    @GetMapping(path = "/{id}")
    public MasterResponse getMasterById(@PathVariable("id")Long id){
        return convertToMasterResponse(masterService.findById(id));
    }

    @PostMapping
    public MasterResponse createMaster(@RequestBody MasterRequest masterRequest){
        MasterDto masterDto = convertToMasterDto(masterRequest);
        MasterDto saveMasterDto = masterService.save(masterDto);
        MasterResponse saveClientResponse =convertToMasterResponse(saveMasterDto);
        return saveClientResponse;
    }

    @DeleteMapping(path = "/{id}")
    public void deleteMasterById(@PathVariable("id")Long id){

    }
////----------------------------------------------------------------------------------------
    private Set<MasterResponse>convertToSetMasterResponse(Set<MasterDto> masters){
        Set<MasterResponse>masterResponses=new HashSet<>();
        for(MasterDto masterDto : masters){
            masterResponses.add(convertToMasterResponse(masterDto));
        }
        return masterResponses;
    }

    private MasterDto convertToMasterDto(MasterRequest masterRequest){

//        Set<SpecializationRequest> specializations = masterRequest.getSpecializations();
//        //Type type = convertToSetSpecializations(specializations);
//        Set<SpecializationDto>specializationDtos=new HashSet<>();
//        for (SpecializationRequest specializationRequest : specializations){
//            SpecializationDto specializationDto =
//                    convertToSpecializationDto(specializationRequest);
//            specializationDtos.add(specializationDto);
//        }
//
//        MasterDto map = modelMapper.map(masterRequest, MasterDto.class);
//        map.setSpecializations(specializationDtos);
//        return map;
        return modelMapper.map(masterRequest,MasterDto.class);
    }

    private MasterResponse convertToMasterResponse(MasterDto masterDto){
//        masterDto.getSpecializations().stream().map(
//                specializationDto -> convertToSpecializationDto(specializationDto))

        Set<SpecializationDto> specializations = masterDto.getSpecializations();
        Set<SpecializationResponse>specializationResponses=new HashSet<>();
        for (SpecializationDto specializationDto: specializations) {
            SpecializationResponse specializationResponse =
                    convertToSpecializationResponse(specializationDto);
            specializationResponses.add(specializationResponse);
        }

        MasterResponse map = modelMapper.map(masterDto, MasterResponse.class);
        map.setSpecializations(specializationResponses);
        return map;
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
