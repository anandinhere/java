package fileutils;

import org.apache.commons.lang.SystemUtils;

public class CheckOS {
	public static void main(String[] args) {
		System.out.println(SystemUtils.IS_OS_LINUX);
		System.out.println(SystemUtils.IS_OS_WINDOWS);
		
		System.out.println("\\");
	}
}
