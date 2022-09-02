
package controler;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.Project;
import util.connectionFactory;


public class ProjectController {

    public void save(Project project){
        
        String sql = "INSERT INTO projects(name, description, createdAt, updatedAt) VALUES (?, ?, ?, ?)";

        
        Connection connection = null;
        PreparedStatement statement = null;
        
            try {
                connection = connectionFactory.getConnection();
                statement = connection.prepareStatement(sql);
                
                statement.setString(1, project.getName());
                statement.setString(2, project.getDescription());
                statement.setDate(3, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
                statement.setDate(4, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
                   
                
                statement.execute();   
                
            } catch (SQLException ex){
                throw new RuntimeException("Erro ao salvar a projeto" + ex.getMessage(), ex);
            }finally{
            connectionFactory.closeConnection(connection, statement);
            }
        
    
    
    }
    
    public void update(Project project){
        
             
        String sql = "UPDATE projects SET name = ?, description = ?, createdAt = ?, updatedAt = ? WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            connection = connectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
            statement.setDate(4, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
            statement.setInt(5, project.getId());
            statement.execute();
            
            
        }catch (Exception ex){
            throw new RuntimeException("Erro ao atualizar projeto" + ex.getMessage(), ex);
        }finally{
            connectionFactory.closeConnection(connection, statement);
        }
        
        
    
    }
    
    
    public void removeById(int idProject) {
        
        String sql = "DELETE FROM projects WHERE id = ?" ;
        
        Connection connection = null;
        PreparedStatement statement = null;  
        
        try{
            connection = connectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idProject);
            statement.execute();
            
        }catch (Exception ex){
            throw new RuntimeException("Erro ao deletar projeto " + ex.getMessage(), ex);
        }finally{
            connectionFactory.closeConnection(connection, statement);
        }
        
    
    }
    
    public List<Project> getALL(){
        
        String sql = "SELECT * FROM projects " ;
        
        Connection connection = null;
        PreparedStatement statement = null; 
        ResultSet resultSet = null;
        
        List<Project> projects = new ArrayList<Project>();
        
        try{
            connection = connectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                Project project = new Project();
                
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getDate("createdAt"));
                project.setUpdatedAt(resultSet.getDate("updatedAt"));
                
               projects.add(project);
            }
            
        }catch (Exception ex){
            throw new RuntimeException("Erro ao buscar projetos" + ex.getMessage(), ex);
        }finally{
            connectionFactory.closeConnection(connection, statement, resultSet);
        }
                
        return projects;    
    }
    
    
}
