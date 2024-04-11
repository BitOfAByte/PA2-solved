package dk.sdu.pa2.task2;

import java.util.Comparator;

public class HealthComparator implements Comparator<Pokemon> {
    @Override
    public int compare(Pokemon p1, Pokemon p2) {
        return (p2.getHealth() == p1.getHealth()) ? p1.getName().compareTo(p2.getName()) : p2.getHealth() - p1.getHealth();
    }
}
