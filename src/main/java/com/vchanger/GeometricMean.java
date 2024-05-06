package com.vchanger;

import java.util.HashMap;

public class GeometricMean {
    public static void calculate(HashMap<String,double[]> hashMap,HashMap<String,Double> finalData){
        for (String key : hashMap.keySet()){
            double[] data = hashMap.get(key);
            double x = 1.0;
            for (Double value : data) {
                x *= value;
            }
            double geometricMean = Math.pow(x, 1.0 / data.length);
            finalData.put("Среднее геометрическое "+key, geometricMean);
        }
    }
}
