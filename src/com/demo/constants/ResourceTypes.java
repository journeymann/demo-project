package com.demo.constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public @interface ResourceTypes {
	
	  String FILE = "File";
	  String FOLDER = "Folder";

	  public static final Set<String> validResourceTypes = new HashSet<String>(Arrays.asList(ResourceTypes.FILE,ResourceTypes.FOLDER));
	  public static final String DEFAULT_RESOURCE = ResourceTypes.FILE;
	  
	  String value();
}