import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        CompanyET myCompany = new CompanyET("Razer", 200000, 250000);
        System.out.println(myCompany.currentProfit());
    }

    public Car[] carFilter(Car[] cars, char characterForFiltering){
        int count = 0;
        for(Car car : cars){
            if(car.getBrand().charAt(0) == characterForFiltering){
                count++;
            }
        }

        Car[] filteredCars = new Car[count];
        int index = 0;
        for(Car car : cars){
            if(car.getBrand().charAt(0) == characterForFiltering){
                filteredCars[index] = car;
                index++;
            }
        }

        return filteredCars;
    }

    public Car[] sortingCars(Car[] cars, String typeSort){
        Car[] sortedCars = new Car[cars.length];
        Comparator<Car> carComparator = Comparator.comparing(Car::getBrand);

        if(typeSort.equals("Ascending")){
            Arrays.sort(cars, carComparator);
        } else if (typeSort.equals("Descending")) {
            Arrays.sort(cars, carComparator.reversed());
        }else {
            System.out.println("Invalid sort type!");
        }

        return cars;
    }

    public Car[] removeDuplicatingCars(Car[] cars){
        int numOfDuplicatingCars = 0;
        for(Car car : cars){
            for (int i = 1; i < cars.length-1; i++){
                if(car.equals(cars[i])){
                    cars[i-1] = null;
                    numOfDuplicatingCars++;
                }
            }
        }

        Car[] noDuplicatesArray = new Car[cars.length - numOfDuplicatingCars];
        int index = 0;
        for(Car car : cars){
            if(car != null){
                noDuplicatesArray[index] = car;
                index++;
            }
        }

        return noDuplicatesArray;
    }

}