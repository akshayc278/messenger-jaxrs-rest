package org.akshay.techie.messenger.resources;

import java.net.URI;
import java.util.List;

import org.akshay.techie.messenger.model.MessageClass;
import org.akshay.techie.messenger.model.Profile;
import org.akshay.techie.messenger.service.MessageService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path("/messages")
public class MessageResource {

	MessageService ms = new MessageService();

	// Get based on year
	@GET
	@Produces(MediaType.APPLICATION_JSON)//Header : Accept application/json
	public List<MessageClass> getJsonMessageByYear(@QueryParam(value = "year") int year,
			@QueryParam(value = "start") int start, @QueryParam(value = "size") int size) {
		if (year > 0) {
			return ms.getMessagesForYear(year);
		}
		if (start >= 0 && size > 0) {
			return ms.getAllMessagesPaginated(start, size);
		}
		return ms.getMessages();
	}
	@GET
	@Produces(MediaType.TEXT_XML)//Header : Accept text/xml
	public List<MessageClass> getXmlMessageByYear(@QueryParam(value = "year") int year,
			@QueryParam(value = "start") int start, @QueryParam(value = "size") int size) {
		if (year > 0) {
			return ms.getMessagesForYear(year);
		}
		if (start >= 0 && size > 0) {
			return ms.getAllMessagesPaginated(start, size);
		}
		return ms.getMessages();
	}

	// @GET
	// @Produces(MediaType.APPLICATION_JSON)
	// public List<MessageClass> getMessage() {
	// return ms.getMessages();
	// }

	// method level annotation
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public MessageClass getMessage(@PathParam(value = "messageId") long messageId,@Context UriInfo uriInfo) {
		MessageClass mc=ms.getMessage(messageId);
		
		mc.addLink(getUriForSelf(uriInfo, mc), "self");//example of Hateoas
		mc.addLink(getUriForProfile(uriInfo, mc), "profile");
		mc.addLink(getUriForComment(uriInfo, mc), "comment");
		return mc;

	}
	
	private String getUriForProfile(UriInfo uriInfo, MessageClass mc) {
		return uriInfo.getBaseUriBuilder()
				.path(ProfileResource.class)
				.path(Long.toString(mc.getId()))
				.build()
				.toString();
	}
	
	private String getUriForComment(UriInfo uriInfo, MessageClass mc) {
		return uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(MessageResource.class,"getCommentResource")
				.path(CommentResource.class)
				.resolveTemplate("messageId", mc.getId())
				.build()
				.toString();
	}

	private String getUriForSelf(UriInfo uriInfo, MessageClass mc) {
		return uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(Long.toString(mc.getId()))
				.build()
				.toString();
	}

//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public MessageClass addMessage(MessageClass messageClass) {
//		return ms.addMessage(messageClass);
//
//	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(MessageClass messageClass, @Context UriInfo uriInfo) {
		MessageClass m = ms.addMessage(messageClass);
		String newId = String.valueOf(m.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(m).build();
	}

	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public MessageClass modifyMessage(@PathParam(value = "messageId") long messageId, MessageClass messageClass) {
		messageClass.setId(messageId);
		return ms.updateMessage(messageClass);

	}

	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam(value = "messageId") long messageId) {
		ms.removeMessage(messageId);

	}

	// sub-resource concept
	// http://localhost:8080/messenger/webapi/messages/12/comments
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}

}
