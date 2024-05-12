package com.restapi.demo;

import com.restapi.demo.controller.ToDoItemControllerImpl;
import com.restapi.demo.entity.ToDoItem;
import com.restapi.demo.service.ToDoItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ControllerTests {

    @Mock
    private ToDoItemService toDoItemService;

    @InjectMocks
    private ToDoItemControllerImpl toDoItemController;

    private ToDoItem testToDoItem;

    @BeforeEach
    void setUp() {
        testToDoItem = new ToDoItem();
        testToDoItem.setId(1L);
        testToDoItem.setTitle("Test Todo");
        testToDoItem.setDescription("This is a test todo item");
    }

    @Test
    void createToDoItem_ReturnsCreatedHttpStatus() {
        ResponseEntity<HttpStatus> response = toDoItemController.createToDoItem(testToDoItem);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(toDoItemService, times(1)).createToDoItem(testToDoItem);
    }

    @Test
    void getAllToDoItems_ReturnsListOfToDoItems() {
        List<ToDoItem> testToDoItemList = new ArrayList<>();
        testToDoItemList.add(testToDoItem);

        when(toDoItemService.getAllToDoItems()).thenReturn(testToDoItemList);

        ResponseEntity<List<ToDoItem>> response = toDoItemController.getAllToDoItems();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testToDoItemList, response.getBody());
    }

    @Test
    void getToDoItemById_ReturnsToDoItemById() {
        when(toDoItemService.getToDoItemById(1L)).thenReturn(testToDoItem);

        ResponseEntity<ToDoItem> response = toDoItemController.getToDoItemById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testToDoItem, response.getBody());
    }

    @Test
    void updateToDoItem_ReturnsUpdatedToDoItem() {
        ToDoItem updatedToDoItem = new ToDoItem();
        updatedToDoItem.setId(1L);
        updatedToDoItem.setTitle("Updated Todo");
        updatedToDoItem.setDescription("This is an updated todo item");

        when(toDoItemService.updateToDoItem(1L, updatedToDoItem)).thenReturn(updatedToDoItem);

        ResponseEntity<ToDoItem> response = toDoItemController.updateToDoItem(1L, updatedToDoItem);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedToDoItem, response.getBody());
    }

    @Test
    void deleteToDoItem_ReturnsNoContentHttpStatus() {
        ResponseEntity<Void> response = toDoItemController.deleteToDoItem(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
