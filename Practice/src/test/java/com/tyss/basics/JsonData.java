package com.tyss.basics;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonData {

	public static void main(String[] args) throws Exception {
//		String filePath=".\\jsonFiles\\Demo.json";
//		JSONParser parser = new JSONParser();
//		Object obj = parser.parse(new FileReader(filePath));
//		JSONObject jsonObject =  (JSONObject) obj;
//		String jsonPath = "$.x[0].bureauResponse.GetCustomerAssetsResponse.GetCustomerAssetsSuccess.Asset.TrueLinkCreditReport.TradeLinePartition[0].Tradeline.creditorName";
//		//JSONArray jsonArray =  (JSONArray) obj;
//		String creditorName = (String) jsonObject.get(jsonPath);
//		System.out.println(creditorName);

		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(".\\jsonFiles\\Demo.json");
		// Read JSON file
		Object obj = jsonParser.parse(reader);
		JSONArray usersList = (JSONArray) obj;

		for (int i = 0; i < usersList.size(); i++) {
			JSONObject users = (JSONObject) usersList.get(i);
			// This prints every block - one json object
			System.out.println("Users -> " + users);
			String username = (String) users.get("bureauResponse");
			System.out.println(username);
		}
	}

}
