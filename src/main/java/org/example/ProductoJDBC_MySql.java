package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoJDBC_MySql implements  ProductoDao{
    private Connection conn;

    public ProductoJDBC_MySql(Connection conn) {
        this.conn = conn;
    }

    @Override
    public int insertProducto(int idProducto, String nombre, int valor) throws SQLException {
        String query = "INSERT INTO producto (idProducto, nombre, valor) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idProducto);
        ps.setString(2, nombre);
        ps.setInt(3, valor);
        return ps.executeUpdate();
    }

    @Override
    public void updateProducto(Producto idProducto) throws SQLException {
        // Consulta para verificar si el producto existe
        String select = "SELECT * FROM producto WHERE idProducto = ?";
        PreparedStatement psSelect = null;
        PreparedStatement psUpdate = null;
        ResultSet rs = null;

        try {
            // Preparando el SELECT para verificar la existencia del producto
            psSelect = conn.prepareStatement(select);
            psSelect.setInt(1, idProducto.getId());
            rs = psSelect.executeQuery();

            // Si el producto existe, actualizamos
            if (rs.next()) {
                // Consulta para actualizar el producto
                String update = "UPDATE producto SET nombre = ?, valor = ? WHERE idProducto = ?";

                // Preparando la actualización
                psUpdate = conn.prepareStatement(update);
                psUpdate.setString(1, idProducto.getNombre());
                psUpdate.setDouble(2, idProducto.getValor());

                // Ejecutando la actualización
                int rowsAffected = psUpdate.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Producto actualizado con éxito.");
                } else {
                    System.out.println("No se pudo actualizar el producto.");
                }
            } else {
                System.out.println("Producto no encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Relanzar la excepción para que la maneje la capa superior
        } finally {
            // Cerrar ResultSet, PreparedStatement
            if (rs != null) {
                rs.close();
            }
            if (psSelect != null) {
                psSelect.close();
            }
            if (psUpdate != null) {
                psUpdate.close();
            }
        }
    }

    @Override
    public void deleteProducto(int idProducto) throws SQLException {
        // Consulta para verificar si el producto existe
        String select = "SELECT * FROM producto WHERE idProducto = ?";
        // Consulta para eliminar el producto
        String delete = "DELETE FROM producto WHERE idProducto = ?";

        PreparedStatement psSelect = null;
        PreparedStatement psDelete = null;
        ResultSet rs = null;

        try {
            // Preparar el SELECT para verificar la existencia del producto
            psSelect = conn.prepareStatement(select);
            psSelect.setInt(1, idProducto);
            rs = psSelect.executeQuery();

            // Si el producto existe, se elimina
            if (rs.next()) {
                // Preparar la eliminación
                psDelete = conn.prepareStatement(delete);
                psDelete.setInt(1, idProducto);

                // Ejecutar la eliminación
                int rowsAffected = psDelete.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Producto eliminado con éxito.");
                } else {
                    System.out.println("No se pudo eliminar el producto.");
                }
            } else {
                System.out.println("Producto no encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Relanzar la excepción para que la maneje la capa superior
        } finally {
            // Cerrar ResultSet y PreparedStatement
            if (rs != null) {
                rs.close();
            }
            if (psSelect != null) {
                psSelect.close();
            }
            if (psDelete != null) {
                psDelete.close();
            }
        }
    }

    @Override
    public Producto getProducto(int idProducto) throws SQLException {
        String select = "select * from producto where idProducto = ?";
        PreparedStatement ps = conn.prepareStatement(select);
        ps.setInt(1, idProducto);
        ResultSet rs = ps.executeQuery();
        return new Producto(rs.getInt("idProducto"), rs.getString("nombre"), rs.getInt("valor"));
    }

    @Override
    public List<Producto> getProductos() throws SQLException {
        ArrayList<Producto> result = new ArrayList<Producto>();
        String select = "SELECT * FROM productos";
        PreparedStatement ps = this.conn.prepareStatement(select);

        //ResultSet guardara el resultado al ejecutar el estado de la consulta
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            result.add(new Producto(rs.getInt("idProducto"), rs.getString("nombre"), rs.getInt("valor")));
        }
        return result;

    }

}
