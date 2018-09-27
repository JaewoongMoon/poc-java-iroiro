package java_test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @brief	:
 * @author	: Jae-Woong Moon(mjw8585@gmail.com)
 * @Date	: 2017. 12. 7.
 */
//
public class JacksonTest {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper(); // create once, reuse
	
		// demo 1. json 파일에서 읽어와서 변환(deserialization)
		/*
		MyValue value = mapper.readValue(new File("data.json"), MyValue.class);
		System.out.println("name : " + value.name);
		System.out.println("age : " + value.age);
		*/
		
		// demo2. HashMap객체로 변환
		HashMap<String, Object> myMap = mapper.readValue(new File("data.json"), HashMap.class);
		Set<String> keySet = myMap.keySet();
		System.out.println(keySet);
		for(String key : keySet){
			Object val = myMap.get(key);
			if(val instanceof HashMap){
				HashMap hMap = (HashMap)val;
				hMap.keySet();
			}else{
				System.out.println(key + " : " + val);
			}
		}
		
		// demo3. HashMap to JSON
		
	}
	
	//private static 
}
