/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import model.Tarefa;
import repository.Conexao;
import repository.ConexaoMySQL;
import static repository.ConexaoMySQL.connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author User
 */
public class JanelaPrincipal extends javax.swing.JFrame {

    JanelaNovaTarefa janelaNovaTarefa;
    public List<Tarefa> lstTarefas;
    public int ultimoId;
    private Conexao conexao;
    public ConexaoMySQL conexaoMySQL;


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        newTask = new javax.swing.JButton();
        close = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        doneTasks = new java.awt.Label();
        jTextField2 = new javax.swing.JTextField();
        undoneTasks = new java.awt.Label();
        scrollPanel = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        newTask.setText("Nova Tarefa");
        newTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTaskActionPerformed(evt);
            }
        });

        close.setText("Sair");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        jTextField1.setEnabled(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        doneTasks.setText("Tarefas Concluídas");

        jTextField2.setEnabled(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        undoneTasks.setText("Tarefas Pendentes");

        desktopPane.setLayer(newTask, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(close, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(doneTasks, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(undoneTasks, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(scrollPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(desktopPaneLayout.createSequentialGroup()
                        .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(undoneTasks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(doneTasks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(desktopPaneLayout.createSequentialGroup()
                        .addComponent(newTask)
                        .addGap(18, 18, 18)
                        .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newTask)
                    .addComponent(close))
                .addGap(26, 26, 26)
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(doneTasks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(undoneTasks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JanelaPrincipal() {
        initComponents();
        lstTarefas = new ArrayList<>();
        ultimoId = 0;
        conexao = new Conexao(
                "localhost",
                "root",
                "",
                3306,
                "cadastro"
        );
        conexaoMySQL = new ConexaoMySQL(conexao);
        conexaoMySQL.conectar();
    }
    
    public int getQuantidadeTarefasConcluidas() {
        int quantidade = 0;
        String query = "SELECT COUNT(*) FROM nova_tarefa WHERE status = 'Concluída'";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                quantidade = rs.getInt(1);
            }

        } catch (Exception ex) {
            System.out.println("Erro ao contar tarefas concluídas: " + ex.getMessage());
        }

        return quantidade;
    }

    
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        txtTarefasConcluidas.setText(String.valueOf(getQuantidadeTarefasConcluidas()));
    }//GEN-LAST:event_jTextField1ActionPerformed

    public int getQuantidadeTarefasPendentes() {
        int quantidade = 0;
        String query = "SELECT COUNT(*) FROM nova_tarefa WHERE status = 'Pendente'";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                quantidade = rs.getInt(1);
            }

        } catch (Exception ex) {
            System.out.println("Erro ao contar tarefas pendentes: " + ex.getMessage());
        }

        return quantidade;
    }
    
    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        txtTarefasPendentes.setText(String.valueOf(getQuantidadeTarefasPendentes()));
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void newTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTaskActionPerformed
        try{
            janelaNovaTarefa = JanelaNovaTarefa.getInstancia(this);
            if(!desktopPane.isAncestorOf(janelaNovaTarefa)){
                desktopPane.add(janelaNovaTarefa);
                janelaNovaTarefa.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
            }
            
            janelaNovaTarefa.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showConfirmDialog(null, 
                    "Erro ao abrir a tela de nova tarefa: ",
                    "Cadastro de clientes",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_newTaskActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close;
    private javax.swing.JDesktopPane desktopPane;
    private java.awt.Label doneTasks;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton newTask;
    private javax.swing.JScrollPane scrollPanel;
    private java.awt.Label undoneTasks;
    // End of variables declaration//GEN-END:variables

    private static class txtTarefasConcluidas {

        private static void setText(String valueOf) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public txtTarefasConcluidas() {
        }
    }

    private static class txtTarefasPendentes {

        private static void setText(String valueOf) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public txtTarefasPendentes() {
        }
    }
}
