class ICE extends Powertrain {
    String configuration;
    int power;
    int torque;
    String engine_number;
    boolean fuel_type;

    ICE(String configuration, int power, int torque, String engine_number, boolean fuel_type) {
        this.configuration = configuration;
        this.power = power;
        this.torque = torque;
        this.engine_number = engine_number;
        this.fuel_type = fuel_type;
    }

    ICE() {
        this("", 0, 0, "", true);
    }

    @Override
    public String describe() {
        return toString();
    }

    public String toString() {
        return "Configuration: " + configuration + ", Power: " + power + " HP, Torque: " + torque +
               " Nm, Engine Number: " + engine_number + ", Fuel Type: " + (fuel_type ? "PETROL" : "DIESEL");
    }
}