package org.academiadecodigo.antonio.sokoban;


/**
 * Created by cadet on 28/09/15.
 */
public class Box extends GameObject implements Movable {
    private boolean stored;
    private int size;
    protected Game game;


    public Box(int col, int row, Game game) {
        this.game = game;
        this.size = Grid.cellSize;
        this.stored = false;
        id = ID.BOX;
        this.width = size;
        this.height = size;
        this.x = col * size;
        this.y = row * size;
        this.col = col;
        this.row = row;
        this.picture = newPicture(x, y, "resources/box2.png");

    }

    public int getLastCol() {
        return lastCol;
    }

    public int getLastRow() {
        return lastRow;
    }

    public boolean isStored() {
        return stored;
    }

    public void setStored(boolean stored) {
        this.stored = stored;
    }

    @Override
    public void move(Direction direction) {

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
         picture.translate(wayX * Grid.cellSize, wayY * Grid.cellSize);
         setPosition(getCol() + wayX, getRow() + wayY);
         game.getGrid().tile()[getRow()][getCol()].createBox();
         game.getGrid().tile()[getLastRow()][getLastCol()].removeObject();
         game.onPlace();
         game.levelStatus();
    }


     @Override
    public boolean canMove(Direction direction){

        if(checkSurroundings(direction) != 0 ){
            return false;
        }else {
            return true;
        }
    }
    @Override
    public int checkSurroundings(Direction direction) {
          int col = getCol();
        int row = getRow();
        switch (direction){
                case UP:
                    if(game.getGrid().isWall(col, row - 1))return -1;
                    if(game.getGrid().isBox(col, row - 1)) return 1;
                    break;
                case DOWN:
                    if(game.getGrid().isWall(col, row + 1))return -1;
                    if(game.getGrid().isBox(col, row + 1)) return 1;
                    break;
                case RIGHT:
                    if(game.getGrid().isWall(col + 1, row))return -1;
                    if(game.getGrid().isBox(col + 1, row)) return 1;
                    break;
                case LEFT:
                    if(game.getGrid().isWall(col - 1, row))return -1;
                    if(game.getGrid().isBox(col - 1, row)) return 1;
                    break;
        }
       return 0;
    }


}
