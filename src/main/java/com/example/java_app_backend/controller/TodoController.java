package com.example.java_app_backend.controller;

import com.example.java_app_backend.model.Todo;
import com.example.java_app_backend.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @QueryMapping
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }

    @MutationMapping
    public Todo createTodo(@Argument String title) {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setCompleted(false);
        return todoService.createTodo(todo);
    }

    @MutationMapping
    public Todo updateTodo(@Argument Long id, @Argument String title, @Argument Boolean completed) {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setCompleted(completed);
        return todoService.updateTodo(id, todo);
    }

    @MutationMapping
    public boolean deleteTodo(@Argument Long id) {
        todoService.deleteTodo(id);
        return true;
    }
}
