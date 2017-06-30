package pl.javaacademy.tictactoe;

import pl.javaacademy.tictactoe.common.Marks;

import java.util.ArrayList;
import java.util.Arrays;

class PlayerSelector {

    private Marks startingPlayerMark;
    private Marks secondPlayerMark;

    PlayerSelector(Marks startingPlayerMark) {
        this.startingPlayerMark = startingPlayerMark;
        this.secondPlayerMark = getSecondPlayerMark();
    }

    Marks getPlayerForMove(int moveId) {
        return moveId % 2 == 0 ? secondPlayerMark : startingPlayerMark;
    }

    private Marks getSecondPlayerMark() {

        ArrayList<Marks> allMarks = new ArrayList<>(Arrays.asList(Marks.values()));
        allMarks.remove(startingPlayerMark);
        allMarks.remove(Marks.EMPTY);
        return allMarks.get(0);
    }
}
