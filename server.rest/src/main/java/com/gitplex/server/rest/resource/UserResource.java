package com.gitplex.server.rest.resource;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.criterion.Restrictions;
import org.hibernate.validator.constraints.Email;

import com.gitplex.commons.hibernate.dao.Dao;
import com.gitplex.commons.hibernate.dao.EntityCriteria;
import com.gitplex.commons.jersey.ValidQueryParams;
import com.gitplex.server.core.entity.Account;

@Path("/users")
@Consumes(MediaType.WILDCARD)
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class UserResource {

	private final Dao dao;
	
	@Inject
	public UserResource(Dao dao) {
		this.dao = dao;
	}
	
	@ValidQueryParams
	@GET
	public Collection<Account> query(
			@QueryParam("name") String name, 
			@Email @QueryParam("email") String email, 
			@QueryParam("fullName") String fullName) {
    	EntityCriteria<Account> criteria = EntityCriteria.of(Account.class);
		if (name != null)
			criteria.add(Restrictions.eq("name", name));
		if (email != null)
			criteria.add(Restrictions.eq("email", email));
		if (fullName != null)
			criteria.add(Restrictions.eq("fullName", fullName));
		return dao.findAll(criteria);
	}
	
    @GET
    @Path("/{id}")
    public Account get(@PathParam("id") Long id) {
    	return dao.load(Account.class, id);
    }
    
}