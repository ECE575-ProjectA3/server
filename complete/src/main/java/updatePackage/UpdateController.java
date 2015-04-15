package updatePackage;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Bad Request")  // 400
class BadRequestException extends RuntimeException {
	static final long serialVersionUID = 0;
    // ...
}

@RestController
public class UpdateController {

    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/update", method=RequestMethod.POST)
    public void update(@RequestBody CoverageParams coverageParams) {
    	System.out.println("Longitude:"+coverageParams.getLongitude());
    	System.out.println("Latitude:"+coverageParams.getLatitude());
    	System.out.println("SignalStrengthLevel:"+coverageParams.getSignalStrength());
    	System.out.println("Service provider:"+coverageParams.getCarrierName());
    	System.out.println("Data speed:"+coverageParams.getDownloadSpeed());
    	System.out.println("Date:"+coverageParams.getDateTime());
    	
    	//Create new JSONObject for data
    	JSONObject data = new JSONObject();
    	data.put("latitude", coverageParams.getLatitude());
    	data.put("longitude", coverageParams.getLongitude());
    	data.put("signalStrength", coverageParams.getSignalStrength());
    	data.put("date", coverageParams.getDateTime().split(" ")[0]);
    	data.put("time", coverageParams.getDateTime().split(" ")[1]);
    	
    	JSONParser parser = new JSONParser();
        JSONArray carrierData;
    	try {
        	//parse JSON file and add new data
            carrierData = (JSONArray) parser.parse(new FileReader(coverageParams.getCarrierName()+".json"));
            carrierData.add(data);
            
            //write updated JSON back to file
            FileWriter file = new FileWriter(coverageParams.getCarrierName()+".json");
            file.write(carrierData.toJSONString());
            file.flush();
            file.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }   	
    }
    /*
    public void update() {
    	System.out.println("Message reached");
    }*/
}
