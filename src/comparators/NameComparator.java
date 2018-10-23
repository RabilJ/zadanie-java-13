package comparators;

import java.util.Comparator;

public class NameComparator implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {

    if (o1 == null && o2 == null)
            return 0;
        if (o1 == null && o2 != null)
            return -1;
        if (o1!=null&&o2==null)
            return 1;
        if (o1.getName()!=null&&o2.getName()!=null)
                return o1.getName().compareTo(o2.getName());
        else if (o1.getName()==null && o2.getName()!=null)
                return -1;
        else if(o1.getName()!=null&&o2.getName()==null)
                return 1;
        else
                return 0;
}
}

