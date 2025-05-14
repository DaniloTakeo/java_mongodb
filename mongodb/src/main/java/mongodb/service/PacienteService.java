package mongodb.service;

import java.util.List;

import mongodb.domain.Paciente;
import mongodb.repository.PacienteRepository;

public class PacienteService {
    private final PacienteRepository repository = new PacienteRepository();

    public void cadastrar(Paciente paciente) {
        paciente.setAtivo(true);
        repository.salvar(paciente);
    }

    public List<Paciente> listarTodos() {
        return repository.buscarTodos();
    }
}