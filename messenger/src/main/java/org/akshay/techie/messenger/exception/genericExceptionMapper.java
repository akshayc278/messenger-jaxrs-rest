package org.akshay.techie.messenger.exception;

import org.akshay.techie.messenger.model.ErrorMessage;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider //equivalent to @component
public class genericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage er=new ErrorMessage(exception.getMessage(),500,"http:doc.500.com");
		return Response.status(Status.BAD_REQUEST).entity(er).build();
	}

}
