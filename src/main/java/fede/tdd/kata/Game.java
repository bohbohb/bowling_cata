package fede.tdd.kata;

public class Game {

    private static final int MAX_PINS = 10;
    private static final int MIN_PINS = 0;
    private int _score;

    public Game() {
        _score = 0;
    }

    public void roll(int i) {
        int validScore = getValidScore(i);
        _score += validScore;
    }


    public int score() {
        return _score;
    }

    private int getValidScore(int i) {
        return Math.max(Math.min(MAX_PINS, i), MIN_PINS);
    }
}
