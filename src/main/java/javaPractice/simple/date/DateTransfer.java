package javaPractice.simple.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.common.utils.DateUtils;
	/**
 * @author  作者 E-mail: 
 * @date 创建时间：2019年9月6日 下午2:30:47
 * @version 1.0 
 * @parameter 
 * @since  
 * @return  */
public class DateTransfer {

	public static void main(String[] args) {
		try {
			String tfbhDate ="20190812000000";
			String tfbhDate2 ="20190912000000";
			String tfbhDate3 ="2018-12-12 00:00:00";
			String tfbhDate4 ="2018-12";
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
			// 资料时间
			Date dataTime= sdf.parse(tfbhDate);
			Date dataTime2= sdf.parse(tfbhDate2);
			System.out.println(dataTime);
			System.out.println(dataTime2.getTime()-dataTime.getTime());
			System.out.println(DateUtils.strTransferStrYMD(tfbhDate3));
			System.out.println(DateUtils.dateTransferStrYMD(new Date()));
			System.out.println(DateUtils.getStartDateOfMonth(tfbhDate4));
			System.out.println(DateUtils.getEndDateOfMonth(tfbhDate4));
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
