package model.car;

public class ICE extends Powertrain {
    private String configuration;
    private int powerHp;
    private int torqueNm;
    private String engineNumber;
    private FuelType fuelType;

    public ICE(String configuration, int powerHp, int torqueNm, String engineNumber, FuelType fuelType) {
        super("ICE");
        this.configuration = configuration;
        this.powerHp = powerHp;
        this.torqueNm = torqueNm;
        this.engineNumber = engineNumber;
        this.fuelType = fuelType;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
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

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "ICE{" +
                "configuration='" + configuration + '\'' +
                ", powerHp=" + powerHp +
                ", torqueNm=" + torqueNm +
                ", engineNumber='" + engineNumber + '\'' +
                ", fuelType=" + fuelType +
                '}';
    }
}
