/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import static View.PesquisaCliente1.paiPedido;
import static View.PesquisaProduto.paiPedidoProduto;
import java.sql.*;
import br.com.Conexao.FazendoConexao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author gabri
 */
public class PesquisarAlterarProduto extends javax.swing.JDialog {
    public static AlterarPedido paiPedidoProduto;
    String indiceProduto;
    CadastroPedido passaProduto;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form PesquisarAlterarProduto
     */
    public PesquisarAlterarProduto(AlterarPedido parent, boolean modal) {
        //super(parent, modal);
        this.paiPedidoProduto = parent;
        this.setModal(modal);
        initComponents();
        conexao = FazendoConexao.conector();
    }
    
    private void Busca_Produtos() {
        System.out.println("entrou aqui");
        String sqlBusca = "select idVinho, NomeProduto, Preco from produtos  where NomeProduto like ? ";
        try {
            pst = conexao.prepareStatement(sqlBusca);
            //passando o conteudo da caixa de pesquisa para o interroga 
            //atencao ao % que é a continuacao da string busca sql
            pst.setString(1, nomeProduto.getText() + "%");
            rs = pst.executeQuery();
            //a linha abaixo usa a biblioteca para preeencher a tabela
            tabelaProduto.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }

    }
    
    public void setar_camposProduto() {
        //pega o id do Cliente na tabela 
        int indiceTabela = tabelaProduto.getSelectedRow();

        if (indiceTabela == -1) {
            //ou seja não há nenhum cliente selecionado 
            JOptionPane.showMessageDialog(null, "Por favor selecione um produto para adicionar");
        } else {
            //pegando o indice do cliente selecionado
            indiceProduto = tabelaProduto.getModel().getValueAt(indiceTabela, 0).toString();
                      
            paiPedidoProduto.RecebeProdutoSelecionado(indiceProduto);
            
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nomeProduto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscarProduto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        btnNovoCliente = new javax.swing.JButton();
        btnAdicionarProduto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 251, 238));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos"));

        jLabel1.setText("Nome Produto:");

        btnBuscarProduto.setBackground(new java.awt.Color(102, 102, 102));
        btnBuscarProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscarProduto.setForeground(new java.awt.Color(0, 204, 255));
        btnBuscarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/right.png"))); // NOI18N
        btnBuscarProduto.setText("Buscar");
        btnBuscarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnBuscarProduto)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(null);

        tabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod. Produto", "Nome Produto", "email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaProduto);

        btnNovoCliente.setBackground(new java.awt.Color(102, 102, 102));
        btnNovoCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNovoCliente.setForeground(new java.awt.Color(0, 204, 255));
        btnNovoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1515.png"))); // NOI18N
        btnNovoCliente.setText("Novo Produto");
        btnNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoClienteActionPerformed(evt);
            }
        });

        btnAdicionarProduto.setBackground(new java.awt.Color(102, 102, 102));
        btnAdicionarProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdicionarProduto.setForeground(new java.awt.Color(0, 204, 255));
        btnAdicionarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Simbolo-Mais.png"))); // NOI18N
        btnAdicionarProduto.setText("Adicionar");
        btnAdicionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnNovoCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdicionarProduto)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoCliente)
                    .addComponent(btnAdicionarProduto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProdutoActionPerformed
        Busca_Produtos();
    }//GEN-LAST:event_btnBuscarProdutoActionPerformed

    private void btnAdicionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarProdutoActionPerformed
        setar_camposProduto();
        dispose();
    }//GEN-LAST:event_btnAdicionarProdutoActionPerformed

    private void btnNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoClienteActionPerformed
        CadastroProduto produto = new CadastroProduto();
        Tela_Principal.fundoArea.add(produto);
        produto.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnNovoClienteActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PesquisarAlterarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisarAlterarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisarAlterarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisarAlterarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PesquisarAlterarProduto dialog = new PesquisarAlterarProduto(paiPedidoProduto, true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarProduto;
    private javax.swing.JButton btnBuscarProduto;
    private javax.swing.JButton btnNovoCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeProduto;
    private javax.swing.JTable tabelaProduto;
    // End of variables declaration//GEN-END:variables
}
