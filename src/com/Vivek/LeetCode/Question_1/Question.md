## Delete Nodes Greater Than X

In this challenge, you will be given a singly-linked list of integers and a single integer to compare to. You must remove any values greater than that integer value while maintaining the integrity and order of the list. You will return a pointer to the head of the new list.

### Function Description

Write a function `removeNodes` that returns a reference to the root node of your list.

**Parameters:**

- `listHead`: A reference to the root node of the singly-linked list.
- `x`: An integer, the maximum value to be included in the new list.

### Constraints

- `1 ≤ n, x ≤ 10^5`
- `1 ≤ Linked list node values ≤ 10^5`

### Example

**Sample Input:**

`n = 5`

`x = 3`

`1 2 3 4 5 3`

**Sample Output:**
`1 2 3 `

## SQL Question

A company maintains the data of its employees in their EMPLOYEE table. Write a query to print all pairs of employee names where the salary of the first employee is less than the salary of the second employee.
Sort the output by the increasing order of first employee's ID and second employee's salary.
Each row in the output must contain:
1. The name of the first employee
2. The name of the second employee, whose salary is more than the salary of the first employee


