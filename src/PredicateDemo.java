import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.Predicate;

/**
 * @author Ife Sunmola
 */
class PredicateDemo {
	private record Account(String name, int id) {} // object for test

	public static void main(String[] args) {
		predicate();
		testBiPredicate();
		testDoublePredicate();
	}

	private static void predicate() {
		// takes any object, string in this case, returns true or false.
		// Should be inside curly braces but oneliners don't need it
		System.out.println("---------------------Predicate test---------------------");
		Predicate<String> nameContainsIfe = (name) -> name.contains("Ife");
		System.out.println("Ife contains Ife (true): " + nameContainsIfe.test("Ife"));
		System.out.println("Jonah contains Ife (false): " + nameContainsIfe.test("Jonah"));
	}

	private static void testBiPredicate() {
		// Takes a String and Account object, returns boolean
		System.out.println("---------------------BiPredicate test---------------------");
		BiPredicate<String, Account> nameMatchesAccount = (name, account) -> name.equals(account.name);
		Account testAccount = new Account("Ife", 1);
		System.out.println("Account: " + testAccount);

		System.out.println("'Ife' is the correct account name (true): " + nameMatchesAccount.test("Ife", testAccount));
		System.out.println("'Jonah' is the correct account name (false): " + nameMatchesAccount.test("Jonah", testAccount));
	}

	private static void testDoublePredicate() {
		// IntPredicate, LongPredicate, DoublePredicate
		// Takes a double, returns boolean.
		System.out.println("---------------------DoublePredicate test---------------------");
		DoublePredicate isGreaterThan10 = (doubleNumber) -> doubleNumber > 10;
		System.out.println("Is 20 greater than 10 (true): " + isGreaterThan10.test(20));
		System.out.println("Is 5 greater than 10 (false): " + isGreaterThan10.test(5));
	}
}