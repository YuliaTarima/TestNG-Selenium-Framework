package com.test.test07.listeners.onfailure.screenshot.mail;

public class MailConfig{
	
	public static String server="smtp.gmail.com";
	public static String from = "yuliatarima@gmail.com";
	public static String password = "adxvkjwyugkftegd";
	public static String[] to ={"yuliatarima@gmail.com","the-best-julia@mail.ru"};
	public static String subject = "Test Report";
	
	public static String messageBody ="TestMessage";
	public static String attachmentPath=System.getProperty("user.dir")+"//reports.zip";
	public static String attachmentName="reports.zip";
//	public static String attachmentName=System.getProperty("user.dir")+"//zipreports//reports.zip";
}
