package automata;

import com.google.common.collect.Sets;
import automata.exception.AutomataException;

import java.util.*;
import java.util.stream.Collectors;

public final class Automata {

    private String name;

    private Integer priority;

    private Set<String> alphabet;

    private Set<String> initialState;

    private Set<String> finalState;

    private Map<String, Map<String, Set<String>>> matrixOfTransitions;

    private Set<String> currentState;

    public void initAutomata() {
        currentState = new HashSet<>(initialState);
    }

    public void refreshAutomata() {
        initAutomata();
    }

    public void process(Character symbol) {
        Set<String> updateCurrentState = new HashSet<>();
        String key = String.valueOf(symbol);

        boolean valid = currentState.stream()
                .anyMatch(state -> isValidState(state) && isValidKey(state, key));
        if (!valid) {
            throw new AutomataException("No transitions for current state and sent key");
        }

        updateCurrentState.addAll(currentState.stream()
                .map(state -> {
                    if (matrixOfTransitions.get(state) == null || matrixOfTransitions.get(state).get(key) == null) {
                        return Sets.<String>newHashSet();
                    }
                    return matrixOfTransitions.get(state).get(key);
                })
                .flatMap(Set::stream)
                .collect(Collectors.toList()));

        currentState = updateCurrentState;
    }

    private boolean isValidState(String state) {
        return matrixOfTransitions.containsKey(state);
    }

    private boolean isValidKey(String state, String key) {
        return isValidState(state) && matrixOfTransitions.get(state).containsKey(key);
    }

    public boolean isFinalState() {
        return currentState != null && !finalState.stream()
                .filter(currentState::contains)
                .collect(Collectors.toList())
                .isEmpty();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setAlphabet(Set<String> alphabet) {
        this.alphabet = alphabet;
    }

    public void setInitialState(Set<String> initialState) {
        this.initialState = initialState;
    }

    public void setFinalState(Set<String> finalState) {
        this.finalState = finalState;
    }

    public void setMatrixOfTransitions(Map<String, Map<String, Set<String>>> matrixOfTransitions) {
        this.matrixOfTransitions = matrixOfTransitions;
    }

    public Set<String> getCurrentState() {
        return currentState;
    }

    public void setCurrentState(Set<String> currentState) {
        this.currentState = currentState;
    }

    public String getName() {
        return name;
    }

    public Integer getPriority() {
        return priority;
    }

    public Set<String> getAlphabet() {
        return alphabet;
    }

    public Set<String> getInitialState() {
        return initialState;
    }

    public Set<String> getFinalState() {
        return finalState;
    }

    public Map<String, Map<String, Set<String>>> getMatrixOfTransitions() {
        return matrixOfTransitions;
    }
}