package CVRP.algorithm;

import CVRP.objects.DNA;
import CVRP.utils.TLArrayList;

public class Generation {

    private TLArrayList<DNA> DNAs = new TLArrayList<DNA>();

    public Generation(Objects objects, Generation lastGen) {

    }

    public Generation(Objects objects) {
        for (int i = 0; i < 100; i++) {
            DNAs.add(new DNA(true, objects));
        }
    }

    public DNA getBest() {
        throw new UnsupportedOperationException();
    }

}
