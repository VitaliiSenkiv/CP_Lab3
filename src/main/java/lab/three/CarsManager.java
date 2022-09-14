package lab.three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarsManager {

    public static HashMap<Integer, ArrayList<CarData>> getCarsGroupedByMaxSpeed(List<CarData> cars) {
        var map = new HashMap<Integer, ArrayList<CarData>>();

        for (var car : cars) {
            var maxSpeed = car.getMaxSpeedInKmH();

            if (!map.containsKey(maxSpeed))
                map.put(maxSpeed, new ArrayList<>());

            map.get(maxSpeed).add(car);
        }

        return map;
    }

    public static HashMap<Integer, ArrayList<CarData>> filterCarsMap(HashMap<Integer, ArrayList<CarData>> map,
                                                                     List<String> models) {
        var limitedMap = map.clone();

        for (var group : map.entrySet()) {
            group.getValue().removeIf(car -> models.contains(car.getName()));
        }

        return map;
    }
}
