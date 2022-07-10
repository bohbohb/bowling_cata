package fede.tdd.kata;


public class Game {
    private final FrameList _frameList;

    public Game() {
        _frameList = new FrameList();
    }

    public void roll(int i) {
        _frameList.roll(i);
    }

    public int score() {
        return _frameList.getScore();
    }
}
