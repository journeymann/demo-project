package com.demo.auth;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.MissingResourceException;
import java.util.Optional;
import java.util.PropertyResourceBundle;
import static com.demo.constants.Constants.*;

/**
 * Singleton Pattern Enum implementation for property file access.
 */
public enum ResourceCache {
	
    INSTANCE; /** Enum Singleton design pattern */
	
    private PropertyResourceBundle props = bundle(_DEFAULT_PROPERTY_FILE);
  
    public final void clearCache(){
    	PropertyResourceBundle.clearCache();
    }
    
    public final String getProperty(String key){
	  	
    	if(!Optional.of(props).isPresent()) return _BLANK;   

    	return props.getString(key);
    }

    public static ResourceCache instance(){
		
    	return INSTANCE;
    }

    public final List<String> getPropertyList(String key){
    	
    	if(!Optional.of(props).isPresent()) return new ArrayList<String>();   
    	
		return Arrays.asList((props.getString(key)==null ? _BLANK : props.getString(key)).split(_PROP_DELIMITER));
	}
	
	public PropertyResourceBundle bundle(String fileName) {

		PropertyResourceBundle props = null;

		try(InputStream stream = this.getClass().getClassLoader().getResourceAsStream(fileName)) {
			props = new PropertyResourceBundle(stream);
		}catch(Exception e){
			System.out.printf(e.getMessage());
		}

		if (props == null)
			throw new MissingResourceException("Property file not found!", fileName, "");

		return props;
	}
	
}