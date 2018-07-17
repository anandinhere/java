package test;

import java.util.Date;

public class Test {

	public static void main(String[] args) {
		String str = "  hi  ";
		System.out.println(str.trim());
		
		Date today = new Date();
		
		System.out.println(today);
		
		double number = 29.91;
		
		System.out.println( String.valueOf(number/100));
		
		double a = 8.47;
		double b = 29.91;
		double c = 5.25;
		
		System.out.println((a-((a * b/100)+ c))/c);
		
	}
}
