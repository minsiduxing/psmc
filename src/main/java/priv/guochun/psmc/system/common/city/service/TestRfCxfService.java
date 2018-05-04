package priv.guochun.psmc.system.common.city.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/testRfCxfService")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public interface TestRfCxfService {

	
	@Path("/getInfo")//某个方法的操作的资源
    @GET
    @Produces({MediaType.APPLICATION_JSON})
	public List<String> getInfoMethod();
}
