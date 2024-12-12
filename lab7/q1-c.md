# Q1

## C

The provided `removeDuplicates` method uses `containsKey()` on the HashMap of `Employee` objects to check for uniqueness.

**Hash Map Key Issue**: Since a `HashMap` uses the object's `hashCode()` and `equals()` methods to determine uniqueness for keys, it might not work as intended in this scenario. The reason being `Employee` class hasn't overriden the `hascode()` method. 