import fede.tdd.kata.Game;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GameTest {
    @Test
    public void twoPinRoll(){
        Game game = new Game();

        game.roll(2);

        assertThat(game.score(), is(2));
    }
    @Test
    public void elevenPinRoll(){
        Game game = new Game();

        game.roll(11);

        assertThat(game.score(), is(10));
    }

    @Test
    public void negativePinRoll(){
        Game game = new Game();

        game.roll(-1);

        assertThat(game.score(), is(0));
    }

    @Test
    public void summedPinRoll(){
        Game game = new Game();
        game.roll(1);

        game.roll(4);

        assertThat(game.score(), is(5));
    }


}
