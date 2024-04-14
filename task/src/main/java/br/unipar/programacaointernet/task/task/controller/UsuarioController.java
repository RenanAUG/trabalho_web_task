package br.unipar.programacaointernet.task.task.controller;

import br.unipar.programacaointernet.task.task.model.Usuario;
import br.unipar.programacaointernet.task.task.service.HistoricoService;
import br.unipar.programacaointernet.task.task.service.UsuarioService;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuario")
public class UsuarioController {

    @Inject
    private UsuarioService usuarioService;

    @Inject
    private HistoricoService historicoService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarUsuarios() {
        return Response.ok(usuarioService.listar()).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response inserirUsuario(Usuario usuario) {
        try {
            usuarioService.cadastrar(usuario);

            historicoService.salvarHistorico("Usuario inserido! " + usuario.getId(), "Usuario inserido com sucesso!!", true, "OK", null, usuario);

            return Response.status(200)
                    .entity("Usuario cadastrado com sucesso")
                    .build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response buscarUsuarioPorId(@PathParam("id") Integer id) {
        return Response.ok(usuarioService.buscarPorId(id)).build();
    }

    @DELETE
    @Path("/{id}")
    @PermitAll
    public Response deletarUsuario(@PathParam("id") Integer id) {
        try {
            usuarioService.deletarUsuario(id);

            historicoService.salvarHistorico("Usuario deletado! " + id, "Usuario deletado com sucesso!!", true, "OK", null, null);

            return Response.status(200)
                    .entity("Usuario deletado com sucesso")
                    .build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response editarUsuario(
            @PathParam("id") Integer id,
            String nome,
            String cargo
    ) {
        try {
            usuarioService.atualizarUsuario(id, nome, cargo);

            historicoService.salvarHistorico("Usuario editado! " + id, "Usuario editado com sucesso!!", true, "OK", null, null);

            return Response.status(200)
                        .entity("Usuário editado com sucesso.")
                        .build();
        } catch (Exception exception) {
            return Response.status(500).entity(exception.getMessage()).build();
        }
    }
}
