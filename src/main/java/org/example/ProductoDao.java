package org.example;

import java.sql.SQLException;
import java.util.List;

public interface ProductoDao {
    public int insertProducto(int idProducto, String nombre, int valor) throws SQLException;
    public void updateProducto(Producto idProducto) throws SQLException;
    public void deleteProducto(int idProducto) throws SQLException;
    public Producto getProducto(int idProducto) throws SQLException;
    public List<Producto> getProductos() throws SQLException;
}
