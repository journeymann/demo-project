package com.demo.application;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.demo.auth.AuthCache;
import com.demo.constants.Actions;
import com.demo.constants.ResourceTypes;

public class DemoApplication {
	/**
	 *  roles=RO;RW;SU
	 * 	RO-Perm=Read:File
	 * 	RW-Perm=Read,Write,Delete:File
	 * 	Folder-Perm=Create,Delete:Folder
	 * 	perms=RO->RO-Perm;RW->RW-Perm;SU->RW-Perm,Folder-Perm
	 * 	users=dopey->RO;sneezy->RW;happy->RW;grumpy->SU
	 */

	public static void main(String[] args) throws IOException{

		AuthCache auth = new AuthCache();
		Set<String> actions = null;
		Set<String> resources = null;
		String principal = null;
				
		principal = "grumpy";
		actions = new HashSet<String>(Arrays.asList(Actions.READ));
		resources = new HashSet<String>(Arrays.asList(ResourceTypes.FILE));
		System.out.printf(" the action %s on resources %s for %s is %s \n", actions, resources, principal, auth.isPermittedMsg(principal, actions, resources));
		
		principal = "dopey";
		actions = new HashSet<String>(Arrays.asList(Actions.WRITE));
		resources = new HashSet<String>(Arrays.asList(ResourceTypes.FILE));
		System.out.printf(" the action %s on resources %s for %s is %s \n", actions, resources, principal, auth.isPermittedMsg(principal, actions, resources));
		
		principal = "grumpy";
		actions = new HashSet<String>(Arrays.asList(Actions.READ));
		resources = new HashSet<String>(Arrays.asList(ResourceTypes.FOLDER));
		System.out.printf(" the action %s on resources %s for %s is %s \n", actions, resources, principal, auth.isPermittedMsg(principal, actions, resources));
		
		principal = "grumpy";
		actions = new HashSet<String>(Arrays.asList(Actions.CREATE));
		resources = new HashSet<String>(Arrays.asList(ResourceTypes.FOLDER));
		System.out.printf(" the action %s on resources %s for %s is %s \n", actions, resources, principal, auth.isPermittedMsg(principal, actions, resources));
		
		principal = "dopey";
		actions = new HashSet<String>(Arrays.asList(Actions.READ));
		resources = new HashSet<String>(Arrays.asList(ResourceTypes.FOLDER));
		System.out.printf(" the action %s on resources %s for %s is %s \n", actions, resources, principal, auth.isPermittedMsg(principal, actions, resources));
		
	}
		
}


