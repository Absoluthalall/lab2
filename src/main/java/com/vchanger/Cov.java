package com.vchanger;

import org.apache.commons.math3.stat.correlation.Covariance;

import java.util.HashMap;

public class Cov {
    public static void calculate(HashMap<String, double[]> hashMap,HashMap<String,Double> finalData) {
        Covariance covariance = new Covariance();
        for (String key1 : hashMap.keySet()){
            for (String key2 : hashMap.keySet()){
                finalData.put(key1+key2,covariance.covariance(hashMap.get(key1), hashMap.get(key2)));
            }
        }
    }
}
