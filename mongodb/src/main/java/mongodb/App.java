package mongodb;

import java.time.LocalDate;

import mongodb.domain.Paciente;
import mongodb.service.PacienteService;

public class App {
    public static void main(String[] args) {
        PacienteService service = new PacienteService();

        Paciente novo = new Paciente();
        novo.setNome("João da Silva");
        novo.setCpf("12345678900");
        novo.setDataNascimento(LocalDate.of(1990, 5, 14));

        service.cadastrar(novo);

        service.listarTodos().forEach(p ->
            System.out.println(p.getNome() + " - " + p.getCpf())
        );
        
        Paciente encontrado = service.listarTodos().get(0);
        String id = encontrado.getId();

        Paciente atualizado = new Paciente();
        atualizado.setNome("Novo Nome");
        atualizado.setCpf("98765432100");
        atualizado.setDataNascimento(LocalDate.of(1991, 1, 1));
        atualizado.setAtivo(false);

        service.atualizar(id, atualizado);

        Paciente p = service.buscarPorId(id);
        System.out.println("Atualizado: " + p.getNome() + " - Ativo: " + p.isAtivo());
    }
}