import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.ObjDoubleConsumer;

/**
 * @author Ife Sunmola
 */
record Food(String name, Double price) {} // test object, everybody likes food.

class ConsumerDemo {
	public static void main(String[] args) {
		testConsumer();
		testBiConsumer();
		testObjDoubleConsumer();
	}

	private static void testConsumer() {
		System.out.println("---------------------Consumer test---------------------");
		Consumer<Food> consumer = System.out::println;

		var pizza = new Food("Pizza", 10.99);
		var rice = new Food("Rice", 5.99);

		consumer.accept(pizza);
		consumer.accept(rice);
		consumer.accept(new Food("Beans", 3.99));
	}

	private static void testBiConsumer() {
		System.out.println("---------------------BiConsumer test---------------------");
		BiConsumer<Food, String> consumer = (food, owner) -> System.out.println(owner + " likes " + food.name());

		var pizza = new Food("Pizza", 10.99);
		var rice = new Food("Rice", 5.99);

		consumer.accept(pizza, "Ife");
		consumer.accept(rice, "Nicholas");
		consumer.accept(new Food("Beans", 3.99), "Cassi");
	}

	private static void testObjDoubleConsumer() {
		System.out.println("---------------------ObjDoubleConsumer test---------------------");
		ObjDoubleConsumer<Food> consumer = (food, customerPaid) -> {
			var difference = customerPaid - food.price();
			System.out.println("Customer paid $" + customerPaid + " for " + food.name() + " which costs $" + food.price() + ". Difference: $" + difference);
		};

		var pizza = new Food("Pizza", 10.99);
		var rice = new Food("Rice", 5.99);

		consumer.accept(pizza, 15.99);
		consumer.accept(rice, 9.99);
		consumer.accept(new Food("Beans", 3.99), 5.99);
	}
}