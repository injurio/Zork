package zork.game;

public class CommandLine implements Observer{

    @Override
    public void presentObservation(Observation observation) {
        if(observation != null) {
            System.out.println(observation.getObservationMessage());
        }
    }
}
