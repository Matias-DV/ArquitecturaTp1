package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ClienteJDBC_MySql implements ClienteDao {

    private Connection conn;



    public ClienteJDBC_MySql(Connection conn) throws SQLException {
        this.conn = conn;
    }

    @Override
    public int insertCliente(int idCliente, String nombre, String email) throws SQLException {
        String query = "INSERT INTO Cliente (idCliente, nombre, email) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        try{
            ps.setInt(1, idCliente);
            ps.setString(2, nombre);
            ps.setString(3, email);
            if (ps.executeUpdate() == 0) {
                throw new Exception("No se pudo insertar");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            ps.close();
            conn.commit();
        }
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
    public List<Cliente> getClientes() throws SQLException {
        return List.of();
    }


}