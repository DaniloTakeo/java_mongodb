package mongodb.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDTO {
    private String id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private boolean ativo;

}