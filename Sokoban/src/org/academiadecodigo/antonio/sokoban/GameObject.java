package org.academiadecodigo.antonio.sokoban;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by cadet on 28/09/15.
 */
public class GameObject {


    protected ID id;
    protected int width;
    protected int height;
    protected int col;
    protected int row;
    protected int x;
    protected int y;
    protected int lastCol;
    protected int lastRow;
    protected int movementUnit;
    public Picture picture;



    public GameObject(){

    }
/*
    public void move(Direction direction){

        switch (direction){
            case UP:
                updatePosition(0, -1);

                break;
            case DOWN:
                updatePosition(0, 1);

                break;
            case LEFT:
                updatePosition(-1, 0);
                break;
            case RIGHT:
                updatePosition(1, 0);
                break;
        }

        System.out.println("Col: " + getLastCol() + " Row: " + getLastRow());
    }

    public  void updatePosition(int wayX, int wayY){
        int col = getCol();
        int row = getRow();
        setLastPosition(col, row);
        System.out.println("moving");
        picture.translate(movementUnit * wayX, movementUnit * wayY);
        setPosition(getCol() + wayX,getRow() + wayY);
    }*/


    public Picture newPicture(int x, int y, String path){

        String picturePath = path;
        Picture picture = new Picture(x, y, picturePath);
        picture.draw();


        return picture;
    }

    public void setPosition(int col, int row){
        this.col = col;
        this.row = row;
    }


    public void setLastPosition(int col, int row){
        this.lastCol = col;
        this.lastRow = row;
    }

    public int getCol() {
        return this.col;
    }

    public int getRow() {
        return this.row;
    }




    public int getLastRow() {
        return lastRow;
    }



    public int getLastCol() {
        return lastCol;
    }



    public ID getId() {
        return id;
    }
}