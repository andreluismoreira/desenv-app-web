package com.br.andre.pandemic.report;

import com.br.andre.pandemic.hospital.Hospital;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NegotiationHistoryImpl implements INegotiationHistory{

    List<String> list = new ArrayList<>();

    @Override
    public List<String> saveNegotiationHistory(Hospital solicitor, Hospital receptor) {
        this.list.add("Foi Realizado intercambio entre: " + solicitor.getName() + " e " + receptor.getName());
        return this.list;
    }

    @Override
    public List<String> makeNegotiationHistory() {
        return this.list;
    }

}
