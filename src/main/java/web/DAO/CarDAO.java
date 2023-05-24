package web.DAO;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDAO {

    private static int carCOUNT;
    private List<Car> car;

    {
        car = new ArrayList<>();

        car.add(new Car(++carCOUNT, "Ferrari", 500));
        car.add(new Car(++carCOUNT, "BMW", 100));
        car.add(new Car(++carCOUNT, "Volga", 2110));
        car.add(new Car(++carCOUNT, "Mersedes", 7));
        car.add(new Car(++carCOUNT, "Ferrari", 500));
        car.add(new Car(++carCOUNT, "BMW", 100));
        car.add(new Car(++carCOUNT, "Volga", 2110));
        car.add(new Car(++carCOUNT, "Mersedes", 7));
    }

    public List<Car> index() {
        return car;
    }

    public Car showCar(int id) {

        return car.stream().filter(car -> car.getId() == id).findAny().orElse(null);

    }

    public List<Car> viewCar(int count) {
        if (count >= 5){
            return car;
        } else
        return  car.stream().limit(count).collect(Collectors.toList());
    }
}