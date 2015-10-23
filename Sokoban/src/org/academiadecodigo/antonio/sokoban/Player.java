package org.academiadecodigo.antonio.sokoban;



/**
 * Created by cadet on 28/09/15.
 */
public class Player extends GameObject implements Movable {



    private Direction direction;
    boolean frame;
    String framePath;
    String sprite = "facing";
    private int size;
    protected Game game;




    public Player(int col, int row, Game game){
        this.game = game;
        this.size = Grid.cellSize;
        id = ID.PLAYER;
        this.width = size;
        this.height = size;
        this.x = col * size;
        this.y = row * size;
        this.col = col;
        this.row = row;
        this.picture = newPicture(x, y, "resources/" + chooseChar() + "bot1.png");
    }



    public String chooseChar(){

        String path = sprite;

        return path;
    }

    public int getLastCol() {
        return lastCol;
    }

    public void setLastCol(int lastCol) {
        this.lastCol = lastCol;
    }

    public int getLastRow() {
        return lastRow;
    }

    public void setLastRow(int lastRow) {
        this.lastRow = lastRow;
    }

    public void setPosition(int col, int row){
        this.col = col;
        this.row = row;
    }


    public String changeFrame(String framePath1, String framePath2){
        if(frame){
            framePath = framePath1;
            frame = !frame;
        } else{
            framePath = framePath2;
            frame = !frame;
        }
        return framePath;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
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
        picture.translate(Grid.cellSize * wayX, Grid.cellSize * wayY);
        setPosition(getCol() + wayX, getRow() + wayY);
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

    @Override
    public boolean canMove(Direction direction){

        if(checkSurroundings(direction) < 0 ){
            return false;
        }else if(checkSurroundings(direction) == 0){
            return true;
        } else {
            return getBox(direction).canMove(direction);
        }
    }

    public Box getBox(Direction direction){
       Box boxToReturn = null;
        for(Box box : game.getBoxes()){

            int boxCol = box.getCol();
            int boxRow = box.getRow();

            switch (direction){
                case UP:
                    if(boxCol == getCol() && boxRow == getRow() - 1)
                         boxToReturn = box;
                    break;
                case DOWN:
                    if(boxCol == getCol() && boxRow == getRow() + 1)
                        boxToReturn = box;
                    break;
                case RIGHT:
                    if(boxCol == getCol() + 1 && boxRow == getRow())
                        boxToReturn = box;
                    break;
                case LEFT:
                    if(boxCol == getCol() - 1 && boxRow == getRow())
                        boxToReturn = box;
                    break;
            }
        }
        return boxToReturn;
    }
}
