package org.academiadecodigo.antonio.sokoban;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by Ant�nio on 10-10-2015.
 */
public class Tile {
    private boolean wall = false;
    private boolean box = false;
    private boolean storagePoint = false;
    private Rectangle rectangle;

    public Tile(int originX, int originY, int size){
        this.rectangle = new Rectangle(originX, originY, size, size);
        rectangle.setColor(Color.WHITE);
        rectangle.draw();
    }

    public void createWall(){
        this.wall = true;
    }

    public void createBox(){
        this.box = true;

    }

    public void createStoragePoint(){
        this.storagePoint = true;

    }

    public void createEmptySpace(){
        rectangle.setColor(Color.WHITE);
        rectangle.fill();
        this.storagePoint = true;

    }

    public void removeObject(){
        rectangle.delete();
        this.wall = false;
        this.box = false;
        this.storagePoint = false;
    }

    public boolean isWall() {
        return wall;
    }



    public boolean isBox() {
        return box;
    }

    public boolean isStoragePoint() {
        return storagePoint;
    }
}
