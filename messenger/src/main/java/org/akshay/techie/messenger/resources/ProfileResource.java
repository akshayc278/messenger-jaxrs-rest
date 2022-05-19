package org.akshay.techie.messenger.resources;

import java.util.List;

import org.akshay.techie.messenger.model.Profile;
import org.akshay.techie.messenger.service.ProfileService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	private ProfileService ps=new ProfileService();
	
	@GET
	public List<Profile> getProfiles(){
		return ps.getProfiles();
	}
	
	@POST
	public Profile addProfile(Profile profile) {
		return ps.addProfile(profile);
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName) {
		return ps.getProfile(profileName);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName,Profile profile) {
		profile.setProfileName(profileName);
		return ps.updateProfile(profile);
	}
	
	
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam(value = "profileName") String profileName) {
		 ps.removeProfile(profileName);

	}

}
