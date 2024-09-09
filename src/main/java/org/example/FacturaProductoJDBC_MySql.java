package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacturaProductoJDBC_MySql implements FacturaProductoDao {
    private Connection conn;

    public FacturaProductoJDBC_MySql(Connection con) {
        this.conn = con;
    }

    @Override
    public int insertFacturaProducto(int idFactura, int idProducto, int cantidad) throws SQLException {
        String query = "INSERT INTO Factura_Producto (idFactura, idProducto, cantidad) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        try {
            ps.setInt(1, idFactura);
            ps.setInt(2, idProducto);
            ps.setInt(3, cantidad);
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
    public void updateFacturaProducto(FacturaProducto idFactura) throws SQLException {
        // Consulta para verificar si el producto factura existe
        String select = "SELECT * FROM Factura_Producto WHERE idFactura = ?";
        PreparedStatement psSelect = null;
        PreparedStatement psUpdate = null;
        ResultSet rs = null;

        try {
            //Preparando el SELECT para verificar la existencia de la factura
            psSelect = conn.prepareStatement(select);
            psSelect.setInt(1, idFactura.getIdFactura());
            rs = psSelect.executeQuery();

            // Si la factura existe, actualizamos
            if (rs.next()) {
                // Consulta para actualizar la factura
                String update = "UPDATE Factura_Producto SET idProducto = ?, cantidad = ? WHERE idFactura = ?";

                // Preparando la actualización
                psUpdate = conn.prepareStatement(update);
                psUpdate.setInt(1, idFactura.getIdFactura());
                psUpdate.setInt(2, idFactura.getIdProducto());
                psUpdate.setInt(3, idFactura.getCantidad());


                // Ejecutando la actualización
                int rowsAffected = psUpdate.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Factura producto actualizado con éxito.");
                } else {
                    System.out.println("No se pudo actualizar la factura.");
                }
            } else {
                System.out.println("factura no encontrada.");
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

        conn.commit();
    }

    @Override
    public void deleteFacturaProducto(int idFactura) throws SQLException {
        // Consulta para verificar si la factura existe
        String select = "SELECT * FROM Factura_Producto WHERE idFactura = ?";
        // Consulta para eliminar la factura
        String delete = "DELETE FROM Factura_Producto WHERE idFactura = ?";

        PreparedStatement psSelect = null;
        PreparedStatement psDelete = null;
        ResultSet rs = null;

        try {
            // Preparar el SELECT para verificar la existencia de la factura
            psSelect = conn.prepareStatement(select);
            psSelect.setInt(1, idFactura);
            rs = psSelect.executeQuery();

            // Si la factura existe, se elimina
            if (rs.next()) {
                // Preparar la eliminación
                psDelete = conn.prepareStatement(delete);
                psDelete.setInt(1, idFactura);

                // Ejecutar la eliminación
                int rowsAffected = psDelete.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Factura eliminada con éxito.");
                } else {
                    System.out.println("No se pudo eliminar la factura.");
                }
            } else {
                System.out.println("Factura no encontrada.");
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
    public FacturaProducto getFactura(int idFactura) throws SQLException {
        String select = "select * from Factura_Producto where idFactura = ?";
        PreparedStatement ps = conn.prepareStatement(select);
        ps.setInt(1, idFactura);
        ResultSet rs = ps.executeQuery();
        return new FacturaProducto(rs.getInt("idFactura"), rs.getInt("idProducto"), rs.getInt("cantidad"));
    }

    @Override
    public List<FacturaProducto> getFacturasProductos() throws SQLException {
        ArrayList<FacturaProducto> result = new ArrayList<FacturaProducto>();
        String select = "SELECT * FROM Factura_Producto";
        PreparedStatement ps = this.conn.prepareStatement(select);

        //ResultSet guardara el resultado al ejecutar el estado de la consulta
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            result.add(new FacturaProducto(rs.getInt("idFactura"), rs.getInt("idProducto"), rs.getInt("cantidad")));
        }
        return result;
    }
}
