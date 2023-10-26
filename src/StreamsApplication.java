import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Ife Sunmola
 */
class StreamsApplication {
	public static void main(String[] args) {
		var testList = getCars();

		System.out.println("All ford vehicles: ");
		Stream<Car> fordVehicles = testList.stream()
				.filter(car -> car.make.equals("Ford"));
		// forEach takes a consumer. Consumers take in a parameter and return void
		// below is equivalent to: fordVehicles.forEach(vehicle -> {System.out.println(vehicle);});
		fordVehicles.forEach(System.out::println); // method reference
		System.out.println("-----------------------------------------------------------------------------------");

		System.out.println("All car makes: ");
		Stream<String> carMakes = testList.stream()
				.map((car) -> car.make)
				.distinct();
		carMakes.forEach(System.out::println); // could just call forEach after map
		System.out.println("-----------------------------------------------------------------------------------");

		int minYear = testList.stream()
				.mapToInt(car -> car.year)
				.min()
				.orElseThrow();
		System.out.println("Min car year: " + minYear);
		System.out.println("-----------------------------------------------------------------------------------");

		System.out.println("Car models between 2015 and 2018, that are not Fords: ");
		testList.stream()
				.filter(car -> !car.make.equals("Ford") && car.year >= 2015 && car.year <= 2018)
				.map(Car::model)
				.forEach(System.out::println);
		System.out.println("-----------------------------------------------------------------------------------");

		System.out.println("Amount of Honda: " + testList.stream()
				.filter(car -> car.make.equals("Honda"))
				.count()
		);
		System.out.println("-----------------------------------------------------------------------------------");

		System.out.println("Sort by newest: ");
		testList.stream()
				.sorted(Comparator.comparing(Car::year, Comparator.reverseOrder()))
				.forEach(System.out::println);
		System.out.println("-----------------------------------------------------------------------------------");

		System.out.println("For some reason, you want to find the sum of all the years: " + testList.stream()
				.mapToInt(Car::year)
				.sum());

		System.out.print("The sum again, but with more mental gymnastics: ");
		// reduce is an overloaded method, we're using the one that takes a BinaryOperator<T>
		// Binary operator is like a "special" kind of BiFunction. Recall that BiFunction takes two values and returns one.
		// BinaryOperator<T> simplifies it to taking two values of the same type T and returning that same type T.
		// That's what Integer::sum is internally doing. Replace Integer::sum with `(a, b) -> a + b` ... same result
		// ifPresentOrElse is from the Optional class. It's literally as the name sounds
		// if present, run the first. Note: the first parameter is a consumer (takes a value, returns nothing)
		// or else, execute the Runnable. Runnable -> takes no value, does something, returns nada
		testList.stream()
				.map(Car::year)
				.reduce(Integer::sum)
				.ifPresentOrElse(
						System.out::println, // same as: sum -> System.out.println(sum),
						() -> System.out.println("Could not do sum")
				);
		System.out.println("-----------------------------------------------------------------------------------");


	}

	record Car(String make, String model, int year) {}

	private static List<Car> getCars() {
		var cars = new ArrayList<>(List.of(new Car("Ford", "Fiesta", 2012),
				new Car("Ford", "Focus", 2011),
				new Car("Ford", "Mustang", 2015),
				new Car("Honda", "Accord", 2018),
				new Car("Honda", "Civic", 2017),
				new Car("Honda", "CRV", 2019),
				new Car("Toyota", "Corolla", 2020),
				new Car("Toyota", "Camry", 2019),
				new Car("Toyota", "Prius", 2017),
				new Car("Nissan", "Sentra", 2019),
				new Car("Nissan", "Altima", 2018)
		));
		Collections.shuffle(cars);
		return cars;
	}
}