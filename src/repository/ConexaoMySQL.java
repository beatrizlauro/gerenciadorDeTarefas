/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Date;
import javax.swing.JOptionPane;
import model.Tarefa;

/**
 *
 * @author User
 */
public class ConexaoMySQL {
    public Conexao conexao = null;
    public static Connection connection = null;
    
    public ConexaoMySQL(Conexao conexao){
        this.conexao = conexao;
    }
    
    public boolean conectar(){
        if(conexao != null){
            try{
                String url = "jdbc:mysql://" + conexao.getEndereco() +
                             ":" + conexao.getPorta() +
                             "/" + conexao.getNomeBanco();
                
                //pegar a classe da Librarie q adicionamos:
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                connection = DriverManager.getConnection(
                        url,
                        conexao.getUser(),
                        conexao.getPassword()
                );
                return true;                
            }catch(Exception ex){
                JOptionPane.showMessageDialog(
                        null,
                        "Erro ao conectar no banco de dados: " + ex.getMessage(),
                        "Erro ao conectar",
                        JOptionPane.ERROR_MESSAGE
                ); 
                return false;
            }
        }else{
            return false;
        }
    }
    
    public boolean insert(Tarefa tarefa){
        String status = tarefa.isConcluida() ? "Concluída" : "Pendente";
        
        PreparedStatement stmt = null;
        try {
            String comando = "INSERT INTO nova_tarefa (nomeTarefa, descricao, status, dataCriacao) VALUES (?, ?, ?, ?)";
            stmt = connection.prepareStatement(comando);
            stmt.setString(1, tarefa.getNomeTarefa());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, status); // Certo para valores booleanos
            stmt.setDate(4, Date.valueOf(tarefa.getDataCriacao())); // Converte LocalDate para java.sql.Date

            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (Exception ex) {
            System.out.println("Erro ao inserir tarefa: " + ex.getMessage());
        }
        return false;
    }
}