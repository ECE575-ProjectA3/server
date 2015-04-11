package updatePackage;

//import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Bad Request")  // 400
class BadRequestException extends RuntimeException {
	static final long serialVersionUID = 0;
    // ...
}

@RestController
public class UpdateController {

    @RequestMapping(value = "/update", method=RequestMethod.POST)
    public void update(@RequestBody CoverageParams coverageParams) {
    	System.out.println("Longitude:"+coverageParams.getLongitude());
    	System.out.println("Latitude:"+coverageParams.getLatitude());
    	System.out.println("SignalStrengthLevel:"+coverageParams.getSignalStrength());
    	System.out.println("Service provider:"+coverageParams.getNetworkProvider());
    	System.out.println("Data speed:"+coverageParams.getDataSpeed());
    	System.out.println("Date:"+coverageParams.getMonth()+"/"+
    			coverageParams.getDay()+"/"+coverageParams.getYear()+"Time:"+
    			coverageParams.getHour() + ":" + coverageParams.getMinute());
    	
    	//TODO: write to "<networkProvider>.json"
    }
    /*
    public void update() {
    	System.out.println("Message reached");
    }*/
}
