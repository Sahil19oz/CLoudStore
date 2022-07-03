package com.barclays.store.utility;

import java.io.FileReader;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;

public class JsonParser {
	
	public static JSONArray parseJsonFile(String path) {
		JSONParser parser = new JSONParser();
		 JSONArray objectList = null;
		try (FileReader reader = new FileReader(path))
        {
            Object obj = parser.parse(reader);
            objectList = (JSONArray) obj;
        } catch (Exception e) {
            e.printStackTrace();
        } 
		return objectList;
	}
	
	@SuppressWarnings({ "unchecked", "null" })
	public static List<JSONObject> parseItemFile(String path) {
		JSONArray obj = parseJsonFile(path);
		List<JSONObject> allJsonObj = null;
		obj.forEach(data -> allJsonObj.add((JSONObject) data));
		return allJsonObj;
	}
}
