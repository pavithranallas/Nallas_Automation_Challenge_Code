package json_comparison;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Compare_JSON {

	public static void main(String[] args) throws JsonProcessingException, DatabindException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		//StateCode statecode = mapper.readValue(new File("D:/Nallas_Docs/fileone.json"), StateCode.class);
		
		List<StateCode> statecodelist1 = mapper.readValue(new File("D:/Nallas_Docs/fileone.json"), new TypeReference<List<StateCode>>() {});
		//System.out.println(statecodelist1);
	
		List<StateCode> statecodelist2 = mapper.readValue(new File("D:/Nallas_Docs/filetwo.json"), new TypeReference<List<StateCode>>() {});
		//System.out.println(statecodelist2);
		
		  String jsonString1 = mapper.writeValueAsString(statecodelist1); 
		  String jsonString2 = mapper.writeValueAsString(statecodelist2);  
		  
		  JsonNode node1 = mapper.readTree(jsonString1);  
		  JsonNode node2 = mapper.readTree(jsonString2);
		  
		 // System.out.println("Node1 size: "+node1.size());
		  //System.out.println("Node2 size: "+node2.size());
		  System.out.println("MISMATCH SUMMARY:");
		  for(int i = 0; i <node1.size(); i++)
		  {
			  JsonNode JsonObject = node1.get(i);
			  int ID1 = JsonObject.get("id").asInt();
			  String Value1 = JsonObject.get("value").asText(); 
			  String Statecode1 = JsonObject.get("statecode").asText();
			  
			  for(int j = 0; j <node2.size(); j++)
			  {
				  JsonNode JsonObject2 = node2.get(j);
				  int ID2 = JsonObject2.get("id").asInt();
				  
				  if(ID1 == ID2)
				  {
					  System.out.print("ID= "+ID1 +",");
					  String Value2 = JsonObject2.get("value").asText(); 
					  String Statecode2 = JsonObject2.get("statecode").asText();
					  if(!(Value1.equalsIgnoreCase(Value2)))
					  {
						  
						  System.out.print("VALUE MISMATCH- "+Value1 +"/" +Value2);
					  }
					  else
					  {
						  Boolean b = true;
					  }
					  if(!(Statecode1.equalsIgnoreCase(Statecode2)))
					  {
						  System.out.print("STATECODE MISMATCH- " +Statecode1 +"/" +Statecode2 +'\n');
						
					  }
					  else
					  {
						  
					  }
					  
				  }
				  
			  }	   
			  
		  }

	}

}
