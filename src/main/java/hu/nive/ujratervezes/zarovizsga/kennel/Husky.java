package hu.nive.ujratervezes.zarovizsga.kennel;

public class Husky extends Dog{


    public Husky(String name) {
        super(name);
    }

    @Override
    void feed() {
        setHappiness(getHappiness()+4);
    }

    @Override
    void play(int hours) {
        setHappiness(getHappiness()+hours*3);
    }
}
