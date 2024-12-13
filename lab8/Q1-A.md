# Q1 - A

## Code

```java
Runnable r = () -> {
    int[][] products = new int[s][t];
    for (int i = 0; i < s; i++) {
        for (int j = i + 1; j < t; j++) {
            products[i][j] = i * j;
        }
    }
};
```

### Parameters

In this case, it is empty `()`, meaning the lambda expression takes no parameters.
	
- Parameters: None

### Free Variables

 `s` and `t` are free variables because they are used within the lambda body but are not declared within it.

### Other variables 
`i`, `j`, and `products` are local variables declared within the lambda expression.
	

