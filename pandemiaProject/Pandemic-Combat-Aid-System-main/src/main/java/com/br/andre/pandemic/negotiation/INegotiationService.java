package com.br.andre.pandemic.negotiation;

import com.br.andre.pandemic.negotiation.involved.InvolvedHospitalDTO;

public interface INegotiationService {

    void negotiationHospitals(InvolvedHospitalDTO solicitorHospital, InvolvedHospitalDTO receptorHospital);
}
