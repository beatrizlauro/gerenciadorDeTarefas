package view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Tarefa;

public class TaskWidget extends javax.swing.JPanel {

    public TaskWidget() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 87, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public TaskWidget(Tarefa tarefa) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        setBackground(Color.WHITE);
        
        // Cria labels para os dados
        JLabel lblNome = new JLabel("Nome: " + tarefa.getNomeTarefa());
        JLabel lblDescricao = new JLabel("Descrição: " + tarefa.getDescricao());
        String status = tarefa.isConcluida() ? "Concluída" : "Pendente";
        JLabel lblStatus = new JLabel("Status: " + status);
        JLabel lblData = new JLabel("Data: " + tarefa.getDataCriacao().toString());
        
        // Organiza os labels em um painel vertical
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.add(lblNome);
        infoPanel.add(lblDescricao);
        infoPanel.add(lblStatus);
        infoPanel.add(lblData);
        
        add(infoPanel, BorderLayout.CENTER);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
