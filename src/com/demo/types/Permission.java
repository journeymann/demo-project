package com.demo.types;

import java.util.Set;

public interface Permission {

	public Set<String> getActions();
	public Set<String> getResources();
	/**
	 * returns true if actions is a subset of actions in this object AND 
	 * resources is a subset of resources in this object.
	 **/
	public boolean isPermitted(Set<String> actions, Set<String> resources);
}