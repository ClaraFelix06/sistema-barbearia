package barbearia.telas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import crudcliente.Cliente;
import crudcliente.ClienteDAO;
import crudagenda.Agenda;
import crudagenda.AgendaDAO;
import javax.swing.JOptionPane;

public class Agendar extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Agendar.class.getName());
    private final List<Cliente> listaCompleta = new ArrayList<>();

    public Agendar() {
        initComponents();
        carregarClientes();
         setLocationRelativeTo(null);
        setupAutocomplete(CaixaCliente);
        
        ComboServico.addItem("Corte de Cabelo");
        ComboServico.addItem("Corte de Barba");
        ComboServico.addItem("Sobrancelha");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnVoltar = new javax.swing.JButton();
        CaixaCliente = new javax.swing.JComboBox<>();
        ComboServico = new javax.swing.JComboBox<>();
        BtnAgendar = new javax.swing.JButton();
        DataForm = new javax.swing.JFormattedTextField();
        HoraForm = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BtnVoltar.setText("Voltar");
        BtnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVoltarActionPerformed(evt);
            }
        });

        CaixaCliente.setEditable(true);
        CaixaCliente.setToolTipText("");
        CaixaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaixaClienteActionPerformed(evt);
            }
        });
        CaixaCliente.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                CaixaClientePropertyChange(evt);
            }
        });

        BtnAgendar.setText("Agendar");
        BtnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgendarActionPerformed(evt);
            }
        });

        DataForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataFormActionPerformed(evt);
            }
        });
        DataForm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DataFormKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(BtnVoltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CaixaCliente, 0, 201, Short.MAX_VALUE)
                            .addComponent(ComboServico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DataForm, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(HoraForm, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(189, 189, 189))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnAgendar)
                        .addGap(254, 254, 254))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(BtnVoltar)
                .addGap(44, 44, 44)
                .addComponent(CaixaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ComboServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DataForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HoraForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(BtnAgendar)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void BtnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVoltarActionPerformed
         Menu voltarTela = new Menu();
         voltarTela.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_BtnVoltarActionPerformed

    private void CaixaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaixaClienteActionPerformed

    }//GEN-LAST:event_CaixaClienteActionPerformed

    private void CaixaClientePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_CaixaClientePropertyChange
        CaixaCliente.setEditable(true);
    }//GEN-LAST:event_CaixaClientePropertyChange

    private void BtnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgendarActionPerformed
        // 1. Validar se tem cliente selecionado
        String textoSelecionado = (String) CaixaCliente.getSelectedItem(); // Troque CaixaCliente pelo nome da sua combo
        
        if (textoSelecionado == null || textoSelecionado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um cliente!");
            return;
        }

        try {
            // 2. Extrair o ID da String "Nome | ID"
            // O comando split quebra o texto onde tiver " | "
            String[] partes = textoSelecionado.split(" \\| ");
            
            if (partes.length < 2) {
                JOptionPane.showMessageDialog(this, "Formato inválido. Selecione um cliente da lista.");
                return;
            }
            
            int idCliente = Integer.parseInt(partes[1]); // Pega a parte do número (índice 1)

            // 3. Pegar os outros dados (Serviço, etc)
            // String servico = (String) ComboServico.getSelectedItem();
            
            String servico = (String) ComboServico.getSelectedItem(); 
            String data = DataForm.getText(); 
            String hora = HoraForm.getText(); 

            // 4. Salvar no Banco
            Agenda agendamento = new Agenda();
            agendamento.setIdCliente(idCliente);
            agendamento.setServico(servico);
            agendamento.setData(data);
            agendamento.setHora(hora);
            
            AgendaDAO dao = new AgendaDAO();
            dao.agendar(agendamento);
            
            CaixaCliente.setSelectedIndex(-1); // Limpa a seleção do cliente
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao processar dados: " + e.getMessage());
        }
    }//GEN-LAST:event_BtnAgendarActionPerformed

    private void DataFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataFormActionPerformed

    }//GEN-LAST:event_DataFormActionPerformed

    private void DataFormKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DataFormKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_DataFormKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Agendar().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgendar;
    private javax.swing.JButton BtnVoltar;
    private javax.swing.JComboBox<String> CaixaCliente;
    private javax.swing.JComboBox<String> ComboServico;
    private javax.swing.JFormattedTextField DataForm;
    private javax.swing.JFormattedTextField HoraForm;
    // End of variables declaration//GEN-END:variables

    private void carregarClientes() {
        ClienteDAO dao = new ClienteDAO();
        listaCompleta.addAll(dao.listarClientes());
        
        for (Cliente c : listaCompleta) {
            CaixaCliente.addItem(c.getNome() + " | " + c.getId());
        }
       }
    
    // Lógica para filtrar o Combobox enquanto digita
    private void setupAutocomplete(final JComboBox<String> comboBox) {
        comboBox.setEditable(true);
        final JTextField editor = (JTextField) comboBox.getEditor().getEditorComponent();

        editor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                // Ignora teclas de navegação para permitir selecionar com setas
                if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER) {
                    return;
                }

                String textoDigitado = editor.getText().toLowerCase();
                DefaultComboBoxModel<String> modelo = (DefaultComboBoxModel<String>) comboBox.getModel();
                modelo.removeAllElements();

                // Filtra a lista original
                for (Cliente c : listaCompleta) {
                    // Verifica se o nome contém o que foi digitado
                    if (c.getNome().toLowerCase().contains(textoDigitado)) {
                        modelo.addElement(c.getNome() + " | " + c.getId());
                    }
                }

                comboBox.showPopup(); // Abre a lista automaticamente
                editor.setText(textoDigitado); // Mantém o texto que o usuário estava digitando
            }
        });
    }

}
