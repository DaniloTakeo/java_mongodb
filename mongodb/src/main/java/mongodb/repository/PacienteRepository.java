package mongodb.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import mongodb.config.MongoConfig;
import mongodb.domain.Paciente;

public class PacienteRepository {
    private final MongoCollection<Document> collection;

    public PacienteRepository() {
        MongoDatabase db = MongoConfig.getDatabase();
        this.collection = db.getCollection("pacientes");
    }

    public void salvar(Paciente paciente) {
        Document doc = new Document()
                .append("nome", paciente.getNome())
                .append("cpf", paciente.getCpf())
                .append("dataNascimento", paciente.getDataNascimento().toString())
                .append("ativo", paciente.isAtivo());
        collection.insertOne(doc);
    }

    public List<Paciente> buscarTodos() {
        List<Paciente> lista = new ArrayList<>();
        for (Document doc : collection.find()) {
            Paciente p = new Paciente();
            p.setId(doc.getObjectId("_id").toHexString());
            p.setNome(doc.getString("nome"));
            p.setCpf(doc.getString("cpf"));
            p.setDataNascimento(LocalDate.parse(doc.getString("dataNascimento")));
            p.setAtivo(doc.getBoolean("ativo", true));
            lista.add(p);
        }
        return lista;
    }
}