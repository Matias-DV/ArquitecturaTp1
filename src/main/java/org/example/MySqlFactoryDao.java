package org.example;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class MySqlFactoryDao extends FactoryDao {
        public static final String DRIVER= "com.mysql.cj.jdbc.Driver";
        public static final String DBURI= "jdbc:mysql://localhost:3306/MySQLDB";
        public static Connection createConnection() {
            try {
                Class.forName(DRIVER).getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException |
                     SecurityException | ClassNotFoundException | InvocationTargetException e) {
                System.exit(1);
            }
            try {
                Connection conn = DriverManager.getConnection(DBURI, "root", "");
                conn.setAutoCommit(false);
                return conn;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


        @Override
        public ClienteDao getClienteDao() throws SQLException {
            return new ClienteJDBC_MySql(createConnection());
        }

        @Override
        public FacturaDao getFacturaDao() throws SQLException {
            return null;
        }
    }


