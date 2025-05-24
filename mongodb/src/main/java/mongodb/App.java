package mongodb;

import java.time.LocalDate;
import java.util.List;

import mongodb.dto.PacienteDTO;
import mongodb.service.PacienteService;

public class App {
    public static void main(String[] args) {
    	PacienteService service = new PacienteService();

    	// Cadastrar
    	PacienteDTO dto = new PacienteDTO();
    	dto.setNome("Carlos da Silva");
    	dto.setCpf("12345678900");
    	dto.setDataNascimento(LocalDate.of(1990, 5, 20));
    	dto.setAtivo(true);

    	service.salvar(dto);

    	// Listar
    	List<PacienteDTO> todos = service.listarTodos();
    	todos.forEach(p -> System.out.println(p.getNome() + " - " + p.getCpf()));
    }
}