package repository;

import java.sql.Connection;
import java.util.List;

interface Crud<T> {
    public boolean inserir(Connection connection, T entity);
    public boolean atualizar(Connection connection, T entity);
    public boolean deletar(Connection connection, T entity);
    public T selecionar(Connection connection, String operador, int id);
    public List<T> listar(Connection connection);   
}
