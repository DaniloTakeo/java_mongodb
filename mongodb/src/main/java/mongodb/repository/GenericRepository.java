package mongodb.repository;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<T, ID> {
    void salvar(T entity);
    Optional<T> buscarPorId(ID id);
    List<T> buscarTodos();
    void deletarPorId(ID id);
}