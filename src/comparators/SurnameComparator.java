package comparators;

import java.util.Comparator;

public class SurnameComparator implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        if (o1 == null && o2 == null)
            return 0;
        if (o1 == null && o2 != null)
            return -1;
        if (o1!=null&&o2==null)
            return 1;
        if (o1.getSurname()!=null&&o2.getSurname()!=null)
            return o1.getSurname().compareTo(o2.getSurname());
        else if (o1.getSurname()==null && o2.getSurname()!=null)
            return -1;
        else if(o1.getSurname()!=null&&o2.getSurname()==null)
            return 1;
        else
            return 0;
    }
    }

