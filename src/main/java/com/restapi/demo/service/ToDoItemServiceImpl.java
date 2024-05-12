package com.restapi.demo.service;

import com.restapi.demo.entity.ToDoItem;
import com.restapi.demo.repository.ToDoItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoItemServiceImpl implements ToDoItemService {

    @Autowired
    private ToDoItemRepository todoItemRepository;

    @Override
    public ToDoItem createToDoItem(ToDoItem todoItem) {
        return todoItemRepository.save(todoItem);
    }

    @Override
    public List<ToDoItem> getAllToDoItems() {
        return (List<ToDoItem>) todoItemRepository.findAll();
    }

    @Override
    public ToDoItem getToDoItemById(Long id) {
        return todoItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ToDoItem not found with id: " + id));
    }

    @Override
    public ToDoItem updateToDoItem(Long id, ToDoItem updatedToDoItem) {
        ToDoItem existingToDoItem = getToDoItemById(id);
        existingToDoItem.setTitle(updatedToDoItem.getTitle());
        existingToDoItem.setDescription(updatedToDoItem.getDescription());
        return todoItemRepository.save(existingToDoItem);
    }

    @Override
    public void deleteToDoItem(Long id) {
        todoItemRepository.deleteById(id);
    }


}
