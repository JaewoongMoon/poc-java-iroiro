/**
 * @ JapaneseDate.java
 */
package date;

import java.text.DateFormat;
import java.text.Format;
import java.util.Date;
import java.util.TimeZone;

/**
 * <pre>
 * date
 * JapaneseDate.java 
 * </pre>
 *
 * @brief	: 
 * @author	: Jae-Woong Moon(mjw8585@gmail.com)
 * @Date	: 2017/08/21
 */
public class JapaneseDate {

	public static void main(String[] args) {
		  TimeZone tz = TimeZone.getDefault();
	        System.out.println("TimeZome ID = " + tz.getID());
	        System.out.println("TimeZome名称 = " + tz.getDisplayName());
	        System.out.println("TimeZome Offset  = " + tz.getRawOffset());
	        
	        Date now = new Date();
	        DateFormat df_date = DateFormat.getDateInstance();
	        DateFormat df_time = DateFormat.getTimeInstance();
	        System.out.println("日付書式:short(default) = " + df_date.format(now));
	        System.out.println("時間書式:short(default) = " + df_time.format(now));
	        
	        Format fmt= DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.LONG);
	        System.out.println("JP書式(Full, Long)  = " + fmt.format(now));
	        Format fmt_date = DateFormat.getDateInstance(DateFormat.FULL);
	        System.out.println("JP書式日付(Full)  = " + fmt_date.format(now));
	        Format fmt_time = DateFormat.getTimeInstance(DateFormat.LONG);
	        System.out.println("JP書式時間(Long)  = " + fmt_time.format(now));
	        
	        
	}
}
