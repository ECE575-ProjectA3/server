package updatePackage;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.*;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
	
	@Autowired 
	private StoreData mStorage;
	
	@RequestMapping(value = "/request", method=RequestMethod.GET)
	public VisualParams[] request(@RequestParam(value="carrier", required=true) String carrierName,
			@RequestParam(value="type", required=false, defaultValue="signalStrength") String dataType) {
		
		List<VisualParams> result = new ArrayList<VisualParams>();	//initialize results list
		
		//need to add filtering to the database
		result = mStorage.getData(carrierName, dataType);
		
		return result.toArray(new VisualParams[result.size()]);		//return results list
	}

}
