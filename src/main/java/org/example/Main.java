package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws Exception {

        FactoryDao elejirDB = FactoryDao.getDAOFactory(1);


        MySqlFactoryDao mysql = MySqlFactoryDao.getInstance();

        mysql.createConnection();

        //mysql.dropTables();
        //mysql.createTables();
        //mysql.populateDB();
        mysql.getFacturaDao();
        ClienteDao cliente = mysql.getClienteDao();
    }



}