package Task; 

public class Task {
	private String taskID;
	private String taskName;
	private String taskDescription; 
	
	public Task (String taskID, String taskName, String taskDescription) {
		setTaskID(taskID);
		setTaskName(taskName);
		setTaskDescription(taskDescription);	
	}
	
	private void setTaskID (String taskID) {
		//task ID can't be null or longer than 10 chara
		if (taskID == null || taskID.length() > 10) {
			throw new IllegalArgumentException("Invalid Task ID");
		} else {
			this.taskID = taskID;
		}
	}
	
	public String getTaskID () {
		return taskID;
	}
	
	public void setTaskName (String taskName) {
		//task name can't be null or longer than 20 chara
		if (taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("Invalid Task Name");
		} else {
			this.taskName = taskName;
		}
	}
	
	public String getTaskName () {
		return taskName;
	}
	
	public void setTaskDescription (String taskDescription) {
		//task description can't be null or longer than 50 chara
		if (taskDescription == null || taskDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid Task Description");
		} else {
			this.taskDescription = taskDescription;
		}
	}

	public String getTaskDescription () {
		return taskDescription;
	}
	
	@Override
	public boolean equals(Object o) {
		//exact same object so they're equal
		if (o == this) {
			return true;
		}
		
		//if o isn't a task, not equal
		if (!(o instanceof Task)) {
			return false;
		}
		
		//Cast o as a task
		Task c = (Task) o;
		
		//check if task is equal
		return this.getTaskID().equals(c.getTaskID());
	}
}
