package br.unipar.programacaointernet.task.task.service;

import br.unipar.programacaointernet.task.task.model.Usuario;
import br.unipar.programacaointernet.task.task.repository.UsuarioRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class UsuarioService {

    @Inject
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listar() {
        return usuarioRepository.listarTodos();
    }

    public void cadastrar(Usuario usuario) throws Exception {
        usuarioRepository.cadastrar(usuario);
    }

    public void buscarPorId(Integer id) {
        usuarioRepository.buscarPorID(id);
    }

    public void deletarUsuario(Integer id) throws Exception {
        usuarioRepository.deletarUsuario(id);
    }

    public void atualizarUsuario(Integer id) throws Exception {
        usuarioRepository.editarUsuario(id);
    }
}
