# Q1

## D

The issue with the original `removeDuplicates()` method stemmed from an incorrect implementation of the `equals()` and `hashCode()` methods in the `Employee` class.

### `equals` & `hasCode` Method

*   **Problem:** The overriden `equals()` & `hasCode()` methods included the `visited` field in its comparison logic.
*   **Why this is wrong:** The `visited` field is intended for internal use within the `removeDuplicates` method to track which employees have already been processed. It represents a transient state during the duplicate removal process. The `visited` status of an employee should *not* determine whether two employees are considered the same for the purpose of identifying duplicates. Two employees with the same name and salary are duplicates regardless of whether they have been "visited" during the process.


**In summary:** The `visited` field should be used for internal tracking within the `removeDuplicates` logic but should *not* be part of the definition of equality for `Employee` objects. Therefore, it should be excluded from both the `equals` and `hashCode` methods.