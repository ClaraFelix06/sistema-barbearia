package barbearia.telas;
import crudcliente.Cliente;
import crudcliente.ClienteDAO;

public class CadastrarCliente extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CadastrarCliente.class.getName());
    private crudcliente.Cliente clienteEdicao = null;

    public CadastrarCliente() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    // Esse método recebe o cliente da outra tela e preenche os campos
    public void preencherDados(crudcliente.Cliente c) {
        this.clienteEdicao = c; // Guarda o cliente na variável
        
        CampoNome.setText(c.getNome());
        CampoEmail.setText(c.getEmail());
        CampoTelefone.setText(c.getTelefone());
        
        // Muda o texto do botão para sabermos que estamos editando
        BotaoCadastro.setText("Atualizar"); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotaoVoltar = new javax.swing.JButton();
        BotaoCadastro = new javax.swing.JButton();
        CampoNome = new javax.swing.JTextField();
        CampoEmail = new javax.swing.JTextField();
        CampoTelefone = new javax.swing.JTextField();
        LabelNome = new javax.swing.JLabel();
        LabelEmail = new javax.swing.JLabel();
        LabelTelefone = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BotaoVoltar.setText("Voltar");
        BotaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoVoltarActionPerformed(evt);
            }
        });

        BotaoCadastro.setText("Cadastrar");
        BotaoCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCadastroActionPerformed(evt);
            }
        });

        CampoTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoTelefoneActionPerformed(evt);
            }
        });
        CampoTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoTelefoneKeyTyped(evt);
            }
        });

        LabelNome.setText("Nome completo");

        LabelEmail.setText("Email");

        LabelTelefone.setText("Telefone");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(BotaoVoltar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CampoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(LabelNome))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(LabelEmail))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(LabelTelefone))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(BotaoCadastro)))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(BotaoVoltar)
                .addGap(18, 18, 18)
                .addComponent(LabelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(LabelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(LabelTelefone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(BotaoCadastro)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CampoTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoTelefoneActionPerformed
       
    }//GEN-LAST:event_CampoTelefoneActionPerformed

    private void BotaoCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCadastroActionPerformed
    String nome = CampoNome.getText();
        String email = CampoEmail.getText();
        String telefone = CampoTelefone.getText();
        
        if (nome.isEmpty() || email.isEmpty() || telefone.isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }
        
        crudcliente.ClienteDAO dao = new crudcliente.ClienteDAO();
        
        // VERIFICAÇÃO IMPORTANTE:
        if (clienteEdicao == null) {
            // Se estiver vazio, é um NOVO cadastro
            crudcliente.Cliente novo = new crudcliente.Cliente();
            novo.setNome(nome);
            novo.setEmail(email);
            novo.setTelefone(telefone);
            
            dao.cadastrarCliente(novo);
        } else {
            // Se já existir algo, é uma EDIÇÃO
            // Atualizamos os dados do objeto que já existe (mantendo o ID dele)
            clienteEdicao.setNome(nome);
            clienteEdicao.setEmail(email);
            clienteEdicao.setTelefone(telefone);
            
            dao.alterarCliente(clienteEdicao); // Chama o UPDATE
        }
        
        // Volta para a lista atualizada
        Clientes novaTela = new Clientes();
        novaTela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BotaoCadastroActionPerformed

    private void BotaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoVoltarActionPerformed
     Clientes novaTela = new Clientes();
     novaTela.setVisible(true);
     this.dispose();
    }//GEN-LAST:event_BotaoVoltarActionPerformed

    private void CampoTelefoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoTelefoneKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")){
            evt.consume();
        }
    }//GEN-LAST:event_CampoTelefoneKeyTyped

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new CadastrarCliente().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoCadastro;
    private javax.swing.JButton BotaoVoltar;
    private javax.swing.JTextField CampoEmail;
    private javax.swing.JTextField CampoNome;
    private javax.swing.JTextField CampoTelefone;
    private javax.swing.JLabel LabelEmail;
    private javax.swing.JLabel LabelNome;
    private javax.swing.JLabel LabelTelefone;
    // End of variables declaration//GEN-END:variables
}
