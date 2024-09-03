package org.example;

import java.sql.SQLException;
import java.util.List;

public interface ClienteDao {
    public int insertCliente(int idCliente, String nombre, int email) throws SQLException;
    public void updateCliente(Cliente cliente) throws SQLException;
    public void deleteCliente(int idCliente) throws SQLException;
    public Cliente getCliente(int idCliente) throws SQLException;
    public List<Cliente> getClientes() throws SQLException;
}
