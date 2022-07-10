package fede.tdd.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public int getScore() {
//        return _frames.stream().collect(Collectors.summingInt(Frame::getScore));
        int score = 0;
        int frameSize = _frames.size();
        Frame frame;
        for (int index = 0; index < frameSize; index++) {
            frame = _frames.get(index);
            if(frame.isSpare() && index + 1 < frameSize) {
                score += _frames.get(index+1).getSpareBonus();
            }
            score += frame.getScore();
        }
        return score;
    }
}
