package automata.scanner.reader;

import java.util.Map;
import java.util.Set;

public class JsonInput {

    private Set<String> alphabet;

    private Set<String> initialState;

    private Set<String> finalState;

    private Map<String, Map<String, Set<String>>> matrixOfTransitions;


    public Set<String> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(Set<String> alphabet) {
        this.alphabet = alphabet;
    }

    public Set<String> getInitialState() {
        return initialState;
    }

    public void setInitialState(Set<String> initialState) {
        this.initialState = initialState;
    }

    public Set<String> getFinalState() {
        return finalState;
    }

    public void setFinalState(Set<String> finalState) {
        this.finalState = finalState;
    }

    public Map<String, Map<String, Set<String>>> getMatrixOfTransitions() {
        return matrixOfTransitions;
    }

    public void setMatrixOfTransitions(Map<String, Map<String, Set<String>>> matrixOfTransitions) {
        this.matrixOfTransitions = matrixOfTransitions;
    }
}