package com.restapi.demo;

import com.restapi.demo.entity.ToDoItem;
import com.restapi.demo.repository.ToDoItemRepository;
import com.restapi.demo.service.ToDoItemServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceTests {

    @Mock
    private ToDoItemRepository todoItemRepository;

    @InjectMocks
    private ToDoItemServiceImpl toDoItemService;

    @Test
    public void testCreateTodoItem() {
        ToDoItem toDoItem = new ToDoItem(1L, "Title", "Description");
        when(todoItemRepository.save(Mockito.any(ToDoItem.class))).thenReturn(toDoItem);

        ToDoItem savedTodoItem = toDoItemService.createToDoItem(toDoItem);

        assertNotNull(savedTodoItem);
        assertEquals("Title", savedTodoItem.getTitle());
        assertEquals("Description", savedTodoItem.getDescription());
    }

    @Test
    void testGetAllToDoItems() {
        ToDoItem toDoItem1 = new ToDoItem();
        ToDoItem toDoItem2 = new ToDoItem();

        when(todoItemRepository.findAll()).thenReturn(Arrays.asList(toDoItem1, toDoItem2));

        List<ToDoItem> allToDoItems = toDoItemService.getAllToDoItems();

        assertEquals(2, allToDoItems.size());
    }

    @Test
    void testGetToDoItemById_ExistingId() {
        ToDoItem toDoItem = new ToDoItem();
        toDoItem.setId(1L);

        when(todoItemRepository.findById(1L)).thenReturn(Optional.of(toDoItem));

        ToDoItem foundToDoItem = toDoItemService.getToDoItemById(1L);

        assertEquals(1L, foundToDoItem.getId());
    }

    @Test
    void testGetToDoItemById_NonExistingId() {
        when(todoItemRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> toDoItemService.getToDoItemById(1L));
    }

    @Test
    void testUpdateToDoItem() {
        ToDoItem existingToDoItem = new ToDoItem(1L, "Title", "Description");

        ToDoItem updatedToDoItem = new ToDoItem(1L, "Updated Title", "Updated Description");

        when(todoItemRepository.findById(1L)).thenReturn(Optional.of(existingToDoItem));
        when(todoItemRepository.save(Mockito.any(ToDoItem.class))).thenReturn(updatedToDoItem);

        ToDoItem result = toDoItemService.updateToDoItem(1L, updatedToDoItem);

        assertEquals("Updated Title", result.getTitle());
        assertEquals("Updated Description", result.getDescription());
    }

}
