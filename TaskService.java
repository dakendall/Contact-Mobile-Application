package TaskService;

import java.util.ArrayList;
import java.util.Iterator;

import Task.Task;

public class TaskService {

	public ArrayList<Task> taskService = new ArrayList<Task>();
	
	public void addingTask(String taskID, String taskName, String taskDescription) {
		Task newTask = new Task (taskID, taskName, taskDescription);
		
		if(taskService.contains(newTask)) {
			//task id is already in the arraylist
		throw new IllegalArgumentException ("The Task ID is already in the system");
		} else {
			//add new task
			taskService.add(newTask); 
		}
	}
	 
	public void deleteTask (String taskID) {
		Iterator<Task> itr = taskService.iterator();
		while(itr.hasNext() ) {
			Task task = itr.next();
			if (task.getTaskID().equals(taskID)) {
				itr.remove();
				return;
			}
		}
		
		throw new IllegalArgumentException ("The Task ID is not in the system");
	}
	
	public void updateTask(String taskID, String taskName, String taskDescription) {
			
			Iterator<Task> itr = taskService.iterator();
			
			while(itr.hasNext() ) {
				Task task = itr.next();
				if (task.getTaskID().equals(taskID)) {
					task.setTaskName(taskName);
					task.setTaskDescription(taskDescription);
					return;
				}
			}
			
		throw new IllegalArgumentException ("The Task ID is not in the system");
	}
	
}
