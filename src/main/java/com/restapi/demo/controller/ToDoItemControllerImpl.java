package com.restapi.demo.controller;

import com.restapi.demo.entity.ToDoItem;
import com.restapi.demo.service.ToDoItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@AllArgsConstructor
public class ToDoItemControllerImpl implements ToDoItemController{

    private ToDoItemService todoItemService;

    @PostMapping
    public ResponseEntity<HttpStatus> createToDoItem(@RequestBody ToDoItem todoItem) {
        todoItemService.createToDoItem(todoItem);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ToDoItem>> getAllToDoItems() {
        List<ToDoItem> list = todoItemService.getAllToDoItems();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoItem> getToDoItemById(@PathVariable Long id) {
        return new ResponseEntity<>(todoItemService.getToDoItemById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoItem> updateToDoItem(@PathVariable Long id, @RequestBody ToDoItem updatedToDoItem) {
        return new ResponseEntity<>(todoItemService.updateToDoItem(id, updatedToDoItem), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDoItem(@PathVariable Long id) {
        todoItemService.deleteToDoItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
