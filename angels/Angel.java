package angels;

import patterns.Visitor;

public abstract class Angel implements  Visitor {
    private int line;
    private int col;
    private int roundNr;
    private String fullType;
    private boolean isGood;

    public Angel(final int l, final int c) {
        line = l;
        col =  c;
    }

    /**
     *
     * @return
     */

    public int getLine() {
        return line;
    }

    /**
     *
     * @param line
     */

    public void setLine(final int line) {
        this.line = line;
    }

    /**
     *
     * @return
     */

    public int getCol() {
        return col;
    }

    /**
     *
     * @param col
     */

    public void setCol(final int col) {
        this.col = col;
    }

    /**
     *
     * @return
     */

    public int getRoundNr() {
        return roundNr;
    }

    /**
     *
     * @param roundNr
     */

    public void setRoundNr(final int roundNr) {
        this.roundNr = roundNr;
    }

    /**
     *
     * @return
     */

    public String getFullType() {
        return fullType;
    }

    /**
     *
     * @param fullType
     */

    public void setFullType(final String fullType) {
        this.fullType = fullType;
    }

    /**
     *
     * @return
     */

    public boolean isGood() {
        return isGood;
    }

    /**
     *
     * @param good
     */

    public void setGood(final boolean good) {
        isGood = good;
    }
}
