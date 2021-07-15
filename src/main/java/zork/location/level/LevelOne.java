package zork.location.level;

import zork.character.monster.Basic;
import zork.game.Observation;
import zork.items.Key;
import zork.items.itemUseInFight.BluePotion;
import zork.items.itemUseInFight.RedPotion;
import zork.location.rooms.EscapeRoom;
import zork.location.rooms.SimpleRoom;

import java.util.Random;

public class LevelOne extends Level {

    private static final byte[][] map = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
    };

    public LevelOne(){
        super(map[0].length, map.length);
    }


    protected void setRoom() {
        for (int x = 0; x < x_size; x++) {
            for (int y = 0; y < y_size; y++) {
                if (map[y][x] == 0){
                    levelSetup[x][y] = new SimpleRoom();
                }
            }
        }

        // set the room that has escape door
        levelSetup[6][0] = new EscapeRoom();
    }

    @Override
    protected void putItems() {
        levelSetup[0][1].putItem(new RedPotion());
        levelSetup[0][5].putItem(new RedPotion());
        levelSetup[1][2].putItem(new BluePotion());
        levelSetup[2][5].putItem(new Key());
        levelSetup[2][1].putItem(new RedPotion());
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
        return new Observation("> Welcome to the first level of this game, try to unlock the door to next stage!!");    }
}
