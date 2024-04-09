package task_service;

import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows; 

public class TaskTest {

	@Test
    public void validTaskData() {
       Task task = new Task("0000000001", "Reading", "Read Novel Book");
      assertEquals("0000000001",task.getId());
      assertEquals("Reading",task.getName());
      assertEquals("Read Novel Book",task.getDescription());

 }
	@Test
	public void invalidIdNull() {
	   assertThrows(IllegalArgumentException.class, () -> new Task(null, "Reading", "Read Novel Book"));
	
	}
	
	@Test
	public void invalidId() {
	   assertThrows(IllegalArgumentException.class, () -> new Task("12323232323212121221", "Reading", "Read Novel Book"));
	
	}
	
	@Test
	public void failedUpdateId() {
		Task task = new Task("0000000001", "Reading", "Read Novel Book");
		String originalId = task.getId();
		assertEquals(originalId, task.getId());
	}
       
	
	@Test
	public void invalidNameNull() {
	   assertThrows(IllegalArgumentException.class, () -> new Task("123", null, "Read Novel Book"));
	
	}
	@Test
	public void invalidName() {
	   assertThrows(IllegalArgumentException.class, () -> new Task("123","Readilng Reading Reading Reading Reading", "Read Novel Book"));
	
	}
	
	@Test
	public void invalidDescriptionNull() {
	   assertThrows(IllegalArgumentException.class, () -> new Task("123","Readilng Reading Reading Reading Reading", null));
	
	}
	@Test
	public void invalidDescription() {
	   assertThrows(IllegalArgumentException.class, () -> new Task("123","Readilng Reading Reading Reading Reading", "The cat sat on the mat, purring softly as I read."));
	   
	}

}
