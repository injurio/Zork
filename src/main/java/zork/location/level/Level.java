package zork.location.level;

import zork.character.Player;
import zork.game.Observation;
import zork.location.rooms.Room;

public abstract class Level {

    protected int x_size;
    protected int y_size;
    private static final int x_start = 0;
    private static final int y_start = 0;
    protected Room[][] levelSetup;
    protected boolean[][] roomVisited;
    protected Player player;
    protected boolean completed;

    public Level(int x_size, int y_size){
        this.x_size = x_size;
        this.y_size = y_size;
        levelSetup = new Room[x_size][y_size];
        setLevel();
        roomVisited = new boolean[x_size][y_size];
        player = Player.getPlayer();
        player.place_player(x_size, y_size);
        roomVisited[0][0] = true;
    }

    protected abstract void setRoom();
    protected abstract void putItems();
    protected abstract void putMonster();

    private void setLevel(){
        setRoom();
        putItems();
        putMonster();
    }

    public abstract Observation getInitialRoomMessage();

    public Observation getLevelLand(){
        StringBuilder mark = new StringBuilder();
        for (int i = 0; i < y_size; i++) {
            for (int j = 0; j < x_size; j++) {
                if (player.gety_coordinate() == i & player.getx_coordinate() == j){
                    mark.append('+');
                }else if (roomVisited[j][i]){
                    mark.append('O');
                }else {
                    mark.append('.');
                }
                mark.append(' ');
            }
            mark.append('\n');
        }
        return new Observation(mark.toString());
    }

    // setting the condition for walking up
    public Observation walkUp(){
        if(player.gety_coordinate() > 0 && levelSetup[player.getx_coordinate()][player.gety_coordinate() - 1].canWalk()){
            player.walkUp();
            roomVisited[player.getx_coordinate()][player.gety_coordinate()] = true;
            return new Observation("You are walking up").concatObservation(levelSetup[player.getx_coordinate()][player.gety_coordinate()].getRoomMessage());
        }else {
            return new Observation("You cannot walk up from here");
        }
    }

    // setting the condition for walking down
    public Observation walkDown(){
        if(player.gety_coordinate() < y_size-1 && levelSetup[player.getx_coordinate()][player.gety_coordinate() + 1].canWalk()){
            player.walkDown();
            roomVisited[player.getx_coordinate()][player.gety_coordinate()] = true;
            return new Observation("You are walking down").concatObservation(levelSetup[player.getx_coordinate()][player.gety_coordinate()].getRoomMessage());
        }else {
            return new Observation("You cannot walk down from here");
        }
    }

    public Observation walkLeft(){
        if(player.getx_coordinate() > 0 && levelSetup[player.getx_coordinate() - 1][player.gety_coordinate()].canWalk()){
            player.walkLeft();
            roomVisited[player.getx_coordinate()][player.gety_coordinate()] = true;
            return new Observation("You are walking left").concatObservation(levelSetup[player.getx_coordinate()][player.gety_coordinate()].getRoomMessage());
        }else {
            return new Observation("You cannot walk left from here");
        }
    }

    public Observation walkRight(){
        if(player.getx_coordinate() < x_size-1 && levelSetup[player.getx_coordinate() + 1][player.gety_coordinate()].canWalk()){
            player.walkRight();
            roomVisited[player.getx_coordinate()][player.gety_coordinate()] = true;
            return new Observation("You are walking right").concatObservation(levelSetup[player.getx_coordinate()][player.gety_coordinate()].getRoomMessage());
        }else {
            return new Observation("You cannot walk right from here");
        }
    }

    public void toggleCompleted(){
        completed = true;
    }

    public boolean isCompleted(){
        return completed;
    }

    public Room getCurrentRoom(){
        int x = player.getx_coordinate();
        int y = player.gety_coordinate();
        return levelSetup[x][y];
    }

    public void resetPlayer(){
        player.place_player(x_start,y_start);
    }

}
