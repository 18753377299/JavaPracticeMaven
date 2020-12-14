package javaPractice.simple.date;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class TimeStampTest {

	public static void main(String[] args) {
		
		try {
			Object object = "2019-08-04 00:00:00";
			Map<String,Object> map= new HashMap<String,Object>();
			map.put("tfdate",object);
			Timestamp timestamp = Timestamp.valueOf(object.toString());
			System.out.println(timestamp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
