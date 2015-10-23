package org.academiadecodigo.antonio.sokoban;

import org.academiadecodigo.simplegraphics.graphics.Color;

/**
 * Created by cadet on 29/09/15.
 */
public class Wall extends GameObject {

    public Wall(int col, int row, int cell) {
        id = ID.WALL;
        this.width = cell;
        this.height = cell;
        this.x = col * cell;
        this.y = row * cell;
        this.col = col;
        this.row = row;
        this.picture = newPicture(x, y, "resources/brickgrey.png");
    }
}
