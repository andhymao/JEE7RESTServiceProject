/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carvajal.service.restful;

import com.carvajal.service.entity.Person;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author mauocasa
 */
@Path("/RESTFulServices")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonFacadeREST extends AbstractFacade<Person> {

    @PersistenceContext(unitName = "JEE7RESTServiceProjectPU")
    private EntityManager em;

    public PersonFacadeREST() {
        super(Person.class);
    }

    @POST
    @Override
    @Path("createPerson")
    public void create(Person entity) {
        super.create(entity);
    }

    @PUT
    @Path("editPerson")
    public void edit(@PathParam("id") String id, Person entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("removePerson")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("findPerson")
    public Person find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Path("findAllPersons")
    public List<Person> findAll() {
        return super.findAll();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}