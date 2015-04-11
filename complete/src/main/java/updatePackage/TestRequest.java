package updatePackage;

//import org.springframework.http.*;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRequest {
	
	private double[] latitudeArray = {35.770820237954545,
			35.770402398496785,35.77799280632021,35.78084772632129,
			35.78565211633479,35.781961813633245,35.77792317284434,
			35.7794550952256,35.78154403272092,35.80437950161731,35.79129168191281};
	
	private double[] longitudeArray = {-78.67554187774658,
			-78.67991924285889,-78.6754560470581,-78.66953372955322,
			-78.66635799407959,-78.66146564483643,-78.67056369781494,
			-78.68086338043213,-78.70824337005615,-78.72395038604736,-78.73201847076416};
	
	private int[] signalLevelArray = {30,20,10,0,30,20,10,0,30,20,10};
	
	private int[] dateArray = {20150101,20150202,20150303,20150404,
			20150505,20150606,20150707,20150808,20150909,20151010,20151111};
	
	private int[] timeArray = {130,200,230,300,330,400,430,500,530,600,630};
	
	@RequestMapping(value = "/testRequest", method=RequestMethod.GET)
	public VisualParams[] getTestData() {
		VisualParams[] result = new VisualParams[latitudeArray.length];
		for (int i = 0; i < latitudeArray.length; i++) {
			result[i] = new VisualParams();
			result[i].setLatitude(latitudeArray[i]);
			result[i].setLongitude(longitudeArray[i]);
			result[i].setSignalStrength(signalLevelArray[i]);
			result[i].setDate(dateArray[i]);
			result[i].setTime(timeArray[i]);
		}
		return result;
	}

}
