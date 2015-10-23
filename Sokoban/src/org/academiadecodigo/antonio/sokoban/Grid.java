package org.academiadecodigo.antonio.sokoban;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by cadet on 13/10/15.
 */
public class Grid {
    protected ArrayList<Storage> storagePoints;
    protected ArrayList<Wall> walls;
    protected Tile[][] tiles;
    protected static int cellSize = 50;
    protected int cols;
    protected int rows;
    protected InputStreamReader fileReader;

    public Grid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;

        createGrid(cols, rows);
        try {
            createLevel();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void createGrid(int col, int row){
        tiles = new Tile[row][col];

        for(int i = 0; i < row; i++){
            tiles[i] = new Tile[col];
            for(int j = 0; j < col; j++){
                tiles[i][j] = new Tile(j * cellSize, i * cellSize, cellSize);
            }
        }

    }
    public void createLevel() throws IOException {
        storagePoints = new ArrayList<>();
        walls = new ArrayList<>();
         try {
                // Attempt to load from the class path (as in JAR file..)
                URL url = getClass().getResource(Game.mapSource().startsWith("/") ? Game.mapSource() : "/" + Game.mapSource());

                if (url != null) {
                    fileReader = new InputStreamReader(url.openStream());
                } else {

                    // Load from file
                    fileReader = new FileReader(Game.mapSource());
                }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for(int i = 0; i < rows; i++){

            for(int j = 0; j < cols; j++){
                int character = fileReader.read();
                if(character == '#'){
                    tiles[i][j].createWall();
                    walls.add(new Wall(j, i, cellSize));
                } else if(character == 'p' || character == '$'){
                    tiles[i][j].createStoragePoint();
                    storagePoints.add(new Storage(j, i, cellSize));
                } else  {
                    tiles[i][j].createEmptySpace();
                }
            }
        }

    }

public void deleteLevel() throws IOException {
        int storageIndex = 0;
        int wallIndex = 0;

        while(wallIndex < walls.size()){
            walls.get(wallIndex++).picture.delete();
        }

     while(storageIndex < storagePoints.size()){
            storagePoints.get(storageIndex++).picture.delete();
        }
        for(int i = 0; i < rows; i++){

            for(int j = 0; j < cols; j++){
                if(tiles[i][j].isBox() || tiles[i][j].isWall() || tiles[i][j].isStoragePoint()){
                    tiles[i][j].removeObject();
                }
            }
        }

    }
    public boolean isWall(int col, int row){
        return tiles[row][col].isWall();
    }

    public boolean isBox(int col, int row){
        return tiles[row][col].isBox();
    }

    public Tile[][] tile() {
        return tiles;
    }
}
