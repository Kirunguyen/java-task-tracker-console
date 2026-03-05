/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import model.Task;
import service.TaskService;
import view.TaskView;

/**
 *
 * @author Kiru
 */
public class TaskController {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private TaskService service;
    private TaskView view;
    private Scanner scanner;

    public TaskController() {
        service = new TaskService();
        view = new TaskView();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            view.showMenu();

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 ->
                    addTask();
                case 2 ->
                    viewTasks();
                case 3 ->
                    markCompleted();
                case 4 ->
                    deleteCompleted();
                case 5 -> {
                    System.out.println("Exiting program...");
                    return;
                }

                default ->
                    System.out.println("Invalid option");
            }

        }

    }

    private void addTask() {

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Deadline (yyyy-MM-dd HH:mm): ");
        String dateInput = scanner.nextLine();

        try {
            LocalDateTime deadline = LocalDateTime.parse(dateInput, formatter);
            service.addTask(title, deadline);
            System.out.println("Task added");
        } catch (Exception e) {
            System.out.println("Invalid date format");
        }

    }

    private void viewTasks() {
        List<Task> tasks = service.getAllTasks();

        if (tasks.isEmpty()) {
            System.out.println("No tasks available");
            return;
        }
        view.showTasks(tasks);
    }

    private void markCompleted() {
        System.out.print("Enter task ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean success = service.markCompleted(id);

        if (success) {
            System.out.println("Task marked completed");
        } else {
            System.out.println("Task not found");
        }
    }

    private void deleteCompleted() {
        int removed = service.deleteCompletedTasks();
        System.out.println(removed + " completed tasks removed");
    }

}
