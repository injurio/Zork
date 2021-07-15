package zork.game;

import zork.character.Player;
import zork.command.Command;
import zork.location.level.Level;
import zork.scene.Fight;
import zork.scene.Scene;
import zork.scene.StartScene;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Game {

    private Player player;
    private Level currentLevel;
    private List<Command> commandsList;
    private Fight currentFight;
    private Input input;
    private Observer observer;
    private Scene nextScene;
    private Scene startScene;

    private boolean isWon = false;

    public Game() {
        this.player = Player.getPlayer();
        this.currentLevel = null;
        this.commandsList = new ArrayList<Command>();
        this.currentFight = null;
        this.input = new Input();
        this.observer = new CommandLine();
        this.nextScene = new StartScene();
        this.startScene = new StartScene();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Level currentLevel) {
        this.currentLevel = currentLevel;
    }

    public List<Command> getCommandsList() {
        return commandsList;
    }

    public Observation getCommandsAsString(){
        Observation ob = new Observation("Available commands:");
        StringBuilder sb = new StringBuilder();
        Iterator<Command> it = commandsList.iterator();
        while(it.hasNext()){
            sb.append(it.next().get_name_command());
            if(it.hasNext()){
                sb.append(", ");
            }
        }
        ob.addMessage(sb.toString());
        return ob;
    }

    public void resetCommandsList() {
        this.commandsList = new ArrayList<Command>();
    }

    public void addCommandToList(Command command){
        this.commandsList.add(command);
    }

    public void addCommandsToList(List<Command> commands){
        this.commandsList.addAll(commands);
    }

    public Fight getCurrentFight() {
        return currentFight;
    }

    public void setCurrentFight(Fight fight) {
        this.currentFight = fight;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public Observer getObserver() {
        return observer;
    }

    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    public void notifyObserver(Observation observation){
        observer.presentObservation(observation);
    }

    public Scene getNextScene() {
        return nextScene;
    }

    public Scene getStartScene(){
        return startScene;
    }

    public void setNextScene(Scene scene){
        this.nextScene = scene;
    }
}
