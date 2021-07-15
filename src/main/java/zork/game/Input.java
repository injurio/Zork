package zork.game;

import zork.command.Command;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Input {

    public static BufferedReader readIn = new BufferedReader(new InputStreamReader(System.in));

    public Command receiveInput(Game game){
        try {
            String inputString = readIn.readLine();
            for (Command command : game.getCommandsList()){
                if(inputString.startsWith(command.get_name_command())){
                    return command;
                }
            }
        } catch(Exception e){
            System.out.println("There is an error in command reading, please try again.");
        }
        return null;
    }

    public Observation processCommand(Command command, Game game){
        if(command == null){
            return new Observation("Me no get your command, try again.");
        } else{
            Observation ob = command.do_the_command(game);
            return ob;
        }
    }

    public String receiveInputAsString(){
        try{
            String inputString = readIn.readLine();
            return inputString;
        } catch (Exception e){
            return null;
        }
    }
}
