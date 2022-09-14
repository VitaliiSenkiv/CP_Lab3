package lab.three;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var parser1 = new CarJsonParser("src/main/java/cars1.json");
        var parser2 = new CarJsonParser("src/main/java/cars2.json");

        List<CarData> cars1 = parser1.readCars();
        List<CarData> cars2 = parser2.readCars();
    }
}