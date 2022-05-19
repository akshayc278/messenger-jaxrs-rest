package org.akshay.techie.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.akshay.techie.messenger.database.DatabaseConfig;
import org.akshay.techie.messenger.model.MessageClass;
import org.akshay.techie.messenger.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseConfig.getProfiles();
	
	public ProfileService() {
		Profile p1=new Profile(1L, "profile1","akshay", "chavan");
		profiles.put(p1.getProfileName(), p1);
	}

	public List<Profile> getProfiles() {
		return new ArrayList<>(profiles.values());
	}

	public Profile getProfile(String  profileName) {
		return profiles.get(profileName);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getId() <= 0) {
			return null;
		} else {
			profiles.put(profile.getProfileName(), profile);
			return profile;
		}
	}

	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
		
	}
}
