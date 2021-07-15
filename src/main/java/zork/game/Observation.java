package zork.game;

public class Observation {

    private StringBuilder observationMessage;

    public Observation(String message){
        observationMessage = new StringBuilder().append(message);
    }


    public void addMessage(String message){
        observationMessage.append('\n');
        observationMessage.append(message);
    }

    public Observation concatObservation(Observation anotherObservation){
        if (anotherObservation != null){
            this.addMessage(anotherObservation.getObservationMessage());
        }
        return this;
    }

    public String getObservationMessage() {
        return observationMessage.toString();
    }


    public static class Builder {

        private StringBuilder sb = new StringBuilder();

        public Builder addString(String str){
            this.sb.append(str).append('\n');
            return this;
        }

        public Observation build(){
            this.sb.deleteCharAt(this.sb.length()-1);
            return new Observation(this.sb.toString());
        }
    }
}
