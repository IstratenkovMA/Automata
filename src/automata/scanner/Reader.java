package automata.scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import automata.Automata;
import automata.scanner.reader.JsonInput;

import java.io.File;
import java.io.IOException;

public class Reader {

    public static Automata read(String fileName) throws IOException {
        JsonInput inputEntity =
                new ObjectMapper().readValue(new File(fileName), JsonInput.class);

        Automata automata = new Automata();
        automata.setAlphabet(inputEntity.getAlphabet());
        automata.setInitialState(inputEntity.getInitialState());
        automata.setFinalState(inputEntity.getFinalState());
        automata.setMatrixOfTransitions(inputEntity.getMatrixOfTransitions());
        return automata;
//        return Automata.createBuilder()
//                .setName(inputEntity.getName())
//                .setPriority(inputEntity.getPriority())
//                .setAlphabet(inputEntity.getAlphabet())
//                .setInitialState(inputEntity.getInitialState())
//                .setFinalState(inputEntity.getFinalState())
//                .setMatrixOfTransitions(inputEntity.getMatrixOfTransitions())
//                .build();
    }
}
