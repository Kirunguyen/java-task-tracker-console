/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.Task;

/**
 *
 * @author Kiru
 */
public class TaskService {

    private List<Task> tasks;

    public TaskService() {
        tasks = new ArrayList<>();
    }

    public void addTask(String title, LocalDateTime deadline) {
        Task task = new Task(title, deadline);
        tasks.add(task);

    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public boolean markCompleted(int id) {

        for (Task t : tasks) {
            if (t.getId() == id) {
                t.setCompleted(true);
                return true;
            }
        }

        return false;
    }

    public int deleteCompletedTasks() {
        int before = tasks.size();
        tasks.removeIf(Task::isCompleted);
        
        return before - tasks.size();
    }
}
