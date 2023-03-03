
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LemmingsEvolved le = new LemmingsEvolved();
        int games = Integer.parseInt(reader.readLine());

        int gamePairs = games*2; //Game is mane of two sequences
        Sequence[] sequence = new Sequence[gamePairs];
        for (int i = 0; i < gamePairs; i++) {
            int numberOfTribes = Integer.parseInt(reader.readLine());
            if(numberOfTribes > 0) {
                Lemming[] lemmings = new Lemming[numberOfTribes];
                for (int j = 0; j < numberOfTribes; j++) {
                    String[] line = reader.readLine().split(" ");
                    lemmings[j] = new Lemming(line[0], Integer.parseInt(line[1]));
                }
                sequence[i] = new Sequence(lemmings);
            }
        }

        for (int i = 0; i < gamePairs-1; i=i+2) {
            long[] result = le.total(sequence[i], sequence[i+1]);
            System.out.println(result[0] + " " + result[1]);
        }
    }

}

