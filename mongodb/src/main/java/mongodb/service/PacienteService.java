package mongodb.service;

import java.util.List;
import java.util.stream.Collectors;

import mongodb.domain.Paciente;
import mongodb.dto.PacienteDTO;
import mongodb.mapper.PacienteMapper;
import mongodb.repository.PacienteRepository;

public class PacienteService {

    private final PacienteRepository repository = new PacienteRepository();

    public void salvar(PacienteDTO dto) {
        Paciente paciente = PacienteMapper.toEntity(dto);
        repository.salvar(paciente);
    }

    public List<PacienteDTO> listarTodos() {
        return repository.buscarTodos()
                .stream()
                .map(PacienteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PacienteDTO buscarPorId(String id) {
        Paciente paciente = repository.buscarPorId(id);
        return paciente != null ? PacienteMapper.toDTO(paciente) : null;
    }

    public void atualizar(String id, PacienteDTO dto) {
        Paciente paciente = PacienteMapper.toEntity(dto);
        repository.atualizar(id, paciente);
    }

    public void deletar(String id) {
        repository.deletarPorId(id);
    }
}