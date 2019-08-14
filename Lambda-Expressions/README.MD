# Lambda Expressions
### Functional Interfaces

Some of the more commonly used interfaces include:
* **Predicate:** are Boolean valued functions of one argument.
* **Consumer:** accepts single argument with no return value.
* **Function:** it accepts one argument and produces a result.
* **Supplier:** Do not accept arguments and produces a result.
* **UnaryOperator:** single argument with a return value.
* **BinaryOperator:** takes two arguments and returns one.
    
**Remember**: Functional interfaces is an interface with only one method


### Collections
* **Set:** collections that does not contain duplicates
* **List:** ordered colletion
* **Map:** pairs key-value

### Streams
* Stream operations are either intermediate or terminal.
    * **Terminal operations:** return void or a type
    * **intermediate operations:** return stream itself.