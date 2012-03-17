package action;

import java.util.ArrayList;

public class Constants {
	
	
	public static String error(String msg)
	{
		return "<error>"+msg+"</error>";
	}
	public static String message(String val)
	{
		return "<msg>"+val+"</msg>";
	}
	public static String addTag(String msg,String tag)
	{
		return "<"+tag+">"+msg+"</"+tag+">";
	}
}
