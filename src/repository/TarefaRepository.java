package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Tarefa;

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
            String comando = "SELECT * FROM nova_tarefa WHERE id " + operador + " ? ";

            if (operador.equals("<"))
                comando += " ORDER BY id DESC";
            else if (operador.equals(">"))
                comando += " ORDER BY id ASC";

            PreparedStatement stmt = connection.prepareStatement(comando);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();

            if (res != null && res.next()) {  // Se houver ao menos um registro
                tarefa.setId(res.getInt("id"));
                tarefa.setNomeTarefa(res.getString("nomeTarefa"));
                tarefa.setDescricao(res.getString("descricao"));
                String status = res.getString("status");
                tarefa.setConcluida("Concluída".equalsIgnoreCase(status));
                tarefa.setDataCriacao(res.getDate("dataCriacao").toLocalDate());
            }
            stmt.close();
            return tarefa;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
    }
    
    // Método para contar o número de tarefas concluídas ou pendentes
    public int contarTarefasPorStatus(Connection connection, String status) {
        int quantidade = 0;
        String query = "SELECT COUNT(*) FROM nova_tarefa WHERE status = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, status);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                quantidade = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Erro ao contar tarefas: " + e.getMessage());
        }
        
        return quantidade;
    }
    
    public List<Tarefa> listar(Connection connection) {
        List<Tarefa> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM nova_tarefa ORDER BY id DESC";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Tarefa tarefa = new Tarefa();
                tarefa.setId(rs.getInt("id"));
                tarefa.setNomeTarefa(rs.getString("nomeTarefa"));
                tarefa.setDescricao(rs.getString("descricao"));
                String status = rs.getString("status");
                tarefa.setConcluida("Concluída".equalsIgnoreCase(status));
                tarefa.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                tarefas.add(tarefa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tarefas;
    }
}
