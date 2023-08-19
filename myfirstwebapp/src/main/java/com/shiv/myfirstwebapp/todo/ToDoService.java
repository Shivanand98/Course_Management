package com.shiv.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

//the below class provides the service class to this project in this class we are going to add the values to the database
//in this class we are going to perform the crud operations on the database 
//crud operations means creating table, adding the data to the database, updating the data in the database and deleting the data

@Service
public class ToDoService {
	
	private static List<Todo> todos=new ArrayList<>();
	
	private static int todosCount=0;
		
	static {
		todos.add(new Todo(++todosCount, "Shivanand", "AWS",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount, "Prakash", "Devops",LocalDate.now().plusYears(2),false));
		todos.add(new Todo(++todosCount, "Shiva", "Full Stack Development",LocalDate.now().plusYears(1),false));
	}

	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate=todo->todo.getUsername()==username;
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username,String description,LocalDate targetDate,boolean done) {
		Todo todo=new Todo(++todosCount,username,description,targetDate,done);
		todos.add(todo);
	}
	
	//in the below function we have written a lambda expression
	public void deleteById(int id) {
		//todo.getId()==id
		//todo->todo.getId()==id
		
		Predicate<? super Todo> predicate=todo->todo.getId()==id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate=todo-> todo.getId()==id;
	Todo todo=todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		
		deleteById(todo.getId());
		todos.add(todo);
		
	}
}