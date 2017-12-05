package automata;

import automata.task.FirstTask;
import automata.task.SecondTask;
import automata.task.services.TaskService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        new TaskService(new FirstTask()).start();

        new TaskService(new SecondTask()).start();
    }
}
