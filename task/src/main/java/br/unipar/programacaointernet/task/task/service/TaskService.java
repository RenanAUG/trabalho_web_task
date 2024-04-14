package br.unipar.programacaointernet.task.task.service;

import br.unipar.programacaointernet.task.task.model.Task;
import br.unipar.programacaointernet.task.task.repository.TaskRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;


@Stateless
public class TaskService {

    @Inject
    private TaskRepository taskRepository;

    public List<Task> listar() throws Exception{
        return taskRepository.listarTasks();
    }

    public void salvar(Task task) throws Exception{
        taskRepository.cadastrar(task);
    }

    public Task buscarPorId(Integer id){
        return taskRepository.buscarPorId(id);
    }

    public void deletarTask(Integer id) throws Exception{
        taskRepository.deletar(id);
    }

    public void editarTask(Task task, Integer id) throws Exception{
        taskRepository.editarTask(task, id);
    }
}
