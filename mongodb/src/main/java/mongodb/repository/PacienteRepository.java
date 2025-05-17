package mongodb.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

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
    
    public Paciente buscarPorId(String id) {
        Document doc = collection.find(Filters.eq("_id", new ObjectId(id))).first();
        if (doc == null) return null;

        Paciente p = new Paciente();
        p.setId(doc.getObjectId("_id").toHexString());
        p.setNome(doc.getString("nome"));
        p.setCpf(doc.getString("cpf"));
        p.setDataNascimento(LocalDate.parse(doc.getString("dataNascimento")));
        p.setAtivo(doc.getBoolean("ativo", true));
        return p;
    }

    public void deletarPorId(String id) {
        collection.deleteOne(Filters.eq("_id", new ObjectId(id)));
    }

    public void atualizar(String id, Paciente paciente) {
        collection.updateOne(
            Filters.eq("_id", new ObjectId(id)),
            Updates.combine(
                Updates.set("nome", paciente.getNome()),
                Updates.set("cpf", paciente.getCpf()),
                Updates.set("dataNascimento", paciente.getDataNascimento().toString()),
                Updates.set("ativo", paciente.isAtivo())
            )
        );
    }
}