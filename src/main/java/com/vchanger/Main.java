package com.vchanger;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static HashMap<String,double[]> hashMap;
    static HashMap<String,Double> finalData = new HashMap<>();
    public static HashMap<String,Double> func(HashMap<String, double[]> hashMap, HashMap<String, Double> finalData){
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
    public static void main(String[] args) {
        JFrame frame = new JFrame("Excel Data Importer");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField tf = new JTextField();
        tf.setBounds(100, 100, 200, 30);

        JButton imp = new JButton("Импортировать файл");
        imp.setBounds(100, 30, 200, 30);
        JButton exp = new JButton("Экспортировать файл");
        exp.setBounds(100, 65, 200, 30);

        frame.add(exp);
        frame.add(tf);
        frame.add(imp);
        frame.setLayout(null);
        frame.setVisible(true);


        imp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
                int result = fileChooser.showOpenDialog(null);
                try {
                    if (result == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();
                        FileInputStream fis = new FileInputStream(file);
                        XSSFWorkbook workbook = new XSSFWorkbook(fis);
                        XSSFSheet selectedSheet = workbook.getSheet(tf.getText());
                        Input input = new Input(selectedSheet);
                        hashMap = input.getData();
                        finalData = func(hashMap,finalData);
                        for (Map.Entry<String, double[]> entry : hashMap.entrySet()) {
                            String key = entry.getKey();
                            double[] values = entry.getValue();

                            // Вывод ключа и значений в одной строке
                            System.out.println(key + ": " + Arrays.toString(values));
                        }


                    }
                }catch (Exception ex){
                    String errorMessage = "Ошибка при импорте!!!";
                    JOptionPane.showMessageDialog(null, errorMessage, "Ошибка", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        exp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Export.createExcel("Data.xlsx","Sheet",finalData);
                    System.out.println("Создан");
                } catch (Exception ex) {
                    String errorMessage = "Ошибка при экспорте!!!";
                    JOptionPane.showMessageDialog(null, errorMessage, "Ошибка", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
            }
}

