package TodoApp;

import controler.ProjectController;
import controler.TaskController;
import java.util.List;
import model.Project;
import model.Task;


public class Main {
    
    public static void main(String[] args) {
            
        ProjectController  projectController = new ProjectController();
        Project project = new Project();
        project.setName("joazinho");
        project.setId(4);
        projectController.update(project);
        
        projectController.removeById(4);
        
        
       // List<Project>projects = projectController.getALL();
        
        //System.out.println("total de projetso: " + projects.size());
        
        
        
        TaskController taskController = new TaskController();
        
        Task task = new Task();
        
        //task.setIdProject(5);
        task.setName("lAFSEFASEFSFASE");
        //task.setNotes("pool");
        //task.setIsCompleted(true);
        taskController.save(task);
                 
              
        
        //task.setId(4);
        //taskController.update(task);
        //taskController.removeById(4);
        //task.setIdProject(5);    
        
        //List<Task> tasks = taskController.getALL(2);
        //System.out.println("total de tarefas: " + tasks.size());
        
       
        
        
        
        
        
      
        
        
        
        
        
        
        
        
        
        
        
        
            
            
            
           
            
       
    }
    
}
