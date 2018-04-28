package MyDate.Date.com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateFormat {
	public static void main(String[] agrs){
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = getDateInFormat(format, "20/04/2018");
		Date date2 = getDateInFormat(format, "2/04/2018");
		System.out.println(date1);
		System.out.println(date2);
		System.out.println(getDaysBtwTwoDates(date1,date2));
		System.out.println(getDaysBtwTwoDates(date2,date1));
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		Date time1 = getTimeInFormat(timeFormat, "12:00 Pm");
		Date time2 = getTimeInFormat(timeFormat, "12:00 Am");
		System.out.println(time1);
		System.out.println(time2);
		System.out.println(getMinBtwTwoTimes(time1,time2));
	}
	public static long getMinBtwTwoTimes(Date date1,Date date2){
		long diff = date2.getTime() - date1.getTime();
		if(diff<0){
			date2 = new Date(date2.getTime() + (1000 * 60 * 60 * 24)); 
			diff = date2.getTime() - date1.getTime();
		}
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffMinutes = diff / (60 * 1000) % 60;
		return diffMinutes+(diffHours*60);
	}
	public static Date getTimeInFormat(SimpleDateFormat format,String timeStr){
		Date date = null; 
		
			try {
				if(timeStr.toUpperCase().contains("AM") || timeStr.toUpperCase().contains("PM")){
					date = (new SimpleDateFormat("hh:mm a")).parse(timeStr);
					timeStr = format.format(date);
					}
				date = format.parse(timeStr);
			} catch (ParseException e) {
				System.out.println(e);
			}
		
		return date;
	}
	public static Date getDateInFormat(SimpleDateFormat format,String dateStr){
		Date date = null; 
		try {
			 date = format.parse(dateStr);
		} catch (ParseException e) {
			System.out.println(e);
		}
		return date;
	}
	public static long getDaysBtwTwoDates(Date date1,Date date2){
		long diff = Math.abs(date1.getTime() - date2.getTime());
		long diffDays = diff / (24 * 60 * 60 * 1000);
		return diffDays;
	}

}
