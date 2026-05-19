package model.car;

public abstract class Powertrain {
    private final String type;

    protected Powertrain(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public abstract String toString();
}
