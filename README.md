1. Check code for e.g.
2. Not really "functional". Hacky?
3. Curly braces are optional for single statements. i.e.
   `Predicate<String> nameContainsIfe = (name) -> name.contains("Ife");`
4. https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
5. `Runnable`: Takes nothing, returns nothing. Weird name ngl

---

1. **Predicate**:
    1. General idea: takes a value(s), and returns a boolean.
    2. The filter() method accepts a predicate to filter the stream and returns a new
       stream after applying the predicate.
    3. `Predicate<T>` -> Takes 1 arg, returns a boolean
    4. `BiPredicate<T, U>` -> Takes 2 args, returns a boolean
    5. `*PrimitiveWrapper*Predicate` -> Takes a primitive wrapper, returns a boolean
        1. E.g. DoublePredicate -> Takes a double, returns a boolean
        2. IntPredicate, LongPredicate

2. **Function**:
    1. General idea: takes a value(s), and returns a value.
    2. Different from Predicate in that it returns a value, not a boolean
    3. The map() method accepts a function to apply to each element of the stream. This method returns a
       new stream after applying the function to each element of the stream.
    4. `Function<T, R>` -> Takes argument of type T, returns a value of Type R
    5. `BiFunction<T, U, R>` -> Takes argument of type T and U, returns a value of Type R
    6. `*PrimitiveWrapper*Function<R>` -> Takes a primitive wrapper, returns a value of Type R

3. **Consumer**:
    1. General idea: Takes a value(s), do something, and returns nothing.
        1. I see it as it takes parameters, and ***consumes*** them
    2. The forEach() method helps in iterating over all elements of a stream and perform some operation on each of
       them. The operation to be performed is passed as a lambda expression parameter.
    3. `Consumer<T>` -> Takes argument of type T, returns nothing
    4. `BiConsumer<T, U>` -> Takes argument of type T and U, returns nothing
    5. `ObjDoubleConsumer<T>` -> Takes any object of type T and a double, returns nothing

4. **Supplier**:
    1. General idea: Takes nothing, and returns a value.
        1. It ***supplies*** a value
    2. `Supplier<T>` -> Takes nothing, returns a value of type T

5. **StreamsApplication**:
    1. Note: `()` are optional for single parameters
    2. If the operation is non-terminal, e.g. map(), filter(), sorted(), etc, a stream is returned
        1. Non-terminal: basically, it doesn't end the stream
    3. Terminal ends the stream. E.g. forEach(), toList(), findFirst(), etc
    4. Function Usage
        1. Below returns a stream of strings containing all the car makes
        2. .map() expects a `Function<T>`. See Function general idea
        3. Below, the "car" we passed is from testList.stream().
        4. `car -> car.make` is the Function, it takes a car, and returns the car's
           make (which is added to the `Stream` String)
        5.     Stream<String> carMakes = testList.stream()
                                  .map(car -> car.make);
    5. Predicate Usage
        1. Below returns a stream of cars that are Ford
        2. .filter() expects a `Predicate<T>`. See Predicate general idea
        3. `car -> car.make.equals("Ford")` is the Predicate, it takes a car, and returns a boolean.
           If true, the car is added to the `Stream` of cars, else take a guess
        4.     Stream<Car> fordVehicles = testList.stream()
                                  .filter(car -> car.make.equals("Ford"));

---
