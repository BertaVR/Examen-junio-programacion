package edu.pingpong.examen;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/wellcome")
public class ResourcesOlli {

    @Inject
    public ServiceOlli service;

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    // curl -w "\n" http://localhost:8080/wellcome/ 
    // -H "Content-Type: application/x-www-form-urlencoded"
    public String hello() {
        Response.status(Response.Status.OK).build();
        return "Wellcome Ollivanders!";
    }


    
}
