
public class LemmingsEvolved {

    public long[] total(Sequence X, Sequence Y) {
        if (X == null || Y == null) { //if one of the sequences is null points and combinations are always 0
            return new long[]{0, 0};
        }
        int numberX = X.getNumberOfLemmings();
        int numberY = Y.getNumberOfLemmings();
        long[][] tab = new long[numberX + 1][numberY + 1];
        long[][] combinations = new long[numberX + 1][numberY + 1];


        for (int i = 1; i <= numberX; i++) {
            for (int j = 1; j <= numberY; j++) {
                Lemming x = X.getGameLemmings()[i - 1];
                Lemming y = Y.getGameLemmings()[j - 1];
                long valueEqual = tab[i - 1][j - 1] + (x.getPowerValue() + y.getPowerValue());
                if (x.getTribe().equals(y.getTribe()) && valueEqual > tab[i - 1][j] && valueEqual > tab[i][j-1]) {
                    tab[i][j] = valueEqual;
                    combinations[i][j] = combinations[i - 1][j - 1] + 1;
                } else if (tab[i - 1][j] > tab[i][j - 1]) {
                    tab[i][j] = tab[i - 1][j];
                    combinations[i][j] = combinations[i - 1][j];
                }else {
                    tab[i][j] = tab[i][j - 1];
                    combinations[i][j] = combinations[i][j - 1];
                    if(tab[i - 1][j] == tab[i][j - 1])
                        combinations[i][j] = Long.min(combinations[i][j - 1], combinations[i-1][j]);
                }
            }
        }
        return new long[]{tab[numberX][numberY], combinations[numberX][numberY]};
    }
}
