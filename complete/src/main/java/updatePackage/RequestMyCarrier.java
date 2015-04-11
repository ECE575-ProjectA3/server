package updatePackage;

//import org.springframework.http.*;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

/*
 * Template for carrier-specific request mapping
 * Reads from a given JSON file
 */

@RestController
public class RequestMyCarrier {
	
	private final String filename = "myCarrier.json";
	private final String request = "/myCarrier";
	
	@RequestMapping(value = request, method=RequestMethod.GET)
	public VisualParams[] getCarrierData() {
		
		JSONParser parser = new JSONParser();
        try {
        	//parse JSON file
            JSONArray carrierData = (JSONArray) parser.parse(new FileReader(filename));
            VisualParams[] result = new VisualParams[carrierData.size()];

            //serve file contents
            JSONObject next;
            for(int i=0; i < carrierData.size(); i++) {
            	next = (JSONObject) carrierData.get(i);
            	result[i] = new VisualParams();
            	result[i].setLatitude((Double)next.get("latitude"));            
            	result[i].setLatitude((Double)next.get("latitude") );
            	result[i].setLongitude((Double)next.get("longitude"));
            	result[i].setSignalStrength(((Long)next.get("signalStrength")).intValue());
            	result[i].setDate(((Long)next.get("date")).intValue());
            	result[i].setTime(((Long)next.get("time")).intValue());
            }
            
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
}
