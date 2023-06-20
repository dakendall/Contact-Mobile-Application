package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import TaskService.TaskService;

class TaskServiceTest { 

	@Test
	void testAddingTest() { 
		
		//adding multiple task
		TaskService taskTest = new TaskService ();
		taskTest.addingTask("Target1", "Nightwraith", "These creatures appear after dark under the moon." );
		taskTest.addingTask("Target2", "Wyvern", "Druids like to keep them as pets." );
		assertEquals(taskTest.taskService.size(), 2);
	}
	
	@Test
	void testExistingTask() {
		TaskService taskTest = new TaskService ();
		
		//adding task w/ same id # 
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		taskTest.addingTask("Target1", "Nightwraith", "These creatures appear after dark under the moon." );
		taskTest.addingTask("Target1", "Nightwraith", "These creatures appear after dark under the moon." ); 
		});
	}

	@Test
	void testDeleteTask() {
		TaskService taskTest = new TaskService();
		taskTest.addingTask("Target1", "Nightwraith", "These creatures appear after dark under the moon.");
		
		//delete task
		taskTest.deleteTask("Target1");
		assertEquals(taskTest.taskService.size(), 0);
		
		//testing task that doesn't exist
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		taskTest.deleteTask("Target1");
		});
	}
	
	@Test
	void testUpdatingTask() {
		TaskService taskTest = new TaskService ();
		taskTest.addingTask("Target1", "Nightwraith", "These creatures appear after dark under the moon.");
		
		//update task
		taskTest.updateTask ("Target1", "Wyvern", "Druids like to keep them as pets."); 
		assertEquals(taskTest.taskService.size(), 1);
	} 
	
}
