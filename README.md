# Xplor Coding Challenge (Java)

**Ismael J Lopez - ismaelopezandrade@gmail.com**

## Overview
Developing in Java having just come from C# gave a bit of whiplash, but
eventually I started remembering how this all works. Coding with SOLID
principles in mind was a fun challenge, and I am sure I could have
done a few things better.

## SOLID
I tried to adhere to the SOLID principles as well as I could. 

### Single Responsibility Principle
`Card` and its subtypes are largely responsible for validating
input, holding its values, and providing an interface to access/modify
those values. I separated out interest calculation into a separate
class `SimpleInterestCalculator` that implements the `InterestCalculator`
interface. This allowed each class to have a single responsibility
while also allowing future interest calculators to be easily added and used
interchangeably.

### Open Closed Principle
Class methods remain small in scope, spanning few lines. I think for
validating card characteristics, it is hard to do so without ever modifying
the logic since rules could change - a credit card could obtain another
range of valid digits for instance. Allowing the interest rate to be
initially set and modified means no changing of the class when Visa
decides to change their rates.

### Liskov Substitution Principle
Given the `Card` subtypes do not implement any more public methods that
the base type does not, I would say they are substitutable. However, since
`Card` is an `abstract` class, you can't really instantiate one anyway.

### Interface Segregation Principle
I admit I tend to run wild implementing various _convenient_ methods. But
I asked myself if anyone was really _asking_ for it, and upon answering no,
skimmed things down to the essential.

### Dependency Inversion
Given a `Person` holds numerous `Wallet` objects which subsequently hold
numerous `Card` objects, it became clear this was a moment where I could
allow for any type of collection rather than enforcing (and thus coupling)
a single one. Thus, I relied on the `Collection<T>` interface rather than 
requiring an implementation, such as `ArrayList<T>`. I am a little better
at this in C# currently, and would not be surprised if there is a better
interface to use, but I chose this one because the order does not matter
and whichever implementation used need only provide simple methods such
as `add` and `remove`.

However, default constructors are opinionated at the caller's own peril

## How to Run
I used OpenJDK 19.0.2 and JUNIT4 (v4.13.2). I ran the unit tests from 
IntelliJ IDEA using the **Run 'All Tests'** button. Terminal output shows the 
executed command is as follows (for what it is worth):
```
C:\Users\under\.jdks\openjdk-19.0.2\bin\java.exe -ea -Didea.test.cyclic.buffer.size=1048576 "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.3.2\lib\idea_rt.jar=50438:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.3.2\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.3.2\lib\idea_rt.jar;C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.3.2\plugins\junit\lib\junit5-rt.jar;C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.3.2\plugins\junit\lib\junit-rt.jar;C:\Users\under\Source\XplorCodingChallenge\out\test\XplorCodingChallenge;C:\Users\under\Source\XplorCodingChallenge\out\production\XplorCodingChallenge;C:\Users\under\.m2\repository\junit\junit\4.13.2\junit-4.13.2.jar;C:\Users\under\.m2\repository\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar" com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit4 UnitTests
```
```