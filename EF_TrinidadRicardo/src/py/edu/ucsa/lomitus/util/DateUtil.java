package py.edu.ucsa.lomitus.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class DateUtil {
	
	public static java.sql.Date convertirUtilDateASQLDate(Date utilDate){
		if (utilDate == null)
			return null;
		
		return new java.sql.Date(utilDate.getTime());
	}
	
	public static java.sql.Timestamp convertirUtilDateASQLTimestamp(Date utilDate){
		if (utilDate == null)
			return null;
		
		return new java.sql.Timestamp(utilDate.getTime());
	}
	
	public static String convertirFechaDMY(Date utilDate){
		return convertirFecha(utilDate, "dd/MM/yyyy");
	}
	
	public static String convertirFechaDMYHms(Date utilDate){
		return convertirFecha(utilDate, "dd/MM/yyyy hh:mm:ss");
	}

	public static String convertirFecha(Date utilDate, String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(utilDate);
	}
	
	public static Date convertirFechaFromString(String fecha, String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date sumarDias(Date fecha, int dias){
		Calendar c = Calendar.getInstance();
		c.setTime(fecha);
		c.add(Calendar.DAY_OF_YEAR, dias);
		return c.getTime();
	}
}
