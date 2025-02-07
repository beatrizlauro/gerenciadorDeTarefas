/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;
import model.Tarefa;

/**
 *
 * @author User
 */
public class TarefaRepository implements Crud<Tarefa>{
    
    //Crud - inserir
    @Override
    public boolean inserir(Connection connection, Tarefa tarefa) {
        String status = tarefa.isConcluida() ? "Concluída" : "Pendente";
        
        PreparedStatement stmt = null;
        try{
            String comando = "INSERT INTO nova_tarefa (nomeTarefa, descricao, status, dataCriacao) VALUES (?, ?, ?, ?)";
            stmt = connection.prepareStatement(comando);
            stmt.setString(1, tarefa.getNomeTarefa());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, status); // Certo para valores booleanos
            stmt.setDate(4, Date.valueOf(tarefa.getDataCriacao())); // Converte LocalDate para java.sql.Date
            
            stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao inserir tarefa: " + ex.getMessage(),
                    " Erro ao inserir",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        return false;
    }

    //Crud - atualizar
    @Override
    public boolean atualizar(Connection connection, Tarefa tarefa) {
        String status = tarefa.isConcluida() ? "Concluída" : "Pendente";
        
        PreparedStatement stmt = null;
        try{
            String comando = "UPDATE nova_tarefa SET " +
                    "nomeTarefa = ?, descricao = ?, status = ?, dataCriacao = ? " +
                    " WHERE id = ?";
            stmt = connection.prepareStatement(comando);
            stmt.setString(1, tarefa.getNomeTarefa());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, status); // Certo para valores booleanos
            stmt.setDate(4, Date.valueOf(tarefa.getDataCriacao())); // Converte LocalDate para java.sql.Date
            stmt.setInt(5, tarefa.getId());
            
            stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao atualizar tarefa: " + ex.getMessage(),
                    " Erro ao atualizar",
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println(ex.getMessage());
        }
        return false;
    }

    //Crud - deletar
    @Override
    public boolean deletar(Connection connection, Tarefa tarefa) {
        PreparedStatement stmt = null;
        try{
            String comando = "DELETE FROM nova_tarefa " +
                            " WHERE id = ?";
            stmt = connection.prepareStatement(comando);
            stmt.setInt(1, tarefa.getId());
            
            stmt.executeUpdate();
            stmt.close();
            
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao excluir tarefa: " + ex.getMessage(),
                    " Erro ao excluir",
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    @Override
    public Tarefa selecionar(Connection connection, String operador, int id) {
        try {
            Tarefa tarefa = new Tarefa();
            PreparedStatement  stmt = null;
            String comando = "SELECT * FROM nova_tarefa WHERE id " + 
                    operador + " ? ";
            
            if (operador.equals("<"))
                comando += " ORDER BY id DESC";
            
            stmt = connection.prepareStatement(comando);
            stmt.setInt(1,id);
            
            ResultSet res = stmt.executeQuery();
            
            if(res != null) {
                while(res.next()){
                    
                    tarefa.setId(Integer.parseInt(res.getString("id")));
                    tarefa.setNomeTarefa(res.getString("nomeTarefa"));
                    tarefa.setDescricao(res.getString("descricao"));
                    tarefa.setConcluida(res.getBoolean("status"));
                    tarefa.setDataCriacao(res.getDate("dataCriacao").toLocalDate());
                    
                    break;
                }
            }
            return tarefa;
            
        } catch (Exception e) {
            return null;
        } 
    }

    @Override
    public List<Tarefa> listar(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
