package com.salon.ui.model.response;

import java.util.HashSet;
import java.util.Set;


public class MasterResponse extends PersonResponse {



    private Set<SpecializationResponse> specializations=new HashSet<>();//specializationResponse;



    public Set<SpecializationResponse> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<SpecializationResponse> specializations) {
        this.specializations = specializations;
    }
}
