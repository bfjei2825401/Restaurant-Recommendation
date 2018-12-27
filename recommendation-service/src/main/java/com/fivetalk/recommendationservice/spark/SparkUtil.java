package com.fivetalk.recommendationservice.spark;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SparkUtil {
    private Map<Integer, String> userHashMap;
    private Map<Integer, String> businessHashMap;

    public SparkUtil() {
        this.userHashMap = new HashMap<>();
        this.businessHashMap = new HashMap<>();
        try {
            BufferedReader userBufferedReader = new BufferedReader(new FileReader("recommendation-service/data/user_index.csv"));
            userBufferedReader.readLine();
            String line;
            while ((line = userBufferedReader.readLine()) != null) {
                String item[] = line.split(",");
                String userId = item[0];
                int userIndex = Integer.valueOf(item[1]);
                this.userHashMap.put(userIndex, userId);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader businessBufferedReader = new BufferedReader(new FileReader("recommendation-service/data/business_index.csv"));
            businessBufferedReader.readLine();
            String line;
            while ((line = businessBufferedReader.readLine()) != null) {
                String item[] = line.split(",");
                String businessId = item[0];
                int businessIndex = Integer.valueOf(item[1]);
                this.businessHashMap.put(businessIndex, businessId);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getUserIdByIndex(int userIndex) {
        return this.userHashMap.get(userIndex);
    }

    public String getBusinessIdByIndex(int businessIndex) {
        return this.businessHashMap.get(businessIndex);
    }

    public static void main(String[] args) {
        SparkUtil sparkUtil = new SparkUtil();
        String bId = sparkUtil.getBusinessIdByIndex(1);
        String uId = sparkUtil.getUserIdByIndex(2);
        System.out.println("business_id:" + bId);
        System.out.println("user_id:" + uId);
    }
}
