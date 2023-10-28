package racingcar.input;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputManagerTest {
    private final InputStream systemIn = System.in;
    private InputManager manager;

    @BeforeEach
    public void each() {
        manager = new InputManager();
    }

    @AfterEach
    public void after() {
        Console.close();
    }

    @Test
    @DisplayName("이름 정상 입력시 리스트 반환")
    void 이름_정상_입력() {
        provideInput("pobi,woni,jun");
        assertThat(manager.inputNames())
                .isEqualTo(List.of("pobi", "woni", "jun"));
    }

    @Test
    @DisplayName("이름길이 초과시 예외발생")
    void 이름길이_초과시_예외발생() {
        provideInput("pobi,wonidd,jun");
        Assertions.assertThatThrownBy(() -> manager.inputNames())
                .isInstanceOf(IllegalArgumentException.class);
    }

    void provideInput(String str) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(str.getBytes());
        System.setIn(testIn);
    }
}