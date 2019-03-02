package com.demo.auth;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.demo.facade.DemoFacade;
import com.demo.types.AuthzCache;
import com.demo.types.Permission;
import static com.demo.constants.Constants.*;

public class AuthCache implements AuthzCache{
	
	public Set<String> getRoles(String principal){
		List<String> users_perms = ResourceCache.instance().getPropertyList(_USERS);
		String user_roles = users_perms.stream().filter(s->s.contains(principal)).findFirst().orElseGet(String::new);
		return Stream.of(user_roles.split(_KEYVAL_DELIMITER)[1]).collect(Collectors.toSet());
	};
	
	public Set<Permission> getPermissions(String principal){
		Set<PermissionImpl> perms = new HashSet<PermissionImpl>();
		List<String> all_perms = ResourceCache.instance().getPropertyList(_PERMS);
		Set<String> user_roles = getRoles(principal);
		System.out.printf(" user_roles: %s", user_roles);

		for(String user_role : user_roles) {
		
			String usr_type_perms = all_perms.stream().filter(s->s.contains(user_role)).findFirst().orElseGet(String::new);
			System.out.printf(" usr_type_perms: %s", usr_type_perms);
			
			for(String usr_type_perm : usr_type_perms.split(_KEYVAL_DELIMITER)[1].split(_LISTVAL_DELIMITER)) {
				System.out.printf(" usr_type_perm: %s", usr_type_perm);
				String role_resource_perm = ResourceCache.instance().getProperty(usr_type_perm);
				String[] tokens = role_resource_perm.split(_RESOURCE_DELIMITER);
				
				Set<String> actions = Arrays.asList(tokens[0].split(_LISTVAL_DELIMITER)).stream().collect(Collectors.toSet());
				Set<String> resources = Arrays.asList(tokens[1].split(_LISTVAL_DELIMITER)).stream().collect(Collectors.toSet());

				PermissionImpl permisssion = new PermissionImpl(actions, resources);
				perms.add(permisssion);
			}
		}

		return DemoFacade.convertSetSubtype(perms, Permission.class);
	};
	
	public boolean isPermitted(String principal, Set<String> actions, Set<String> resources){
		
		Set<Permission> permissions = getPermissions(principal);
		
		for (Permission permission : permissions) {
			if(permission.isPermitted(actions, resources)) return true;
		}
		
		return false;
	};
	
	public String isPermittedMsg(String principal, Set<String> actions, Set<String> resources){
		
		return isPermitted(principal, actions, resources)? _PERMITTED : _DENIED;
	};
}

