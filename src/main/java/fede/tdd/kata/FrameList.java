package fede.tdd.kata;

import java.util.ArrayList;
import java.util.List;

public class FrameList {

    private static final int NUMBER_OF_FRAMES = 10;
    private final List<Frame> _frames = new ArrayList<>();
    private int _currentFrameIndex = 0;

    public FrameList() {
        int i = 0;
        while (i < NUMBER_OF_FRAMES) {
            _frames.add(new Frame());
            i++;
        }
    }

    public void roll(int i) {
        Frame currentFrame = getCurrentFrame();
        if (currentFrame == null) {
            return;
        }
        currentFrame.roll(i);
    }

    public int getScore() {
        int score = 0;
        int frameSize = _frames.size();
        Frame frame;
        for (int index = 0; index < frameSize; index++) {
            frame = _frames.get(index);
            score = getBonusScore(score, frame, index);
            score += frame.getScore();
        }
        return score;
    }

    private int getBonusScore(int score, Frame frame, int index) {
        if(index + 1 < _frames.size()) {
            if (frame.isSpare()) {
                score += _frames.get(index + 1).getSpareBonus();
            }
            if (frame.isStrike()) {
                score += _frames.get(index + 1).getStrikeBonus();
            }
        }
        return score;
    }

    private Frame getCurrentFrame() {
        if (_currentFrameIndex > 9 || _frames.get(_currentFrameIndex) == null) {
            return null;
        }
        Frame currentFrame = _frames.get(_currentFrameIndex);
        if (currentFrame.isFull()) {
            _currentFrameIndex++;
            return getCurrentFrame();
        }
        return currentFrame;
    }
}
