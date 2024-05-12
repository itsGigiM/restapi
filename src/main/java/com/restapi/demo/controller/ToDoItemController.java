package com.restapi.demo.controller;

import com.restapi.demo.entity.ToDoItem;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ToDoItemController {
    public ResponseEntity<HttpStatus> createToDoItem(ToDoItem todoItem);

    public ResponseEntity<List<ToDoItem>> getAllToDoItems();

    public ResponseEntity<ToDoItem> getToDoItemById(Long id);
    public ResponseEntity<ToDoItem> updateToDoItem(Long id, ToDoItem updatedToDoItem);

    public ResponseEntity<Void> deleteToDoItem(Long id);
}
