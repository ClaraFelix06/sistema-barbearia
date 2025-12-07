package barbearia;

import java.sql.Connection;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/barbearia";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    static Connection getConexao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
