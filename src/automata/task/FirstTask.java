package automata.task;

import automata.Automata;
import automata.scanner.Reader;

import java.io.IOException;

public class FirstTask implements AbstractTask {

    @Override
    public void execute() throws IOException {
        Automata automata = Reader.read("json/input.json");

        String alphabet = "5";

        String template = "Automata has finished with %sfinal state for " + alphabet + "\n";
        Boolean finished = performWholeString(automata, alphabet);
        System.out.println(String.format(template, finished ? "" : "no "));
    }

    private boolean performWholeString(Automata automata, String alphabet) {
        try {
            automata.initAutomata();
            for (int index = 0; index < alphabet.length(); index++) {
                automata.process(alphabet.charAt(index));
            }
            return automata.isFinalState();
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
            return false;
        }
    }
}
