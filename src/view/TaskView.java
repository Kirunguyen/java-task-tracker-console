/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.time.format.DateTimeFormatter;
import java.util.List;
import model.Task;

/**
 *
 * @author Kiru
 */
public class TaskView {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public void showMenu() {
        System.out.println("\n===== TASK TRACKER =====");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task Completed");
        System.out.println("4. Delete Completed Tasks");
        System.out.println("5. Exit");
        System.out.print("Choose: ");
    }

    public void showTasks(List<Task> tasks) {

        System.out.println("\n-----------------------------------------------------------");
        System.out.printf("%-4s %-20s %-18s %-10s\n",
                "ID", "Title", "Deadline", "Status");
        System.out.println("-----------------------------------------------------------");

        for (Task t : tasks) {

            String status = t.isCompleted() ? "Done" : "Pending";

            System.out.printf("%-4d %-20s %-18s %-10s\n",
                    t.getId(),
                    t.getTitle(),
                    t.getDeadline().format(formatter),
                    status
            );
        }

        System.out.println("-----------------------------------------------------------");
    }

}
