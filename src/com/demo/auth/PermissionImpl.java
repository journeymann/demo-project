package com.demo.auth;

import java.util.Set;
import com.demo.types.Permission;

public class PermissionImpl implements Permission{

	private Set<String> _actions ;
	private Set<String> _resources ;
	
	PermissionImpl(Set<String> actions, Set<String> resources){
		this._actions = actions;
		this._resources = resources;
	}
	
	public Set<String> getActions(){
		return _actions;
	};
	
	public Set<String> getResources(){
		return _resources;
	};

	public boolean isPermitted(Set<String> actions, Set<String> resources){
		
		return (_actions.containsAll(actions) && _resources.containsAll(resources));
	};
}
