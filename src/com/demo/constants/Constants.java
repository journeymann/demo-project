package com.demo.constants;

public final class Constants {
	
	public final static String _PROP_DELIMITER = ";";	
	public final static String _LISTVAL_DELIMITER = ",";	
	public final static String _KEYVAL_DELIMITER = "->";	
	public final static String _RESOURCE_DELIMITER = ":";	
	public final static String _BLANK = " ";	
	public final static String _PERMS = "perms";	
	public final static String _USERS = "users";
	public final static String _PERMITTED = "PERMITTED";	
	public final static String _DENIED = "DENIED";	
	public final static String _DEFAULT_PROPERTY_FILE = "com/demo/constants/props.properties";

	public static final byte ZERO = (byte) 0x0;
	public static final byte EXCEPTION_CODE_IO = (byte) 0x2;
	public static final byte EXCEPTION_CODE_GENERAL = (byte) 0x3;
	public static final byte EXCEPTION_CODE_ARG_UNDERFLOW = (byte) 0x4;

	public static final String REGEXP_VALID_FLAG = "^[Y|N]{1}$";
	public static final String REGEXP_TRUE = "^[Y|YES|T|TRUE|1]{1}$";
		
	/**
	 *  Declare class final and constructor private to defeat instantiation and extension
	 */
	private Constants(){
		
	}
}	