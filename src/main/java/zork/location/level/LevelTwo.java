package zork.location.level;

import zork.character.monster.Basic;
import zork.game.Observation;
import zork.items.itemUseInFight.BluePotion;
import zork.items.itemUseInFight.RedPotion;
import zork.location.rooms.EscapeRoom;
import zork.location.rooms.RoomThatCanFall;
import zork.location.rooms.SimpleRoom;
import zork.location.rooms.Wall;

import java.util.Random;

public class LevelTwo extends Level {

    private static final byte[][] map = {
            {0, 1, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 0, 1, 0},
            {0, 1, 1, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0},
            {1, 1, 1, 1, 0, 1, 0},
            {1, 1, 1, 0, 0, 1, 0}
    };


    public LevelTwo(){
        super(map[0].length, map.length);
    }

    @Override
    protected void setRoom() {
        for (int x = 0; x < x_size; x++) {
            for (int y = 0; y < y_size; y++) {
                if (map[y][x] == 0){
                    levelSetup[x][y] = new SimpleRoom();
                }else {
                    levelSetup[x][y] = new Wall();
                }
            }
        }

        levelSetup[2][1] = new RoomThatCanFall();
    }

    @Override
    protected void putItems() {
        levelSetup[0][3].putItem(new RedPotion());
        levelSetup[3][3].putItem(new BluePotion());
        levelSetup[4][0].putItem(new RedPotion());
    }

    @Override
    protected void putMonster() {
        Random random = new Random();
        for (int monsterNum = 0; monsterNum < 4; monsterNum++){
            int x,y;
            do {
                x = random.nextInt(x_size);
                y = random.nextInt(y_size);
            }while ((levelSetup[x][y] instanceof SimpleRoom) && (x == 0 & y == 0) && !levelSetup[x][y].hasItem());
            levelSetup[x][y].putMonster(new Basic());
        }
    }

    @Override
    public Observation getInitialRoomMessage() {
        return new Observation("> Welcome to the second level of this game, try to pass this level to next stage!!");
    }

}
