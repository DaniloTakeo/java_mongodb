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
    }
}