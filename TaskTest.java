package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Task.Task;


class TaskTest { 
 
	@Test
	void testTask() {
		Task taskTest = new Task ("Target1", "Nightwraith", "These creatures appear after dark under the moon.");
		assertTrue(taskTest.getTaskID().equals("Target1"));
		assertTrue(taskTest.getTaskName().equals("Nightwraith"));
		assertTrue(taskTest.getTaskDescription().equals("These creatures appear after dark under the moon."));
	}
	
	@Test
	void testTaskIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task ("Target11111", "Nightwraith", "These creatures appear after dark under the moon.");
		});
	} 
	
	@Test
	void testTaskIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task (null, "Nightwraith", "These creatures appear after dark under the moon.");
		});
	}
	
	@Test
	void testTaskNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task ("Target1", "Nightwraithhhhhhhhhhh", "These creatures appear after dark under the moon.");
		}); 
	}
	
	@Test
	void testTaskNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task ("Target1", null, "These creatures appear after dark under the moon.");
		});
	}
	
	@Test
	void testTaskDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task ("Target1", "Nightwraith", "These creatures appear after dark under the moon. Go get 'em");
		});
		
	}
		
	@Test
	void testTaskDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task ("Target1", "Nightwraith", null);
		});
	}

}
