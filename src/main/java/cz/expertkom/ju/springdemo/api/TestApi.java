package cz.expertkom.ju.springdemo.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import cz.expertkom.ju.springdemo.dto.ItemDto;

@CrossOriginResourceSharing(allowAllOrigins = true)
public interface TestApi {

	/* zobrazeni uzivatelskoho jmena */
	@GET
	@Path("test/{param}")
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_JSON)
	public Response test(@PathParam(value = "param") String param);
	
	/* papoušek*/
	@GET
	@Path("item/{param}")
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_JSON)
	public Response item(@PathParam(value = "param") String param);
	
	/* zobrazení všech položek */
	@GET
	@Path("items")
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_JSON)
	public Response itemsList();

	/* vložení nové hodnoty */
	@POST
	@Path("item")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response itemsInsert(ItemDto itemdDto);

	/* zrušení záznamu dle id */
	@DELETE
	@Path("item/{param}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteRecord(@PathParam(value = "param") Long id);
	
	/* aktualizace záznamu dle id a nové hodnoty */
	@PUT
	@Path("item/{param}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateRecord(@PathParam(value = "param") Long id, ItemDto itemDto);
	
	
	
	
	
	
	
}
