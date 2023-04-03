# API Test Suite

### Technology Stack
* Java
* RestAssured
* TestNG
* Maven
* Git

### How to execute locally
1. Maven 3.9.1 and Java 11 should be installed on Local environment.
2. TestNG xml files are located in `src/test/resources` directory. It can be executed directly via IDE.
3. Enabling `Default reporters` in Run/DEbug configuration Listeners testNG report can get generated.

### How to add tests to the test suite
1. Test Files are located in `src/test/java/nz/co/assurity/api` directory. 
2. Each test class should represent a single API end point.
3. `src/main/java/nz/co/assurity/api` directory includes utility and functional classes which are used in test methods.
4. New class should be added to the `functions` package for each API controller. Functional implementation for CRUD operation on same controller can be added on same class.
