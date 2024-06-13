import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class JUnitQuiz {
    String name1 = "홍길동";
    String name2 = "홍길동";
    String name3 = "홍길은";
    @Test
    public void quiz1() {

        assertThat(name1).isEqualTo(name2);
    }
}
