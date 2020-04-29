package com.salon.ui.model.request;


import java.util.HashSet;
import java.util.Set;

public class MasterRequest extends PersonRequest {

    protected Set<SpecializationRequest> specializations=new HashSet<>();//specializationRequests;

    public Set<SpecializationRequest> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<SpecializationRequest> specializations) {
        this.specializations = specializations;
    }
}
