package zork.location.level;

import zork.character.monster.Advance;
import zork.character.monster.Boss;
import zork.game.Observation;
import zork.items.itemUseInFight.BluePotion;
import zork.items.itemUseInFight.RedPotion;
import zork.location.rooms.SimpleRoom;
import zork.location.rooms.Wall;

public class LevelBoss extends Level {

    private static final byte[][] map = {
            {0, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1}
    };

    public LevelBoss(){
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
    }

    @Override
    protected void putItems() {
        levelSetup[0][1].putItem(new RedPotion());
        levelSetup[2][3].putItem(new BluePotion());
    }

    @Override
    protected void putMonster() {
        levelSetup[4][3].putMonster(new Advance());
        levelSetup[6][3].putMonster(new Advance());
        levelSetup[6][0].putMonster(new Boss());
    }


    @Override
    public Observation getInitialRoomMessage() {
        return new Observation("> Where is this place?. I heard something!. It's Boss!!!");
    }
}
