package crudagenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AgendaDAO {
    public void agendar(Agenda obj) {
        String sql = "INSERT INTO agenda (id_cliente, data_agendamento, hora_agendamento, servico) VALUES (?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            conn = Conexao.getConnection();
            pstm = conn.prepareStatement(sql);
            
            pstm.setInt(1, obj.getIdCliente());
            pstm.setString(2, obj.getData());
            pstm.setString(3, obj.getHora());
            pstm.setString(4, obj.getServico());
            
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Agendamento realizado com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao agendar: " + e);
        } finally {
            Conexao.closeConnection(conn, pstm);
        }
    }
}
