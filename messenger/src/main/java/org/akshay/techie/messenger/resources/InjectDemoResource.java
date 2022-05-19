package org.akshay.techie.messenger.resources;

import org.akshay.techie.messenger.model.FilterBean;

import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.MatrixParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;

//eg: metrixparam separated by ; 

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	
	//http://localhost:8080/messenger/webapi/injectdemo/annotation;param=value
	@GET
	@Path("/annotation")
	public String getMetrixParam(@MatrixParam (value="param") String value,
									@HeaderParam("customHeader") String header,
									@CookieParam("cookieParam") String cookie) {
		return "Test "+value+ "header param "+header+ "cookie value "+cookie;
	}
	//to takle above code we can user beanparam
	//http://localhost:8080/messenger/webapi/injectdemo/bean?year=2021&day=10
	@GET
	@Path("/bean")
	public String getBeanParam(@BeanParam FilterBean bean) {
		return "Test "+bean.getYear()+ " day "+bean.getDay();
	}
	//gets all stuffs
	
	@GET
	@Path("/context")
	public String getParamContext(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
		return "test "+uriInfo.getAbsolutePath().toString()+" \n "+httpHeaders.getCookies().toString();
	}

}
