package com.vchanger;

import java.util.HashMap;

public class Colculations {
    private HashMap<String,double[]> hashMap;
    private HashMap<String,Double> finalData;
    public Colculations(HashMap<String,double[]> hashMap,HashMap<String,Double> finalData){
        this.hashMap = hashMap;
        this.finalData = finalData;
    }
    public HashMap<String,Double> getData(){
        ArithmeticMean.calculate(hashMap,finalData);
        Cov.calculate(hashMap,finalData);
        GeometricMean.calculate(hashMap,finalData);
        Maximum.calculate(hashMap,finalData);
        Minimum.calculate(hashMap,finalData);
        NumberOfValues.calculate(hashMap,finalData);
        Range.calculate(hashMap,finalData);
        StandardDeviation.calculate(hashMap,finalData);
        Variance.calculate(hashMap,finalData);
        Variation.calculate(hashMap,finalData);
        return finalData;
    }
}
