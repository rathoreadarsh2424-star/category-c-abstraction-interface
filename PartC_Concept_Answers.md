# Part C — Concept Answers

## 1. Abstraction with a real-life example
A ride-booking app lets a passenger enter a destination and request a ride. The app shows the fare estimate, driver details, and trip status, while hiding internal tasks such as driver matching, route calculations, and payment processing. The user works with a simple set of actions without needing to know the implementation.

## 2. Abstraction vs encapsulation
Abstraction focuses on what an object does while hiding implementation details. Encapsulation protects internal data by restricting direct access and allowing controlled operations. A class can expose simple public methods as its abstraction while keeping fields private and validating changes inside those methods for encapsulation.

## 3. Why an abstract class can have a constructor
An abstract class cannot be instantiated directly, but its constructor initializes shared fields for subclasses. When a concrete subclass object is created, the abstract superclass constructor runs as part of the constructor chain before the subclass constructor finishes.

## 4. Why abstract methods cannot be private, static, or final
A private method is inaccessible to subclasses and cannot be implemented by overriding it. A static method belongs to the class and is hidden rather than dynamically overridden. A final method cannot be overridden. These restrictions conflict with an abstract method's requirement to be implemented by a concrete subclass.

## 5. The diamond problem
The diamond problem can occur when a class inherits the same method or state through multiple parent classes, making the selected implementation or inherited state ambiguous. Java permits only one direct superclass, avoiding multiple inheritance of class state. A class may implement multiple interfaces; if two interfaces provide conflicting default methods, the class must override the method to resolve the conflict.
