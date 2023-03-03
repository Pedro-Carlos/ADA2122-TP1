
public class Sequence {
    private Lemming[] gameLemmings;
    private int numberOfLemmings;

    public Sequence(Lemming[] gameLemmings){
        this.gameLemmings = gameLemmings;
        this.numberOfLemmings = gameLemmings.length;
    }

    public Lemming[] getGameLemmings() {
        return gameLemmings;
    }

    public int getNumberOfLemmings() {
        return numberOfLemmings;
    }
}
