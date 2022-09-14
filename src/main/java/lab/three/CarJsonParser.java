package lab.three;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarJsonParser {

    private static final String NAME_TAG = "Name";
    private static final String MILES_PER_GALLON_TAG = "Miles_per_Gallon";
    private static final String CYLINDERS_COUNT_TAG = "Cylinders";
    private static final String DISPLACEMENT_TAG = "Displacement";
    private static final String HORSEPOWER_TAG = "Horsepower";
    private static final String WEIGHT_IN_LBS_TAG = "Weight_in_lbs";
    private static final String ACCELERATION_IN_MPS_TAG = "Acceleration";
    private static final String RELEASE_DATE_TAG = "Year";
    private static final String ORIGIN_TAG = "Origin";
    private static final String PRICE_TAG = "Price";
    private static final String MAX_SPEED_IN_KmH_TAG = "Max_speed_in_KmH";

    private JSONParser parser = new JSONParser();
    private String path;

    private static CarData convertToCarData(JSONObject jsonObject) {
        var carData = new CarData();

        carData.setName((String) jsonObject.get(NAME_TAG));
        carData.setMilesPerGallon((int) (long) jsonObject.get(MILES_PER_GALLON_TAG));
        carData.setCylindersCount((int) (long) jsonObject.get(CYLINDERS_COUNT_TAG));
        carData.setDisplacement((int) (long) jsonObject.get(DISPLACEMENT_TAG));
        carData.setHorsepower((int) (long) jsonObject.get(HORSEPOWER_TAG));
        carData.setWeightInLbs((int) (long) jsonObject.get(WEIGHT_IN_LBS_TAG));
        carData.setAccelerationInMps((double) jsonObject.get(ACCELERATION_IN_MPS_TAG));
        carData.setReleaseDate((String) jsonObject.get(RELEASE_DATE_TAG));
        carData.setOrigin((String) jsonObject.get(ORIGIN_TAG));
        carData.setPriceInUsd((int) (long) jsonObject.get(PRICE_TAG));
        carData.setMaxSpeedInKmH((int) (long) jsonObject.get(MAX_SPEED_IN_KmH_TAG));

        return carData;
    }

    public CarJsonParser(String path) {
        this.path = path;
    }

    public List<CarData> readCars() {
        var cars = new ArrayList<CarData>();

        try (FileReader reader = new FileReader(path)) {
            JSONArray jsonArray = (JSONArray) parser.parse(reader);

            for (Object jsonObject : jsonArray) {
                var car = convertToCarData((JSONObject) jsonObject);
                cars.add(car);
            }
        } catch (Exception e) {

            System.out.println("Parsing error" + e.toString());
        }

        return cars;
    }
}
