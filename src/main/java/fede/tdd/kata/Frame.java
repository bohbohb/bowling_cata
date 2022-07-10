package fede.tdd.kata;

public class Frame {

    private static final int MIN_PINS_PER_ROLL = 0;
    private static final int MAX_PINS_PER_ROLL = 10;

    private int maxPins = MAX_PINS_PER_ROLL;

    private Integer _firstRoll = null;
    private Integer _secondRoll = null;
    private int _score = 0;

    private boolean _isFull = false;
    private boolean _isStrike = false;
    private boolean _isSpare = false;


    public void roll(int i) {
        if (_firstRoll == null) {
            _firstRoll = getValidScore(i);
            _score += _firstRoll;
            setMaxPinsForNextRoll();
            if (_firstRoll == 10) {
                _isStrike = true;
                _isFull = true;
            }
        } else if (_secondRoll == null) {
            _secondRoll = getValidScore(i);
            _score += _secondRoll;
            if (getScore() == 10) {
                _isSpare = true;
            }
            _isFull = true;
        }
    }

    public int getScore() {
        return _score;
    }

    /**
     * to use from outside before rolling to check if the frame can be used or not.
     * @return
     */
    public boolean isFull() {
        return _isFull;
    }

    public boolean isSpare() {
        return _isSpare;
    }

    public boolean isStrike() {
        return _isStrike;
    }

    private void setMaxPinsForNextRoll() {
        maxPins = maxPins - _firstRoll;
    }

    private int getValidScore(int i) {
        return Math.max(Math.min(maxPins, i), MIN_PINS_PER_ROLL);
    }

    public int getSpareBonus() {
        return _firstRoll == null ? 0 : _firstRoll;
    }

    public int getStrikeBonus() {
        return getScore();
    }
}
