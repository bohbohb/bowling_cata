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

        rollsArray(game, new int[] {1, 4});


        assertThat(game.score(), is(5));
    }

    @Test
    void summedGreaterThan10PinRollInAFrame() {
        Game game = new Game();

        rollsArray(game, new int[] {4, 8});


        assertThat(game.score(), is(10));
    }

    @Test
    void sumFrameAndRoll() {
        Game game = new Game();

        rollsArray(game, new int[] {1, 4, 4});


        assertThat(game.score(), is(9));
    }

    @Test
    void sumTwoFrames() {
        Game game = new Game();

        rollsArray(game, new int[] {1, 4, 4, 5});


        assertThat(game.score(), is(14));
    }

    @Test
    void lastFrameSpare() {
        Game game = new Game();

        rollsArray(game, new int[] {1, 4, 5, 5});

        assertThat(game.score(), is(15));
    }

    @Test
    void computeBonusPointsSpare(){
        Game game = new Game();

        rollsArray(game, new int[] {1, 4, 4, 6, 5});

        assertThat(game.score(), is(25));
    }

    @Test
    void lastFrameStrike() {
        Game game = new Game();

        rollsArray(game, new int[] {1, 4, 10});

        assertThat(game.score(), is(15));
    }

    @Test
    void computeBonusPointsStrikePartialFrame(){
        Game game = new Game();

        rollsArray(game, new int[] {1, 4, 10, 2});

        assertThat(game.score(), is(19));
    }

    @Test
    void computeBonusPointsStrike(){
        Game game = new Game();

        rollsArray(game, new int[] {1, 4, 10, 2, 4});

        assertThat(game.score(), is(27));
    }


    @Test
    void doubleSpareBonuses(){
        Game game = new Game();

        rollsArray(game, new int[] {1, 9, 2, 8, 5, 1});

        assertThat(game.score(), is(33));
    }

    @Test
    void doubleSparePlusStrikeBonuses(){
        Game game = new Game();

        rollsArray(game, new int[] {1, 9, 2, 8, 10, 0, 1});

        assertThat(game.score(), is(44));
    }

    private void rollsArray(Game game, int[] rolls) {
        for (int pins: rolls) {
            game.roll(pins);
        }
    }
}
