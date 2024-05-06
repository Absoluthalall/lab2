package com.vchanger;

import org.apache.commons.math3.stat.StatUtils;

import java.util.HashMap;

public class Range {
    public static void calculate(HashMap<String, double[]> hashMap, HashMap<String,Double> finalData){
        for (String key : hashMap.keySet()) {
            double[] data = hashMap.get(key);
            finalData.put("размах "+key, StatUtils.max(data)-StatUtils.min(data));
        }
    }
}
