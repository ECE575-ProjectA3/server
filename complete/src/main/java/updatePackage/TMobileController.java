package updatePackage;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TMobileController {
	
	@Autowired 
	private StoreData mStorage;
	
	@RequestMapping(value="/T-Mobile",method=RequestMethod.POST)
	public void update(@RequestBody CoverageParams coverageParams) {
		System.out.println("Longitude:"+coverageParams.getLongitude());
    	System.out.println("Latitude:"+coverageParams.getLatitude());
    	System.out.println("SignalStrengthLevel:"+coverageParams.getSignalLevel());
    	System.out.println("Service provider:"+coverageParams.getNetworkProviderName());
    	System.out.println("Data speed:"+coverageParams.getDataSpeed());
    	System.out.println("Date-time:"+coverageParams.getDateTime());
    	
    	/* store the data into database */
    	mStorage.storeSensorData(coverageParams);
	}
	
	@RequestMapping(value="/T-Mobile",method=RequestMethod.GET)
	public ArrayList<VisualParams> getData() {
		return mStorage.getData("T-Mobile");		
	}

}
