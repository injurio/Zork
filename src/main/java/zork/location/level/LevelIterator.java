package zork.location.level;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LevelIterator  {

    public static final List<Level> levelList = new ArrayList<Level>(){{
        add(new LevelOne());
        add(new LevelTwo());
        add(new LevelBoss());
    }};

    private static Iterator<Level> levelIterator = levelList.iterator();

    public static Level nextLevel(){
        return levelIterator.next();
    }

    public static void reset(){
        levelIterator = levelList.iterator();
    }

    public static boolean hasNextLevel(){
        return levelIterator.hasNext();
    }
}
