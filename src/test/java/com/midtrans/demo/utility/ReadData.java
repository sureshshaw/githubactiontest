package com.midtrans.demo.utility;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReadData {
    public static List<Map<String, String>> readJSON()  {
        List<Map<String, String>> map = null;
        try {
            File file = new File("data.json");
            ObjectMapper objectMapper = new ObjectMapper();
            map = objectMapper.readValue(file, new TypeReference<List<Map<String, String>>>(){});
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return map;
    }
}
