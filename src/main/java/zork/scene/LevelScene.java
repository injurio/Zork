package zork.scene;

import zork.command.control.ControlCommandFactory;
import zork.command.walk.WalkCommandFactory;
import zork.game.Game;
import zork.game.Observation;
import zork.location.level.Level;
import zork.location.level.LevelIterator;

public class LevelScene extends Scene{

    @Override
    public void playScene(Game game) {

        Level currentLevel = LevelIterator.nextLevel();
        currentLevel.resetPlayer();

        game.setCurrentLevel(currentLevel);
        game.notifyObserver(currentLevel.getInitialRoomMessage());

        while (!currentLevel.isCompleted() && game.getPlayer().isAlive()) {

            game.resetCommandsList();
            game.addCommandsToList(new WalkCommandFactory().getCommands());
            game.addCommandsToList(new ControlCommandFactory().getCommands());

            showCommand(game);

            if (currentLevel.getCurrentRoom().hasMonster() && !currentLevel.isCompleted()) {
                Fight fight = new Fight(game.getCurrentLevel().getCurrentRoom().getMonster());
                game.setCurrentFight(fight);
                fight.doFight(game);
            }

        }

        if(game.getPlayer().isAlive()){
            Observation ob = new Observation.Builder()
                    .addString("Level has been completed!").build();
            game.notifyObserver(ob);
            if (LevelIterator.hasNextLevel()){
                game.getPlayer().increase_max_health(5);
                game.getPlayer().increase_max_mana(5);
                game.getPlayer().increase_health(5);
                game.getPlayer().increase_mana(5);
                game.getPlayer().increase_max_attack();
                game.notifyObserver(new Observation("Enter anything to go to the next level."));
                String in = game.getInput().receiveInputAsString();
                game.setNextScene(new LevelScene());
            } else{
                game.setNextScene(new Winner());
            }
        } else{
            game.setNextScene(new GameOver());
        }

    }
}
