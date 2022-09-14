package lab.three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static void printFirstNElements(HashMap<Integer, ArrayList<CarData>> map, int n) {
        for (var carGroup : map.entrySet()) {
            System.out.println("max speed " + carGroup.getKey());
            carGroup.getValue().subList(0, Math.min(n, carGroup.getValue().size()))
                    .forEach(car -> System.out.println('\t' + car.toString()));
        }
    }

    public static void main(String[] args) {
        var parser1 = new CarJsonParser("src/main/java/cars1.json");
        var parser2 = new CarJsonParser("src/main/java/cars2.json");

        List<CarData> cars1 = parser1.readCars();

        var map = CarsManager.getCarsGroupedByMaxSpeed(cars1);

        var reader = new InputReader();
        int n = reader.readUInt("n");

        printFirstNElements(map, n);

        var limitedModels = reader.readStrings("Enter models to remove");
        var limitedMap = CarsManager.filterCarsMap(map, limitedModels);

        System.out.println("\nAfter deleting:" + limitedModels.toString());
        printFirstNElements(limitedMap, n);

        List<CarData> unitedCars = parser2.readCars();
        unitedCars.addAll(cars1);
        unitedCars.sort((car1, car2) -> car2.getName().compareTo(car1.getName()));

        System.out.println("\nEnter price borders:");
        int minPrice = reader.readUInt("min price");
        int maxPrice = reader.readUInt("max price");

        int count = 0;
        for (var car : unitedCars) {
            if(car.getPriceInUsd() >= minPrice && car.getPriceInUsd() <= maxPrice)
                ++count;
        }
        System.out.println("There are " + count + "cars in range " + minPrice + " to " + maxPrice);

        try {
            reader.close();
        } catch (Exception e) {
            System.out.println("close exception " + e.toString());
        }
    }
}