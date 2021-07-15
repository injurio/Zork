package zork.command.control;

import zork.command.Command;
import zork.game.Game;
import zork.game.Observation;

public class Info implements Command {
    @Override
    public Observation do_the_command(Game game) {
        StringBuilder sb = new StringBuilder();
        sb.append("Current Health: ").append(game.getPlayer().getHealth()).append('/').append(game.getPlayer().getMax_player_health()).append('\n');
        sb.append("Current Mana: ").append(game.getPlayer().getMana()).append('/').append(game.getPlayer().getMax_player_mana()).append('\n');
        sb.append("Current Attack: ").append(game.getPlayer().getMax_player_attack());
        return new Observation(sb.toString());
    }

    @Override
    public String get_name_command() {
        return "information";
    }
}
