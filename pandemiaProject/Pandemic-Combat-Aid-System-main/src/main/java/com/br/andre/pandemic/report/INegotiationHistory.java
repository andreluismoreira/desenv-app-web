package com.br.andre.pandemic.report;

import com.br.andre.pandemic.hospital.Hospital;

import java.util.List;

public interface INegotiationHistory {

    List<String> saveNegotiationHistory(Hospital solicitor, Hospital receptor);

    List<String> makeNegotiationHistory();
}
