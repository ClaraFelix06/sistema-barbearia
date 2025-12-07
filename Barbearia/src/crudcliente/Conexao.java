package crudcliente; // Pacote onde a classe de conexão está localizada.

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
// Adicionar imports para fechar recursos de forma genérica
import java.sql.PreparedStatement; 
import java.sql.ResultSet;

/**
 * Classe utilitária responsável por estabelecer e gerenciar a conexão com o banco de dados MySQL.
 * Contém métodos estáticos para obter e fechar a conexão.
 */
public class Conexao {
    
    // --- Configurações da Conexão (Constantes) ---
    
    // Nome da classe do Driver JDBC para MySQL (necessário para registrar o driver)
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; 
    
    // URL de conexão: Define o SGBD (jdbc:mysql), o endereço (localhost), a porta (3306) e o nome do banco (dbaula)
    private static final String URL = "jdbc:mysql://localhost:3306/barbearia"; 
    
    // Usuário do banco de dados
    private static final String USER = "root"; 
    
    // Senha do usuário do banco de dados
    private static final String PASSWORD = "admin"; 

    // --- Método para Obter Conexão ---
    
    /**
     * Tenta estabelecer e retornar uma nova conexão com o banco de dados.
     * @return Objeto Connection ativo.
     * @throws SQLException Se ocorrer um erro de JDBC ou o Driver não for encontrado.
     */
    public static Connection getConnection() throws SQLException {
        try {
            // 1. Carrega e registra o driver na memória (Passo 1 do JDBC)
            Class.forName(DRIVER); 
            
            // 2. Tenta estabelecer a conexão usando as credenciais (Passo 2 do JDBC)
            return DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (ClassNotFoundException e) {
            // Captura se o driver não estiver no classpath (biblioteca .jar ausente)
            throw new SQLException("Driver JDBC do MySQL não encontrado: " + e.getMessage());
        }
    }
    
    // --- Método para Fechar Conexão (Melhoria Recomendada) ---

    // A sua implementação original está correta para fechar apenas a Connection,
    // mas em projetos DAO é muito útil ter sobrecargas para fechar Statement e ResultSet.

    /**
     * Fecha apenas o objeto Connection, se ele não for nulo.
     * @param conn A Connection a ser fechada.
     */
    public static void closeConnection(Connection conn){
        if (conn != null){
            try{
                conn.close();
            } catch (SQLException e){
                // Usar System.err para logs de erro
                System.err.println("Erro ao fechar conexão: " + e.getMessage()); 
            }
        }
    }

    /**
     * Sobrecarga para fechar Connection e Statement.
     * @param conn A Connection a ser fechada.
     * @param stmt O PreparedStatement a ser fechado.
     */
    public static void closeConnection(Connection conn, PreparedStatement stmt){
        closeConnection(conn); // Chama o método anterior para fechar a conexão
        if (stmt != null){
            try{
                stmt.close();
            } catch (SQLException e){
                System.err.println("Erro ao fechar Statement: " + e.getMessage());
            }
        }
    }

    /**
     * Sobrecarga para fechar Connection, Statement e ResultSet.
     * @param conn A Connection a ser fechada.
     * @param stmt O PreparedStatement a ser fechado.
     * @param rs O ResultSet a ser fechado.
     */
    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs){
        closeConnection(conn, stmt); // Chama o método anterior para fechar conn e stmt
        if (rs != null){
            try{
                rs.close();
            } catch (SQLException e){
                System.err.println("Erro ao fechar ResultSet: " + e.getMessage());
            }
        }
    }

    static Connection getConexao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}