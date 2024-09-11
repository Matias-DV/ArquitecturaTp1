package org.example;

import org.example.dao.ClienteDao;
import org.example.dao.FacturaDao;
import org.example.dao.FacturaProductoDao;
import org.example.dao.ProductoDao;
import org.example.entities.Cliente;

import org.example.entities.Factura;
import org.example.entities.FacturaProducto;
import org.example.entities.Producto;
import org.example.factory.FactoryDao;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        FactoryDao mysql = FactoryDao.getDAOFactory(1);


        //mysql.dropTables();
        //mysql.createTables();
        //mysql.populateDB();
        //mysql.getFacturaDao();

        Producto producto = new Producto(111,"Pelota de futbol", 50);
        Cliente cliente1 = new Cliente(111,"Aadaad","asdasda@asdasdad");
        FacturaProducto facturaMati = new FacturaProducto(500,100,300);
        Factura facturaAgus = new Factura(512,99);

        ProductoDao productoDao = mysql.getProductoDao();
        FacturaProductoDao facturaProductoDao = mysql.getFacturaProducto();
        ClienteDao clienteDao = mysql.getClienteDao();
        FacturaDao facturaDao = mysql.getFacturaDao();

        /*ACOMODAR LO DEL ID QUE SEA AUTOINCREMENTAL Y QUE NO SE LO TENGAMOS QUE PASAR NOSOTROS MANUAL*/


        /*Pruebas Matii DV*/
        //productoDao.insertProducto(111,"Auriculares LG Pro Max", 200);
        //productoDao.updateProducto(producto);
        //productoDao.deleteProducto(111);
        //Producto p = productoDao.getProducto(1);
        //p.imprimir();

        //List<Producto> prueba = new ArrayList<Producto>();
        //prueba = productoDao.getProductos();
        //for (Producto producto2 : prueba) {
            //producto2.imprimir();
        //}


        /*Termina Pruebas Matii DV*/

        //--------------------------------------------------------------------------

        /*Pruebas Matii M*/
        //facturaProductoDao.insertFacturaProducto(500,100,10);
        //facturaProductoDao.updateFacturaProducto(facturaMati);
        //facturaProductoDao.deleteFacturaProducto(500,100);
        //List<FacturaProducto> fp = facturaProductoDao.getFacturasProductos();


        /*Termina Pruebas Matii M*/

        //--------------------------------------------------------------------------

        /*Pruebas Laraa M*/
        //clienteDao.insertCliente(111,"lara","lara@lara");
        //clienteDao.updateCliente(cliente1);
        //clienteDao.deleteCliente(111);
        //Cliente c1 = clienteDao.getCliente(111);
        //c1.imprimir();
        //List<Cliente> prueba2 = clienteDao.getClientes();
        //for (Cliente c2 : prueba2) {
            //c2.imprimir();
        //}

        /*Termina Pruebas Laraa M*/

        //--------------------------------------------------------------------------

        /*Pruebas Aguss Q*/
        //facturaDao.insertFactura(512,100);
        //facturaDao.updateFactura(facturaAgus);
        //facturaDao.deleteFactura(512);
        //Factura f1 = facturaDao.getFactura(511);
        //f1.imprimirFactura();
        //List<Factura> f2 = facturaDao.getPFacturas();
        //for (Factura f3 : f2) {
            //f3.imprimirFactura();
        //}

        /*Termina Pruebas Aguss Q*/

        //--------------------------------------------------------------------------

        /* Pruebas Lucass F*/

        //productoDao.insertProducto(112,"Mesa", 100);
        //productoDao.updateProducto(producto);
        //productoDao.deleteProducto(112);
        //Producto p = productoDao.getProducto(100);
        //p.imprimir();

        //List<Producto> prueba = new ArrayList<Producto>();
        //prueba = productoDao.getProductos();
        //for (Producto producto2 : prueba) {
        //producto2.imprimir();
        //}


        /* Termina Pruebas Lucass F*/

        /* Enunciado 3 */

        //Producto masVendido = productoDao.getProductoMasVendido();
        //masVendido.imprimir();

        /* Enuncuado 3 */

        /* Enunciado 4 */

        List<Cliente> masFacturados = clienteDao.getMasFacturadosOrdenados();
        for (Cliente cliente : masFacturados) {
            cliente.imprimir();
        }

        /* Enuncuado 4 */
    }

}
