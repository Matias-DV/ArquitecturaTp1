package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws Exception {

        FactoryDao mysql = FactoryDao.getDAOFactory(1);

        //mysql.dropTables();
        //mysql.createTables();
        //mysql.populateDB();
        //mysql.getFacturaDao();
        ClienteDao cliente = mysql.getClienteDao();

        Producto producto = new Producto(111,"Pelota de futbol", 50);
        Cliente cliente1 = new Cliente(111,"lara","lara@lara");

        ProductoDao productoDao = mysql.getProductoDao();
        FacturaProductoDao facturaProductoDao = mysql.getFacturaProducto();
        ClienteDao clienteDao = mysql.getClienteDao();

        /*ACOMODAR LO DEL ID QUE SEA AUTOINCREMENTAL Y QUE NO SE LO TENGAMOS QUE PASAR NOSOTROS MANUAL*/


        /*Pruebas Matii DV*/
        //productoDao.insertProducto(111,"Auriculares LG Pro Max", 200);
        //productoDao.updateProducto(producto);
        //productoDao.deleteProducto(111);
        //Producto p = productoDao.getProducto(1);
        //p.imprimir();

        /*Termina Pruebas Matii DV*/

        //--------------------------------------------------------------------------

        /*Pruebas Matii M*/

        //facturaProductoDao.insertFacturaProducto(500,100,10);

        /*Termina Pruebas Matii M*/

        //--------------------------------------------------------------------------

        /*Pruebas Laraa M*/
        //clienteDao.insertCliente(111,"lara","lara@lara");

        /*Termina Pruebas Laraa M*/

        //--------------------------------------------------------------------------

        /*Pruebas Aguss Q*/
        /*Termina Pruebas Aguss Q*/

        //--------------------------------------------------------------------------

        /*Pruebas Lucass F*/
        /*Termina Pruebas Lucass F*/
    }
}
