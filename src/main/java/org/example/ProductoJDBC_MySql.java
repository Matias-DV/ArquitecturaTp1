package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoJDBC_MySql implements  ProductoDao{
    private Connection con;

    public ProductoJDBC_MySql(Connection connection) throws SQLException {
        this.con = connection;
        try{
            String table = "CREATE TABLE persona(" +
                    "id INT," +
                    "nombre VARCHAR(50)," +
                    "edad INT," +
                    "PRIMARY KEY (id))";
            con.prepareStatement(table).execute();
            con.commit();

        }catch(SQLException e){
        }
    }
    @Override
    public int insertProducto(int idProducto, String nombre, int valor) throws SQLException {
        return 0;
    }

    @Override
    public void updateProducto(Producto idProducto) throws SQLException {

    }

    @Override
    public void deleteProducto(int idProducto) throws SQLException {

    }

    @Override
    public Producto getProducto(int idProducto) throws SQLException {
        return null;
    }

    @Override
    public List<Producto> getProductos() throws SQLException {
        ArrayList<Producto> productos = new ArrayList<Producto>();
        String select = "SELECT * FROM productos";
        PreparedStatement ps = con.prepareStatement(select);
        //ResultSet guardara el resultado al ejecutar el estado de la consulta
        ResultSet rs = ps.executeQuery();


    }

    public Producto productoMasRecaudo() {

    }
}
