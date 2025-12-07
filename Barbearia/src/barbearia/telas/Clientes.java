package barbearia.telas;

import javax.swing.table.DefaultTableModel;
import crudcliente.ClienteDAO;
import crudcliente.Cliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import barbearia.telas.Menu;

public class Clientes extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Clientes.class.getName());
    
    public Clientes() {
        initComponents();
        setLocationRelativeTo(null);
        carregarTabela();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Voltar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BtnEditar = new javax.swing.JButton();
        BtnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Voltar.setText("Voltar");
        Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarActionPerformed(evt);
            }
        });

        jButton1.setText("Cadastrar novo cliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "nome", "email", "telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        BtnEditar.setText("Editar");
        BtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarActionPerformed(evt);
            }
        });

        BtnExcluir.setText("Excluir");
        BtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Voltar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(BtnExcluir))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Voltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(BtnEditar)
                    .addComponent(BtnExcluir))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
      Menu voltarTela = new Menu();
      voltarTela.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_VoltarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       CadastrarCliente novaTela = new CadastrarCliente();
       novaTela.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExcluirActionPerformed
       int linhaSelecionada = jTable1.getSelectedRow();
    
    if (linhaSelecionada == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Selecione um cliente na tabela para excluir.");
        return; // Para o código aqui se não tiver ninguém selecionado
    }
    
    // 2. Pegar o ID do cliente da linha selecionada (Coluna 0 é o ID)
    // O getValueAt retorna um Object, então precisamos converter para (Integer)
    int idCliente = (int) jTable1.getValueAt(linhaSelecionada, 0);
    
    // 3. Perguntar se tem certeza (Confirmação)
    int opcao = javax.swing.JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o cliente?", "Confirmação", javax.swing.JOptionPane.YES_NO_OPTION);
    
    if (opcao == javax.swing.JOptionPane.YES_OPTION) {
        // 4. Criar o objeto e chamar o DAO para excluir
        Cliente obj = new Cliente();
        obj.setId(idCliente);
        
        ClienteDAO dao = new ClienteDAO();
        dao.excluirCliente(obj);
        
        // 5. Atualizar a tabela para o cliente sumir da lista
        carregarTabela();
      }
    }//GEN-LAST:event_BtnExcluirActionPerformed

    private void BtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarActionPerformed
       // 1. Verifica se tem linha selecionada
        int linhaSelecionada = jTable1.getSelectedRow();
        
        if (linhaSelecionada == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecione um cliente para editar.");
            return;
        }
        
        // 2. Pega os dados da tabela
        // (Lembre-se da ordem das colunas: 0=ID, 1=Nome, 2=Email, 3=Telefone)
        int id = (int) jTable1.getValueAt(linhaSelecionada, 0);
        String nome = (String) jTable1.getValueAt(linhaSelecionada, 1);
        String email = (String) jTable1.getValueAt(linhaSelecionada, 2);
        String telefone = (String) jTable1.getValueAt(linhaSelecionada, 3);
        
        // 3. Monta o objeto Cliente com esses dados
        crudcliente.Cliente obj = new crudcliente.Cliente();
        obj.setId(id);
        obj.setNome(nome);
        obj.setEmail(email);
        obj.setTelefone(telefone);
        
        // 4. Abre a tela de cadastro e PASSA os dados
        CadastrarCliente telaCadastro = new CadastrarCliente();
        telaCadastro.preencherDados(obj); // <--- O PULO DO GATO ESTÁ AQUI
        telaCadastro.setVisible(true);
        
        this.dispose(); // Fecha a lista
    }//GEN-LAST:event_BtnEditarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new Clientes().setVisible(true));
    }
    
    private void carregarTabela() {
    try {
        // 1. Instancia o DAO para buscar a lista
        ClienteDAO dao = new ClienteDAO();
        ArrayList<Cliente> listaDeClientes = dao.listarClientes();
        
        // 2. Pega o modelo da sua tabela (jTable1) para podermos mexer nela
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        // 3. Limpa a tabela (tira as linhas de exemplo)
        model.setNumRows(0);

        // 4. Adiciona cada cliente da lista como uma nova linha na tabela
        for (Cliente c : listaDeClientes) {
            model.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getEmail(),
                c.getTelefone()
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao carregar tabela: " + e);
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEditar;
    private javax.swing.JButton BtnExcluir;
    private javax.swing.JButton Voltar;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
