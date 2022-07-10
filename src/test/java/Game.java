import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GameTest {
    @Test

    public void onePin(){
        Game game = new Game();

        game.roll(2);

        assertThat(game.score(), is(2));
    }

}
