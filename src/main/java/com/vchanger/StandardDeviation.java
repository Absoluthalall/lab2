package com.vchanger;

import org.apache.commons.math3.stat.StatUtils;

import java.util.HashMap;

public class StandardDeviation {
    public static void calculate(HashMap<String, double[]> hashMap, HashMap<String,Double> finalData){
        for (String key : hashMap.keySet()) {
            double[] data = hashMap.get(key);
            finalData.put("стандартное отклонение "+key, Math.pow(StatUtils.variance(data), 0.5));
        }
    }
}
