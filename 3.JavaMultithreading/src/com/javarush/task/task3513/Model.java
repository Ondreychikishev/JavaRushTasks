


import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private boolean isSaveNeeded = true;

    Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    protected int score;
    protected int maxTile;

    private Stack<Tile[][]> previousStates;
    private Stack<Integer> previousScores;

    public Model() {
        resetGameTiles();
        score = 0;
        maxTile = 2;
        this.previousScores = new Stack<Integer>();
        this.previousStates = new Stack<>();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    private void addTile() {
        List<Tile> list = getEmptyTiles();
        if(list.isEmpty()) return;
        int index = (int)(list.size() * Math.random());
        int value = (int) (Math.random() < 0.9 ? 2 : 4);
        list.get(index).value = value;
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> list = new ArrayList<>();
        for(int i = 0; i < gameTiles.length; i++){
            for(int j = 0; j < gameTiles.length; j++){
                if(gameTiles[i][j].isEmpty()){
                    list.add(gameTiles[i][j]);
                }
            }
        }
        return list;
    }

    protected void resetGameTiles() {
        for (int i = 0; i < this.gameTiles.length; i++) {
            for (int j=0;j < this.gameTiles.length; j++) {
                this.gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private boolean compressTiles(Tile[] tiles){
        boolean change = false;
        for(int i = 0; i < tiles.length-1; i++){
            for(int j = 0; j < tiles.length-1; j++){
                if(tiles[j].isEmpty() && !tiles[j+1].isEmpty()){
                    change = true;
                    tiles[j] = tiles[j+1];
                    tiles[j+1] = new Tile();
                }
            }
        }
        return change;
    }

    private boolean mergeTiles(Tile [] tiles){
        boolean ch = false;
        for(int i = 0; i < tiles.length-1; i++){
            if(tiles[i].value == tiles[i+1].value && !tiles[i].isEmpty() && !tiles[i+1].isEmpty()){
                ch = true;
                tiles[i].value *= 2;
                tiles[i+1] = new Tile();
                maxTile = maxTile > tiles[i].value ? maxTile : tiles[i].value;
                score += tiles[i].value;
                compressTiles(tiles);
            }
        }
        return ch;
    }

    public void rotateToRight() {
        for (int i = 0; i < FIELD_WIDTH / 2; i++) {
            for (int j = i; j < FIELD_WIDTH - 1 - i; j++) {
                Tile temp = gameTiles[i][j];
                gameTiles[i][j] = gameTiles[FIELD_WIDTH - 1 - j][i];
                gameTiles[FIELD_WIDTH - 1 - j][i] = gameTiles[FIELD_WIDTH - 1 - i][FIELD_WIDTH - 1 - j];
                gameTiles[FIELD_WIDTH - 1 - i][FIELD_WIDTH - 1 - j] = gameTiles[j][FIELD_WIDTH - 1 - i];
                gameTiles[j][FIELD_WIDTH - 1 - i] = temp;
            }
        }
    }

    void left() {
        if (isSaveNeeded){saveState(gameTiles);}
        boolean isChange = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                isChange = true;
            }
        }
        isSaveNeeded = true;
        if (isChange) addTile();
    }
    void right() {
        saveState(gameTiles);
        rotateToRight();
        rotateToRight();
        left();
        rotateToRight();
        rotateToRight();
    }
    void up() {
        saveState(gameTiles);
        rotateToRight();
        rotateToRight();
        rotateToRight();
        left();
        rotateToRight();
    }
    void down() {
        saveState(gameTiles);
        rotateToRight();
        left();
        rotateToRight();
        rotateToRight();
        rotateToRight();
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty())
            return true;
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j - 1].value)
                    return true;
            }
        }
        for (int j = 0; j < gameTiles.length; j++) {
            for (int i = 1; i < gameTiles.length; i++) {
                if (gameTiles[i][j].value == gameTiles[i - 1][j].value)
                    return true;
            }
        }
        return false;
    }
    private void saveState(Tile[][] tile) {
        Tile[][] newGameTiles = new Tile[tile.length][tile[0].length];
        for (int i = 0; i < tile.length; i++) {
            for (int j = 0; j < tile[0].length; j++) {
                newGameTiles[i][j] = new Tile(tile[i][j].getValue());
            }
        }
        previousStates.push(newGameTiles);
        int scoreToSave = score;
        previousScores.push(scoreToSave);
        isSaveNeeded = false;
    }
    public void rollback() {
        if (!previousStates.isEmpty()) {
            gameTiles = previousStates.pop();
        }
        if (!previousScores.isEmpty()) {
            score = previousScores.pop();
        }
    }

    public void randomMove() {
        int random = ((int) (Math.random() * 100)) % 4;
        if (random == 0) {
            left();
        }
        if (random == 1) {
            right();
        }
        if (random == 2) {
            down();
        }
        if (random == 3) {
            up();
        }
    }

    public boolean hasBoardChanged() {
        boolean rezult = false;
        int sumNow = 0;
        int sumPrevious = 0;

        Tile[][] tiles = previousStates.peek();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                sumNow += gameTiles[i][j].getValue();
                sumPrevious += tiles[i][j].getValue();
            }
        }
        return sumNow != sumPrevious;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency moveEfficiency;
        move.move();
        if(hasBoardChanged()) {
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        } else {
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        }
        rollback();
        return moveEfficiency;
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue(4, Collections.reverseOrder());
        priorityQueue.add(getMoveEfficiency(this::left));
        priorityQueue.add(getMoveEfficiency(this::down));
        priorityQueue.add(getMoveEfficiency(this::right));
        priorityQueue.add(getMoveEfficiency(this::up));
        Move move = priorityQueue.peek().getMove();
        move.move();
    }
}
