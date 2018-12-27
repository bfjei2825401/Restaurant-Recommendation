package com.fivetalk.recommendationservice.spark;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public void deal(List<Object> list) {
        Map<String, Integer> user = new HashMap<>();
        Map<String, Integer> item = new HashMap<>();
        int user_index = 0;
        int item_index = 0;
        int res[][] = new int[list.size()][3];
        for (Object obj:list) {
            if(user.containsKey(obj)){//

            }else{
                user_index++;
            }
        }
    }
}
