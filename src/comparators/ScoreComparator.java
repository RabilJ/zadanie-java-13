package comparators;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        if (o1 == null && o2 == null)
            return 0;
        if (o1 == null && o2 != null)
            return -1;
        if (o1 != null && o2 == null)
            return 1;

        if (o1.getScore() != 0 && o2.getScore() != 0) {
            if (o1.getScore() > o2.getScore())
                return 1;
            else if (o1.getScore() == o2.getScore())
                return 0;
            else
                return -1;
        } else if (o1.getScore() == 0 && o2.getScore() != 0)
            return -1;
        else if (o1.getScore() != 0 && o2.getScore() == 0)
            return 1;
        else
            return 0;
    }
}