package org.example;

import java.sql.SQLException;
import java.util.List;

public class FacturaJDBC_MySql implements FacturaDao {



    @Override
    public int insertFactura(int idFactura, int idCliente) throws SQLException {
        return 0;
    }

    @Override
    public void updateFactura(Factura idFactura) throws SQLException {

    }

    @Override
    public void deleteFactura(int idFactura) throws SQLException {

    }

    @Override
    public Factura getFactura(int idFactura) throws SQLException {
        return null;
    }

    @Override
    public List<Factura> getPFacturas() throws SQLException {
        return List.of();
    }
}
