package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ClienteJDBC_MySql implements ClienteDao {

    private Connection conn;

    public ClienteJDBC_MySql(Connection conn) {
        this.conn = conn;
    }

    @Override
    public int insertCliente(int id, String name, int age) throws SQLException {
        return 0;
    }

    @Override
    public void updateCliente(Cliente cliente) throws SQLException {

    }

    @Override
    public void deleteCliente(int dni) throws SQLException {

    }

    @Override
    public Cliente getCliente(int dni) throws SQLException {
        return null;
    }

    @Override
    public List<Cliente> getPCliente() throws SQLException {
        return List.of();
    }
}