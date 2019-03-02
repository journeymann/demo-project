package com.demo.constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public @interface Actions {
	
	  String CREATE = "Create";
	  String READ = "Read";
	  String WRITE = "Write";	
	  String DELETE = "Delete";	

	  public static final Set<String> validActionsTypes = new HashSet<String>(Arrays.asList(Actions.CREATE,Actions.READ,Actions.WRITE,Actions.DELETE));
	  public static final String DEFAULT_ACTION = Actions.READ;
	  
	  String value();
}