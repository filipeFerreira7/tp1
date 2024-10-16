package br.unitins.tp1.faixas.Guitarra.resource;

import java.util.List;
import br.unitins.tp1.faixas.Guitarra.dto.GuitarraDTORequest;
import br.unitins.tp1.faixas.Guitarra.dto.GuitarraDTOResponse;
import br.unitins.tp1.faixas.Guitarra.service.GuitarraService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
// controlador
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/guitarras")
public class GuitarraResource {
    
    @Inject
    public GuitarraService guitarraService;

    @Inject
    Validator validator;


    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id){
        return Response.ok(GuitarraDTOResponse.valueOf(guitarraService.findById(id))).build();
    }

    @GET
    @Path("/search/{nome}")
    public List<GuitarraDTOResponse> findByNome(@PathParam("nome") String nome){
        return guitarraService.findByNome(nome).stream()
        .map(o -> GuitarraDTOResponse.valueOf(o))
        .toList();
    }

    @GET
    public Response findAll(){
        return Response.ok(guitarraService.
                     findAll().
                     stream().
                     map(o -> GuitarraDTOResponse.valueOf(o))
                    .toList()).build();
    }

     @POST
    public Response create(@Valid GuitarraDTORequest dto){
        return Response
                    .status(Status.CREATED)
                    .entity(GuitarraDTOResponse.valueOf(guitarraService.create(dto)))
                    .build();
    }
    @PUT
    @Path("/{id}")
    public Response update(@Valid @PathParam("id") Long id ,@Valid GuitarraDTORequest dto){
         guitarraService.update(id, dto);
       return Response.noContent().build();
    }
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id){
        guitarraService.delete(id);
    }
}

// Views = Swagger and Browser
// Model = Business Rules;(model: Faixa- Entity Class)
// Control = Resource(FaixaResource)