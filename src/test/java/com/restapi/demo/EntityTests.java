package com.restapi.demo;

import com.restapi.demo.entity.ToDoItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntityTests {

    @Test
    public void testToDoItemProperties() {
        ToDoItem toDoItem = new ToDoItem();

        toDoItem.setId(1L);
        toDoItem.setTitle("Title");
        toDoItem.setDescription("Description");

        assertEquals(1L, toDoItem.getId());
        assertEquals("Title", toDoItem.getTitle());
        assertEquals("Description", toDoItem.getDescription());
    }
}
