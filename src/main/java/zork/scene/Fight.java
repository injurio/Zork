package zork.scene;

import zork.character.Player;
import zork.character.monster.Monster;
import zork.command.Command;
import zork.command.fight.FightCommand;
import zork.game.Game;
import zork.game.Input;
import zork.game.Observation;

public class Fight {

    private Monster fightingMonster;
    private Player player;
    private boolean isDone;
    private boolean turnCompleted;

    public Fight(Monster monster){
        this.fightingMonster = monster;
        this.player = Player.getPlayer();
        this.isDone = false;
        this.turnCompleted = false;
    }

    public void doFight(Game game){

        Observation ob;
        Input input = game.getInput();
        ob = new Observation("You met a monster!");
        game.notifyObserver(ob);

        while(!isDone){

            turnCompleted = false;

            // Player's turn
            while(!turnCompleted) {

                game.notifyObserver(new Observation(getFightStats()));

                game.resetCommandsList();
                game.addCommandsToList(new FightCommand().getCommands());

                Observation commandsList = game.getCommandsAsString();
                game.notifyObserver(commandsList);

                Command command = input.receiveInput(game);
                if (command != null) {
                    ob = command.do_the_command(game);
                    game.notifyObserver(ob);
                } else {
                    game.notifyObserver(new Observation("Invalid input, try again."));
                }

            }

            // Monster's move
            if (fightingMonster.isAlive()) {
                ob = fightingMonster.doInTurn(player);
                game.notifyObserver(ob);
                if (!player.isAlive()) {
                    isDone = true;
                }
            } else {
                isDone = true;
                game.getCurrentLevel().getCurrentRoom().putMonster(null);
            }

        }
        if (player.isAlive()){
            ob = new Observation("You're won!");
            game.notifyObserver(ob);
            player.increase_max_health();
            player.increase_max_mana();
            player.increase_health();
            player.increase_mana();
            player.increase_max_attack();
        } else{
            ob = new Observation("Oof, you are death.");
            game.notifyObserver(ob);
            game.getCurrentLevel().toggleCompleted();
        }
        game.setCurrentFight(null);
    }

    public boolean isDone() {
        return isDone;
    }

    public Monster getFightingMonster() {
        return fightingMonster;
    }

    public String getFightStats(){
        StringBuilder sb = new StringBuilder();
        sb.append("Your health : ").append(player.getHealth()).append('/').append(player.getMax_player_health()).append('\n');
        sb.append("Your mana   : ").append(player.getMana()).append('/').append(player.getMax_player_mana()).append('\n');
        sb.append("Their health: ").append(fightingMonster.getHealth()).append('/').append(fightingMonster.get_max_health());
        return sb.toString();
    }

    public void toggleTurnCompleted(){
        turnCompleted = !turnCompleted;
    }
}
