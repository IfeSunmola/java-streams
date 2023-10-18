1. Check code for e.g.
2. Curly braces are optional for single statements. i.e.
   `Predicate<String> nameContainsIfe = (name) -> name.contains("Ife");`
3. https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html

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

---
