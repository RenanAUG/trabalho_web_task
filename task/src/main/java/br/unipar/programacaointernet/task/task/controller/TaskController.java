package br.unipar.programacaointernet.task.task.controller;

import br.unipar.programacaointernet.task.task.model.Historico;
import br.unipar.programacaointernet.task.task.model.Task;
import br.unipar.programacaointernet.task.task.service.HistoricoService;
import br.unipar.programacaointernet.task.task.service.TaskService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/task")
public class TaskController {

    @Inject
    private TaskService taskService;

    @Inject
    private HistoricoService historicoService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarTask() throws Exception {
        return Response.ok(taskService.listar()).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response salvarTask(Task task){
        try{
            taskService.salvar(task);

            historicoService.salvarHistorico("Task criada", "Task criada com sucesso!!", true, "OK", task, task.getUsuario());

            return Response.status(200)
                    .entity("Task salvo com sucesso")
                    .build();
        }catch (Exception e){
            return Response.status(500)
                    .entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response buscarTaskPorId(@PathParam("id") Integer id) {
        return Response.ok(taskService.buscarPorId(id)).build();
    }

    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deletarTask(@PathParam("id") Integer id) {
        try {
            taskService.deletarTask(id);

            historicoService.salvarHistorico("Task deletada " + id, "Task deletada com sucesso!!", true, "OK", null, null);

            return Response.status(200)
                    .entity("Task deletada com sucesso")
                    .build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response editarTask(
            @PathParam("id") Integer id,
            Task task
    ) {
        try {
            taskService.editarTask(task,id);
            historicoService.salvarHistorico("Task editada! " + task.getId(), "Task editada com sucesso!!", true, "OK", task, task.getUsuario());

            return Response.status(200)
                    .entity("Task editada com sucesso.")
                    .build();
        } catch (Exception exception) {
            return Response.status(500).entity(exception.getMessage()).build();
        }
    }



}
