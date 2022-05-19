package org.akshay.techie.messenger.resources;

import org.akshay.techie.messenger.model.ErrorMessage;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/")
public class CommentResource {
	
	@GET
	public String test() {
		return "test";
	}
	//http://localhost:8080/messenger/webapi/messages/12/comments/13
	@GET
	@Path("/{commentId}")
	public String getComment(@PathParam("commentId") long commentId,@PathParam("messageId") long messageId) {
		
		//exception can be also handled by this or 11 comment id as well but best way is genericExceptionMapper or Exception Mapper implemented in Exception
		ErrorMessage er=new ErrorMessage("not found",404,"http:doc.com");
		Response rs=Response.status(Status.NOT_FOUND).entity(er).build();
		if(commentId == 10) {
			throw new WebApplicationException(rs);
		}
		
		if(commentId == 11) {
			throw new WebApplicationException(Status.NOT_FOUND);
		}
		
		return "CommentId is "+commentId + " &  Message Id is "+messageId;
	}
}
