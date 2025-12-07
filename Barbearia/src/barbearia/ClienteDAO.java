package barbearia;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClienteDAO {
    
    // =================================================================
    // 1. MÉTODO CADASTRAR (Agora com o código certo dentro dele)
    // =================================================================
    public void cadastrarCliente(Cliente objCliente) {
        String sql = "INSERT INTO cliente (nome, email, telefone) VALUES (?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objCliente.getNome());
            pstm.setString(2, objCliente.getEmail());
            pstm.setString(3, objCliente.getTelefone());
            
            pstm.execute();
            // pstm.close(); // Opcional aqui, mas bom fechar no finally
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + erro);
        } finally {
            // Boa prática: Fechar conexões
            try {
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    // =================================================================
    // 2. MÉTODO LISTAR (Esse já estava certo)
    // =================================================================
    public ArrayList<Cliente> listarClientes() {
        
        String sql = "SELECT * FROM cliente";
        ArrayList<Cliente> lista = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Cliente obj = new Cliente();
                obj.setId(rs.getInt("id_cliente"));
                obj.setNome(rs.getString("nome"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));

                lista.add(obj);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + erro);
        } finally {
            // Boa prática: Fechar conexões
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return lista;
    } 
}