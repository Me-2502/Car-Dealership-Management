class EV extends Powertrain {
    int battery_capacity;
    int range;
    String motor_type;
    int power;
    int torque;

    EV(int battery_capacity, int range, String motor_type, int power, int torque) {
        this.battery_capacity = battery_capacity;
        this.range = range;
        this.motor_type = motor_type;
        this.power = power;
        this.torque = torque;
    }

    EV() {
        this(0, 0, "", 0, 0);
    }

    @Override
    public String describe() {
        return toString();
    }

    public String toString() {
        return "Battery Capacity: " + battery_capacity + " kWh, Range: " + range + " km, Motor Type: " +
               motor_type + ", Power: " + power + " HP, Torque: " + torque + " Nm";
    }
}