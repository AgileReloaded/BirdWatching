package iad.birdwatching;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BirdsArmy implements Iterable<Bird> {

    private final List<Bird> birds = new ArrayList<>();

    /** Tutti gli uccelli si trovano dentro il campo di gioco? */
    public boolean areAllBirdsPlacedWithinField(final GridSize gridSize) {
        return !birds.isEmpty() &&
               birds.stream()
                    .allMatch(bird -> gridSize.isWithinGrid(bird.getLocation()));
    }

    /** Almeno un uccello è stato colpito da questo sparo? */
    public boolean anyBirdWasHit(final Location shotLocation) {
        return birds.stream()
                    .anyMatch(bird -> bird.wasHit(shotLocation));
    }

    @Override
    public Iterator<Bird> iterator() {
        return birds.iterator();
    }

    public void add(Bird bird) {
        birds.add(bird);
    }
}