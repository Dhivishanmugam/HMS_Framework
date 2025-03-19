package com.comcast.hms.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
		SimpleDateFormat sim;
		public int getRandomNumber() {
			Random random=new Random();
			int randomNumber= random.nextInt(5000);
			return randomNumber;
		}
		public String getSystemDateYYYYDDMM() {
			Date dateObj=new Date();
			sim=new SimpleDateFormat("YYYY-MM-dd");
			String date = sim.format(dateObj);
			
			return date;
			
		}
		public String getRequiredDateYYYYDDMM(int days) {
		   
		    
		    Calendar cal = sim.getCalendar();
		    cal.add(Calendar.DAY_OF_MONTH,days);
		    String reqDate= sim.format(cal.getTime());
			return reqDate;
		}
		public StringBuilder getAlphaNumericData() {
			int n=5;
			String AlphaNumeric="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			StringBuilder sb=new StringBuilder(n);
			for(int i=0;i<n;i++) {
				int index=(int)(AlphaNumeric.length()*Math.random());
				sb.append(AlphaNumeric.charAt(index));
			}
			return sb;
		}
		public StringBuilder getEmailAlphaData() {
			int n=5;
			String AlphaNumeric="abcdefghijklmnopqrstuvwxyz";
			StringBuilder sb1=new StringBuilder(n);
			for(int i=0;i<n;i++) {
				int index=(int)(AlphaNumeric.length()*Math.random());
				sb1.append(AlphaNumeric.charAt(index));
			}
			return sb1;
		}
		
		public int getRandomNumberRoomNo() {
			Random random=new Random();
			int randomNumber= random.nextInt(5);
			return randomNumber;
		}
		public int getRandomNumberContactNum() {
			Random random=new Random();
			int randomNumber=random.nextInt(123456789);
			return randomNumber;
			
		}
}
