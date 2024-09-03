package org.example;

import java.sql.SQLException;
import java.util.List;

public interface FacturaProductoDao {

    public int insertFacturaProducto(int idFactura, int idProducto, int cantidad) throws SQLException;
    public void updateFacturaProducto(FacturaProducto facturaProducto) throws SQLException;
    public void deleteFacturaProducto(int idFactura) throws SQLException;
    public FacturaProducto getFactura(int idFactura) throws SQLException;
    public List<FacturaProducto> getFacturasProductos() throws SQLException;

}
