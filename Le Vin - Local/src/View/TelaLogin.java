/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.sql.*;
import br.com.Conexao.FazendoConexao;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

/**
 *
 * @author gabri
 */
public class TelaLogin extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String login;
    
    
    public void Logar() {
        
        String sql = "select * from usuarios where login =? and senha =?";
        try {
            // as linhas abaixo prepraram a consulta ao banco em função do 
            // que foi digitado nas caixas de texto. O ponto ? é substituido pelo
            // conteúdo das variáveis
            pst = conexao.prepareStatement(sql);
            pst.setString(1, userLogin.getText());
            pst.setString(2, senhaLogin.getText());
            // a linha abaixo executa a query
            rs = pst.executeQuery();
            login = userLogin.getText();
            //se existir usuário e senha correspondente
            if (rs.next()) {

                JOptionPane.showMessageDialog(null, "Bem vindo");

                //a linha baixo obtem o conteúdo do campo perfil
                String perfil = rs.getString(6);
                // a estrutura abaixo faz o tratamento do perfil
                if (perfil.equals("admin")) {

                    Tela_Principal principal = new Tela_Principal(login);
                    principal.setVisible(true);
                    Tela_Principal.Faturamento.setEnabled(true);
                    Tela_Principal.cadastrarUsuarios.setEnabled(true);
                    Tela_Principal.ExportarClientes.setEnabled(true);
                    this.dispose();
                }else{
                    Tela_Principal principal = new Tela_Principal(login);
                    principal.setVisible(true);
                    this.dispose();
                    
                }
                conexao.close();
            } else {
                JOptionPane.showMessageDialog(null, "usuário e/ou senha inválido(s)");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * Creates new form NovaTelaLogin
     */
    public TelaLogin() {
        initComponents();
        conexao = FazendoConexao.conector();
        //Verificar se esta funcionando o banco de dados
        //System.out.println(conexao);
        if (conexao != null) {
            lblconexao.setText("conectado");
        } else {
            lblconexao.setText("nao conectado");
            
        }
        
        URL caminhoIcone = getClass().getResource("/Images/imagem.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitulo);
        
        this.setTitle("Le Vin - Tela Login" );
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        userLogin = new javax.swing.JTextField();
        senhaLogin = new javax.swing.JPasswordField();
        btnEntrarLogin = new javax.swing.JButton();
        btnSairLogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblconexao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(400, 410));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 410));

        jPanel1.setBackground(new java.awt.Color(32, 178, 170));

        jLabel1.setFont(new java.awt.Font("Ananda", 2, 42)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logoLogin.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(91, 95, 99));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Entre com as suas credenciais");

        userLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userLoginActionPerformed(evt);
            }
        });

        senhaLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                senhaLoginKeyPressed(evt);
            }
        });

        btnEntrarLogin.setBackground(new java.awt.Color(58, 65, 84));
        btnEntrarLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEntrarLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrarLogin.setText("Entrar");
        btnEntrarLogin.setBorderPainted(false);
        btnEntrarLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrarLogin.setFocusPainted(false);
        btnEntrarLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEntrarLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEntrarLoginMouseExited(evt);
            }
        });
        btnEntrarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarLoginActionPerformed(evt);
            }
        });

        btnSairLogin.setBackground(new java.awt.Color(217, 81, 51));
        btnSairLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSairLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnSairLogin.setText("Sair");
        btnSairLogin.setBorderPainted(false);
        btnSairLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSairLogin.setFocusPainted(false);
        btnSairLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSairLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSairLoginMouseExited(evt);
            }
        });
        btnSairLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairLoginActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Login");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Senha");

        lblconexao.setText("Status");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(113, 113, 113)
                        .addComponent(lblconexao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3)
                    .addComponent(btnEntrarLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                    .addComponent(senhaLogin)
                    .addComponent(userLogin)
                    .addComponent(btnSairLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblconexao))
                .addGap(5, 5, 5)
                .addComponent(senhaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnEntrarLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSairLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public boolean checkLogin(String login, String senha) {
        return login.equals("usuario") && senha.equals("cmgvinhos");
    }
    private void userLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userLoginActionPerformed

    }//GEN-LAST:event_userLoginActionPerformed

    private void btnEntrarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarLoginActionPerformed

        Logar();
    }//GEN-LAST:event_btnEntrarLoginActionPerformed

    private void btnSairLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairLoginActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_btnSairLoginActionPerformed

    private void btnEntrarLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarLoginMouseEntered
        btnEntrarLogin.setBackground(new Color(235, 235, 235));
        btnEntrarLogin.setForeground(new Color(58, 65, 84));
    }//GEN-LAST:event_btnEntrarLoginMouseEntered

    private void btnSairLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairLoginMouseEntered
        btnSairLogin.setBackground(new Color(235, 235, 235));
        btnSairLogin.setForeground(new Color(217, 81, 51));
    }//GEN-LAST:event_btnSairLoginMouseEntered

    private void btnEntrarLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarLoginMouseExited
        btnEntrarLogin.setBackground(new Color(50, 65, 84));
        btnEntrarLogin.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnEntrarLoginMouseExited

    private void btnSairLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairLoginMouseExited
        btnSairLogin.setBackground(new Color(217, 81, 51));
        btnSairLogin.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnSairLoginMouseExited

    private void senhaLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_senhaLoginKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            Logar();
        }
    }//GEN-LAST:event_senhaLoginKeyPressed

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
                if ("".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrarLogin;
    private javax.swing.JButton btnSairLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblconexao;
    private javax.swing.JPasswordField senhaLogin;
    private javax.swing.JTextField userLogin;
    // End of variables declaration//GEN-END:variables
}
