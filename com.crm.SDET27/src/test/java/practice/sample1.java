package practice;

import java.util.Date;

public class sample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d=new Date();
		String dateandtime = d.toString();
		System.out.println(dateandtime);
		
		String yyyy = dateandtime.split(" ")[5];
		String dd = dateandtime.split(" ")[2];
		int mm = d.getMonth();
		
		String finalformat = yyyy+"-"+mm+"-"+dd;
		System.out.println(finalformat);
	}

}
