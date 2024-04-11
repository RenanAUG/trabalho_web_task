package br.unipar.programacaointernet.task.task.repository;

import br.unipar.programacaointernet.task.task.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class UsuarioRepository {

    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Usuario> listarTodos() {

    }
}
