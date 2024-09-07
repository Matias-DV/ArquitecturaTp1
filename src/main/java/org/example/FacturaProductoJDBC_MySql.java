package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class FacturaProductoJDBC_MySql implements FacturaProductoDao {
        private Connection conn;

    public FacturaProductoJDBC_MySql(Connection con) {
            this.conn = con;
    }

    @Override
    public int insertFacturaProducto(int idFactura, int idProducto, int cantidad) throws SQLException {
        return 0;
    }

    @Override
    public void updateFacturaProducto(FacturaProducto facturaProducto) throws SQLException {

    }

    @Override
    public void deleteFacturaProducto(int idFactura) throws SQLException {

    }

    @Override
    public FacturaProducto getFactura(int idFactura) throws SQLException {
        return null;
    }

    @Override
    public List<FacturaProducto> getFacturasProductos() throws SQLException {
        return List.of();
    }
}
