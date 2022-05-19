package org.akshay.techie.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.akshay.techie.messenger.model.MessageClass;
import org.akshay.techie.messenger.model.Profile;

public class DatabaseConfig {
	
	private static Map<Long,MessageClass> messages=new HashMap<>();
	private static Map<String,Profile> profiles=new HashMap<>();
	
	public static Map<Long,MessageClass> getMessages(){
		return messages;
	}
	public static Map<String,Profile> getProfiles(){
		return profiles;
	}

}
