package Extras;

import java.util.concurrent.Callable;

interface Reptile {
    ReptileEgg lay();
}

class FireDragon implements Reptile {
    public FireDragon() {
    }

    public static void main(String[] args) throws Exception {
        FireDragon fireDragon = new FireDragon();
        System.out.println(fireDragon instanceof Reptile);
    }

    @Override
    public ReptileEgg lay() {
        return new ReptileEgg(new Callable<Reptile>() {
            @Override
            public Reptile call() throws Exception {
                return new FireDragon();
            }
        });
    }
}

class ReptileEgg {

    private boolean hatched = false;
    private Callable<Reptile> curSpecies;

    public ReptileEgg(Callable<Reptile> createReptile) {
        curSpecies = createReptile;
    }

    public Reptile hatch() throws Exception {
        // check hatched
        if (hatched) {
            throw new IllegalStateException("An egg can not be hatched more than once");
        }
        // hatch it
        hatched = true;
        return curSpecies.call();
    }
}
