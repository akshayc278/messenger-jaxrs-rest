package org.akshay.techie.messenger.exception;

import org.akshay.techie.messenger.model.ErrorMessage;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;


@Provider //equivalent to @component
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotfoundException> {

	@Override
	public Response toResponse(DataNotfoundException exception) {
		ErrorMessage er=new ErrorMessage(exception.getMessage(),404,"http:doc.com");
		return Response.status(Status.NOT_FOUND).entity(er).build();
	}

}
