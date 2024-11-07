package br.unitins.tp1.faixas.Marca.resource;

import java.util.List;

import br.unitins.tp1.faixas.Marca.dto.MarcaDTORequest;
import br.unitins.tp1.faixas.Marca.dto.MarcaDTOResponse;
import br.unitins.tp1.faixas.Marca.service.MarcaService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
// controlador
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/marcas")
public class MarcaResource {
    
    @Inject
    public MarcaService marcaService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id){
        return Response.ok(MarcaDTOResponse.valueOf(marcaService.findById(id))).build();
    }

    @GET
    @Path("/search/{nome}")
    public List<MarcaDTOResponse> findByNome(@PathParam("nome") String nome){
        return marcaService.findByNome(nome).stream()
        .map(o -> MarcaDTOResponse.valueOf(o))
        .toList();
    }

    @GET
    public Response findAll(){
        return Response.ok(marcaService.
                     findAll().
                     stream().
                     map(o -> MarcaDTOResponse.valueOf(o))
                    .toList()).build();
    }

     @POST
    public Response create(@Valid MarcaDTORequest dto){
        return  Response.status(Status.CREATED).entity(
            MarcaDTOResponse.valueOf(marcaService.create(dto))
            ).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@Valid @PathParam("id") Long id ,@Valid MarcaDTORequest dto){
         marcaService.update(id, dto);
       return Response.noContent().build();
    }
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        marcaService.delete(id);
        return Response.noContent().build();
    }
}

// Views = Swagger and Browser
// Model = Business Rules;(model: Faixa- Entity Class)
// Control = Resource(FaixaResource)