package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputManager {

    public List<String> inputCarNames() {
        final String names = Console.readLine();
        final List<String> nameList = Arrays
                .stream(names.split(","))
                .toList();
        validateNames(nameList);
        return nameList;
    }

    public int inputNumberOfAttempt() {
        final int numberOfAttempt = Integer.parseInt(Console.readLine());
        validateNumberOfAttempt(numberOfAttempt);
        return numberOfAttempt;
    }

    private void validateNumberOfAttempt(int numberOfAttempt) {
        if (numberOfAttempt <= 0)
            throw new IllegalArgumentException();
    }

    private void validateNames(List<String> nameList) {
        for (String name : nameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
