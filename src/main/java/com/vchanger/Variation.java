package com.vchanger;

import org.apache.commons.math3.stat.StatUtils;

import java.util.HashMap;

public class Variation {
    public static void calculate(HashMap<String, double[]> hashMap, HashMap<String,Double> finalData){
        for (String key : hashMap.keySet()) {
            double[] data = hashMap.get(key);
            finalData.put("коэффициент вариации "+key, Math.sqrt(StatUtils.variance(data))/StatUtils.mean(data));
        }
    }
}
