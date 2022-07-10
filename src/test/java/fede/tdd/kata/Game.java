package fede.tdd.kata;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GameTest {

    @Test
    void twoPinRoll() {
        Game game = new Game();

        game.roll(2);

        assertThat(game.score(), is(2));
    }

    @Test
    void elevenPinRoll() {
        Game game = new Game();

        game.roll(11);

        assertThat(game.score(), is(10));
    }

    @Test
    void negativePinRoll() {
        Game game = new Game();

        game.roll(-1);

        assertThat(game.score(), is(0));
    }

    @Test
    void summedPinRoll() {
        Game game = new Game();
        game.roll(1);

        game.roll(4);

        assertThat(game.score(), is(5));
    }

    @Test
    void summedGreaterThan10PinRollInAFrame() {
        Game game = new Game();
        game.roll(4);

        game.roll(8);

        assertThat(game.score(), is(10));
    }

    @Test
    void sumFrameAndRoll() {
        Game game = new Game();
        game.roll(1);
        game.roll(4);

        game.roll(4);

        assertThat(game.score(), is(9));
    }

    @Test
    void sumTwoFrames() {
        Game game = new Game();
        game.roll(1);
        game.roll(4);
        game.roll(4);

        game.roll(5);

        assertThat(game.score(), is(14));
    }

    @Test
    void lastFrameSpare() {
        Game game = new Game();
        game.roll(1);
        game.roll(4);
        game.roll(5);

        game.roll(5);

        assertThat(game.score(), is(15));
    }

    @Test
    void computeBonusPointsSpare(){
        Game game = new Game();
        game.roll(1);
        game.roll(4);
        game.roll(4);
        game.roll(6);

        game.roll(5);

        assertThat(game.score(), is(25));
    }
}
