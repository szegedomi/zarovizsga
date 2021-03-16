package hu.nive.ujratervezes.zarovizsga.kennel;

public class Beagle extends Dog{


    public Beagle(String name) {
        super(name);
    }

    @Override
    void feed() {
        setHappiness(getHappiness()+2);
    }

    @Override
    void play(int hours) {
        setHappiness(getHappiness()+hours*2);
    }
}
