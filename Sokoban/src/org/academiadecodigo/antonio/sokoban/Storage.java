package org.academiadecodigo.antonio.sokoban;


/**
 * Created by cadet on 30/09/15.
 */
public class Storage extends GameObject {

    public Storage(int col, int row, int cell) {
        this.width = cell;
        this.height = cell;
        this.x = col * cell;
        this.y = row * cell;
        this.col = col;
        this.row = row;
        this.picture = newPicture(x, y, "resources/storage.png");
    }
}
