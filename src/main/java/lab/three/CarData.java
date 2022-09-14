package lab.three;

import java.util.Date;

public class CarData {
    private String name;
    private int milesPerGallon;
    private int cylindersCount;
    private int displacement;
    private int horsepower;
    private int weightInLbs;
    private double accelerationInMps;
    private String releaseDate;
    private String origin;
    private int priceInUsd;
    private int maxSpeedInKmH;

    @Override
    public String toString() {
        return String.format("name: %s, %d miles per gallon, cylinders: %d, displacement: %d miles" +
                "horsepower: %d, weight: %d(lbs), acceleration %f(Mps), release: %s, origin: %s " +
                "price: $%d, max speed: %dKmH", name, milesPerGallon, cylindersCount, displacement,
                horsepower, weightInLbs, accelerationInMps, releaseDate, origin, priceInUsd, maxSpeedInKmH);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMilesPerGallon() {
        return milesPerGallon;
    }

    public void setMilesPerGallon(int milesPerGallon) {
        this.milesPerGallon = milesPerGallon;
    }

    public int getCylindersCount() {
        return cylindersCount;
    }

    public void setCylindersCount(int cylindersCount) {
        this.cylindersCount = cylindersCount;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getWeightInLbs() {
        return weightInLbs;
    }

    public void setWeightInLbs(int weightInLbs) {
        this.weightInLbs = weightInLbs;
    }

    public double getAccelerationInMps() {
        return accelerationInMps;
    }

    public void setAccelerationInMps(double accelerationInMps) {
        this.accelerationInMps = accelerationInMps;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getPriceInUsd() {
        return priceInUsd;
    }

    public void setPriceInUsd(int priceInUsd) {
        this.priceInUsd = priceInUsd;
    }

    public int getMaxSpeedInKmH() {
        return maxSpeedInKmH;
    }

    public void setMaxSpeedInKmH(int maxSpeedInKmH) {
        this.maxSpeedInKmH = maxSpeedInKmH;
    }
}
