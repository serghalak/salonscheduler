package com.salon.dto;


import java.util.HashSet;
import java.util.Set;

public class MasterDto extends PersonDto {

    private Set<SpecializationDto> specializations
            =new HashSet<>();//specializationDtoList;

    public Set<SpecializationDto> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<SpecializationDto> specializations) {
        this.specializations = specializations;
    }


}
