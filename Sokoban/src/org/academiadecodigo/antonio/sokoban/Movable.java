package org.academiadecodigo.antonio.sokoban;

/**
 * Created by cadet on 13/10/15.
 */
public interface Movable {

    void move(Direction direction);
    int checkSurroundings(Direction direction);
    boolean canMove(Direction direction);
}
