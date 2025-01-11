package lldQuestions.taskManagerDesign;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskManager {
    private Map<String,Task>tasks;
    private Map<String,List<Task>>userTask;

    public TaskManager(){
        this.tasks=new ConcurrentHashMap<>();
        this.userTask=new ConcurrentHashMap<>();
    }

    public void createTask(Task task){
        tasks.put(task.getId(),task);
        assignTaskToUser(task.getUserAssigned(),task);
    }

    private void assignTaskToUser(User user,Task task){
        userTask.computeIfAbsent(user.getId(), k->new CopyOnWriteArrayList<>()).add(task);
    }

    public void updateTask(Task updatedTask){
        Task existingTask=tasks.get(updatedTask.getId());
        if(existingTask!=null){
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setDueDate(updatedTask.getDueDate());
            existingTask.setPriority(updatedTask.getPriority());
            existingTask.setStatus(updatedTask.getStatus());
            User previousUser=existingTask.getUserAssigned();
            User newUser=updatedTask.getUserAssigned();
            if(!previousUser.equals(newUser)){
                unassignTaskFromUser(previousUser,existingTask);
                assignTaskToUser(newUser, existingTask);
            }
        }
    }

    public void unassignTaskFromUser(User user,Task task){
        List<Task> tasks=userTask.get(user.getId());
        if(tasks!=null){
            tasks.remove(task);
        }
    }

    public void deleteTask(String taskId){
        Task task=tasks.remove(taskId);
        if(task!=null){
            unassignTaskFromUser(task.getUserAssigned(), task);
        }
    }

    public List<Task> searchTasks(String query){
        List<Task>searchedTasks=new ArrayList<>();
        for(Task task:tasks.values()){
            if(task.getTitle().contains(query) || task.getDescription().contains(query)){
                searchedTasks.add(task);
            }
        }
        return searchedTasks;
    }

    public List<Task> filterTasks(TaskStatus status,Date startDate,Date endDate,Integer priority){
        List<Task>filteredTasks=new ArrayList<>();
        for(Task task:tasks.values()){
            if(task.getStatus().equals(status) && task.getDueDate().compareTo(startDate)>=0 && task.getDueDate().compareTo(endDate)<=0 && task.getPriority()==priority){
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }

    public void markTaskAsCompleted(String taskId){
        Task task=tasks.get(taskId);
        if(task!=null){
            task.setStatus(TaskStatus.COMPLETED);
        }
    }

    public List<Task> getTaskHistory(User user) {
        return new ArrayList<>(userTask.getOrDefault(user.getId(), new ArrayList<>()));
    }
}
