import java.util.List;
import java.util.function.Supplier;

/**
 * @author Ife Sunmola
 */
class SupplierDemo {
	public static void main(String[] args) {
		testSupplier();
		testListSupplier();
	}

	private static void testSupplier() {
		System.out.println("---------------------Supplier test---------------------");

		Supplier<String> getDb = () -> "jdbc:mysql://localhost:3306/your-mama.db";
		System.out.println(getDb.get());
	}

	private static void testListSupplier() {
		System.out.println("---------------------ListSupplier test---------------------");
		Supplier<List<String>> getDbs = () -> List.of(
				"jdbc:mysql://localhost:3306/your-mama.db",
				"jdbc:mysql://localhost:3306/their-mum.db",
				"jdbc:mysql://localhost:3306/our-dad.db",
				"jdbc:mysql://localhost:3306/your-dad.db"
		);
		getDbs.get().forEach(System.out::println);
	}
}