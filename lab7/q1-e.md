# 1. When the type D is a class:

**Challenge**: Direct multiple inheritance for classes is not supported in Java.

**Solution**:
- Use default methods in interfaces.
- Create an interface (e.g., InterfaceA) with a default implementation for the ambiguous method (e.g., method()).
- Classes B and C inherit from InterfaceA.
- Class D inherits from both B and C.
- If D doesn't provide its own method() implementation, it inherits the default from InterfaceA, resolving the ambiguity.

# 2. When the type D is an interface:
- Solution: Multiple inheritance is allowed for interfaces.
- Ambiguity Resolution: If B and C have conflicting default implementations for method(), interface D must provide its own implementation to resolve the ambiguity.
