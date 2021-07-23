package in.co.sunrays.proj0.util;

import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * Format Input data.
 * 
 * @author Iterator
 * @version 1.0 Copyright (c) Iterator
 * 
 */
public class Util {
	/**
	 * Gets the date.
	 *
	 * @param date the date
	 * @return the date
	 */
	public static Date getDate(String date) {

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date1 = null;

        try {
        	if(date != null){
            date1 = formatter.parse(date);
        	}
            

        } catch (Exception e) {
            e.printStackTrace();
        }

        return date1;
    }

    /**
     * Gets the date.
     *
     * @param indate the indate
     * @return the date
     */
    public static String getDate(Date indate) {
        String dateString = null;
        SimpleDateFormat sdfr = new SimpleDateFormat("MM/dd/yyyy");
       
        try {
            dateString = sdfr.format(indate);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return dateString;
    }

    /**
     * Convert string to date.
     *
     * @param indate the indate
     * @return the string
     */
    public static String convertStringToDate(Date indate) {
        String dateString = null;
        SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
        /*
         * you can also use DateFormat reference instead of SimpleDateFormat
         * like this: DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
         */
        try {
            dateString = sdfr.format(indate);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return dateString;
    }
}
