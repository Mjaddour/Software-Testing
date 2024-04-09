package task_service;

import java.util.Comparator;

public class Task {

    private final String id;
    private String name;
    private String description;

  
    public Task(final String id, String name, String description) {
        if (id == null || id.length() > 10) { 
            throw new IllegalArgumentException("Invalid contact ID");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        

       this.id = id;    
        this.name = name;
        this.description = description;
    }    
    
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
  

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Task task = (Task) obj;
        return id.equals(task.id);
    }

    public static Comparator<Task> compareById = Comparator.comparing(Task::getId);

    @Override
    public String toString() {
        return "Task ID: " + getId() + "\nName: " + getName() + "\nDescription: " + getDescription() + "\n";
    }
}

