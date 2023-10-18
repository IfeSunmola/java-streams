import java.util.function.*;

/**
 * @author Ife Sunmola
 */
class FunctionDemo {

	private record Student(String name, Double gpa) {} // test object

	public static void main(String[] args) {
		testFunction();
		testBiFunction();
		testDoubleFunction();
		testDoubleToIntFunction();
	}

	private static void testFunction() {
		System.out.println("---------------------Function test---------------------");
		// takes a student's name, returns student object
		Function<String, Student> createStudent = (studentName) -> new Student(studentName, 2.0);
		System.out.println("Creating John: " + createStudent.apply("John"));
	}

	private static void testBiFunction() {
		/*
		 takes 2 arguments, returns one value
		 Regular definition: BiFunction<String, Double, Student> createStudent = (name, gpa) -> new Student(name, gpa);
		 SAME AS
		 Method reference: BiFunction<String, Double, Student> createStudent = Student::new;
		 ---
		 Method reference explanation: In Student class, create an object with the String and Double passed
		 arguments. "new" literally calls the constructor so ORDER of arguments matter
		 BiFunction<Double, String, Student> will NOT Compile
		*/
		System.out.println("---------------------BiFunction test---------------------");
		BiFunction<String, Double, Student> createStudent = Student::new;

		System.out.println("Creating myself with gpa 5.0: " + createStudent.apply("Ife", 5.0));

	}

	private static void testDoubleFunction() {
		// Takes a double, returns a value
		System.out.println("---------------------DoubleFunction test---------------------");
		DoubleFunction<Student> createStudent = (gpa) -> new Student("Sally", gpa);

		System.out.println("Creating a student with gpa 3.5: " + createStudent.apply(3.5));
	}

	private static void testDoubleToIntFunction() {
		// Takes a double, returns an int
		System.out.println("---------------------DoubleToIntFunction test---------------------");
		DoubleToIntFunction truncateDecimal = (decimal) -> (int) decimal;

		System.out.println("Truncating 69.42: " + truncateDecimal.applyAsInt(69.42));
	}
}