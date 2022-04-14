package com.github.jsofosu;

import java.util.ArrayList;
import java.util.List;

public class Day1 {
    public  int calculateFrequency(List<Integer> frequencies){
        int resultingFrequency =0;
        for (int i = 0; i < frequencies.size(); i++){
            resultingFrequency += frequencies.get(i);
        }
        return resultingFrequency;
    }

    public  List<Integer> frequencyCalculation(String frequencies){
        String[] splitFrequency = frequencies.split(",");
        List<Integer> frequencyList = new ArrayList<>(splitFrequency.length);
        for (int i = 0; i< splitFrequency.length; i++){
            int frequency = Integer.parseInt(splitFrequency[i].trim());
            frequencyList.add(frequency);
        }
        return frequencyList;
    }
}
