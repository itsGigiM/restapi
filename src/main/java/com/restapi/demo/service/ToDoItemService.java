package com.restapi.demo.service;

import com.restapi.demo.entity.ToDoItem;

import java.util.List;

public interface ToDoItemService {
    ToDoItem createToDoItem(ToDoItem todoItem);

    List<ToDoItem> getAllToDoItems();

    ToDoItem getToDoItemById(Long id);

    ToDoItem updateToDoItem(Long id, ToDoItem updatedToDoItem);

    void deleteToDoItem(Long id);
}
