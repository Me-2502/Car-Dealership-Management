package model.car;

public class EV extends Powertrain {
    private int batteryCapacityKwh;
    private int rangeKm;
    private String motorType;
    private int powerHp;
    private int torqueNm;

    public EV(int batteryCapacityKwh, int rangeKm, String motorType, int powerHp, int torqueNm) {
        super("EV");
        this.batteryCapacityKwh = batteryCapacityKwh;
        this.rangeKm = rangeKm;
        this.motorType = motorType;
        this.powerHp = powerHp;
        this.torqueNm = torqueNm;
    }

    public int getBatteryCapacityKwh() {
        return batteryCapacityKwh;
    }

    public void setBatteryCapacityKwh(int batteryCapacityKwh) {
        this.batteryCapacityKwh = batteryCapacityKwh;
    }

    public int getRangeKm() {
        return rangeKm;
    }

    public void setRangeKm(int rangeKm) {
        this.rangeKm = rangeKm;
    }

    public String getMotorType() {
        return motorType;
    }

    public void setMotorType(String motorType) {
        this.motorType = motorType;
    }

    public int getPowerHp() {
        return powerHp;
    }

    public void setPowerHp(int powerHp) {
        this.powerHp = powerHp;
    }

    public int getTorqueNm() {
        return torqueNm;
    }

    public void setTorqueNm(int torqueNm) {
        this.torqueNm = torqueNm;
    }

    @Override
    public String toString() {
        return "EV{" +
                "batteryCapacityKwh=" + batteryCapacityKwh +
                ", rangeKm=" + rangeKm +
                ", motorType='" + motorType + '\'' +
                ", powerHp=" + powerHp +
                ", torqueNm=" + torqueNm +
                '}';
    }
}
