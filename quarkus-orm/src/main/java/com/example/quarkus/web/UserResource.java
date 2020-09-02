package com.example.quarkus.web;

import com.example.quarkus.entity.User;
import com.example.quarkus.service.UserService;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author KyleWang
 * @date 2020/09/02
 */
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserService userService;

    @GET
    @Path("/getAll")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GET
    @Path("/getByPhone")
    public Response getByPhone(@QueryParam("phone") String phone) {
        return Response.ok(userService.getByPhone(phone)).build();
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public User saveUser(User user) {
        return userService.saveUser(user);
    }
}
