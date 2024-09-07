package org.example;
import java.sql.SQLException;

public abstract class FactoryDao {

        public static final int MYSQL_JDBC = 1;
        public static final int DERBY_JDBC = 2;
        public abstract ClienteDao getClienteDao() throws SQLException;
        public abstract FacturaDao getFacturaDao() throws SQLException;
        public abstract FacturaProductoDao getFacturaProducto() throws SQLException;
        public abstract ProductoJDBC_MySql getProductoDao() throws SQLException;

        public static FactoryDao getDAOFactory(int whichFactory) {
            return switch (whichFactory) {
                case MYSQL_JDBC -> MySqlFactoryDao.getInstance();
                default -> null;
            };
        }
}