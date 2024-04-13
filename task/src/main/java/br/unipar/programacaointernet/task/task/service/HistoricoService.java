package br.unipar.programacaointernet.task.task.service;

import br.unipar.programacaointernet.task.task.model.Historico;
import br.unipar.programacaointernet.task.task.model.Task;
import br.unipar.programacaointernet.task.task.model.Usuario;
import br.unipar.programacaointernet.task.task.repository.HistoricoRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class HistoricoService {

    @Inject
    private HistoricoRepository historicoRepository;

    public void salvarHistorico(String descricao, String observacao, Boolean prioridade, String status, Task task, Usuario usuario) {
        Historico historicoSalvo = new Historico();

        historicoSalvo.setDescricao(descricao);
        historicoSalvo.setObservacao(observacao);
        historicoSalvo.setPrioridade(prioridade);
        historicoSalvo.setStatus(status);
        historicoSalvo.setTask(task);
        historicoSalvo.setUsuario(usuario);

        historicoRepository.salvar(historicoSalvo);
    }
}
