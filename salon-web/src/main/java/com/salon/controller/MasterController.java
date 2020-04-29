package com.salon.controller;



import com.salon.dto.MasterDto;


import com.salon.services.MasterService;
import com.salon.services.impl.MasterServiceImpl;
import com.salon.ui.model.request.MasterRequest;

import com.salon.ui.model.response.MasterResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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


        MasterDto masterDto = modelMapper.map(masterRequest, MasterDto.class);
        MasterDto saveMasterDto = masterService.save(masterDto);
        MasterResponse saveClientResponse = modelMapper.map(saveMasterDto, MasterResponse.class);
        return saveClientResponse;
    }



    private MasterDto convertToMasterDto(MasterRequest masterRequest){
        return modelMapper.map(masterRequest,MasterDto.class);
    }

    private MasterResponse convertToMasterResponse(MasterDto masterDto){
        return modelMapper.map(masterDto,MasterResponse.class);
    }

}
