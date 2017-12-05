package automata.task.services;

import automata.task.AbstractTask;
import java.io.IOException;

public class TaskService {

    private AbstractTask task;

    public TaskService(AbstractTask task) {
        this.task = task;
    }

    public void start() {
        try {
            System.out.println("Task " + task.getClass().getName().toLowerCase());
            task.execute();
        } catch (IOException exception) {
            System.err.println("Task failed with io exception: " + exception.getMessage());
        }
    }
}
