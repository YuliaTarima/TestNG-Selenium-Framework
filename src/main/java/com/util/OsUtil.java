package com.util;

public class OsUtil {
	private static String OS = System.getProperty("os.name").toLowerCase();

	public static String getOS() {
	System.out.println("Your OS is: "+OS);
	String osName;

	if(isWindows()) {
		System.out.println("This is Windows");
		osName = "win";
	} else if (isMac()) {
		System.out.println("This is Mac");
		osName = "mac";
	} else if (isUnix()) {
		System.out.println("This is Unix or Linux");
		osName = "linux";
	} else if (isSolaris()) {
		System.out.println("This is Solaris");
		osName = "solaris";
	} else {
		System.out.println("Your OS is not support!!");
		osName = "unknown";
	}
	return osName;
}

	public static boolean isWindows() {

		return (OS.indexOf("win") >= 0);
		//OS.contains("win");

	}

	public static boolean isMac() {

		return (OS.indexOf("mac") >= 0);

	}

	public static boolean isUnix() {

		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);

	}

	public static boolean isSolaris() {

		return (OS.indexOf("sunos") >= 0);

	}

}
