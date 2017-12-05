package automata.task;

import automata.Automata;
import automata.exception.AutomataException;
import automata.scanner.Reader;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SecondTask implements AbstractTask {

    @Override
    public void execute() throws IOException {
        Automata automata = Reader.read("json/input.json");

        findAllWords(automata, "5zxc-5.c+.123ooo1e.E3.3.")
                .forEach(System.out::println);
        System.out.println();
//        findAllWords(automata, "1.2345E02").forEach(System.out::println);
        System.out.println();
    }

    private Pair<Boolean, Integer> getWordResult(Automata automata, String alphabet, Integer position) {
        MutablePair<Boolean, Integer> pair = new MutablePair<>(false, 0);

        Integer currentSession = 0;
        automata.initAutomata();

        try {
            for (int index = position; index < alphabet.length(); index++) {
                automata.process(alphabet.charAt(index));

                pair.setLeft(automata.isFinalState() || pair.getLeft());

                ++currentSession;
                if (automata.isFinalState()) {
                    pair.setRight(Integer.max(currentSession, pair.getRight()));
                }
            }
        } catch (AutomataException exception) {
            // sin
        }

        return pair;
    }

    private List<String> findAllWords(Automata automata, String line) {
        List<String> words = new ArrayList<>();

        for (int index = 0; index < line.length(); ) {
            int currentIndex = getWordResult(automata, line, index).getValue();
            if (currentIndex == 0) {
                index++;
            } else {
                words.add(line.substring(index, index + currentIndex));
                index += currentIndex;
            }
        }

        return words;
    }
}