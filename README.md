# Mockito

BENEFITS UNIT TESTING & TDD
Start from functionality & expected results to write code
- first think which results should the program generate 
- expected result should be known beforehand
Possible to verify functionality code on ongoing basis
- No need to try out code in main method & delete it afterwards
- Make changes along the way and check impact by rerunning tests

TEST DRIVEN DEVELOPMENT (TDD)
tests drive the code writing
1. red: framework test —> AssertionFailedError
    1. annotation
    2. title
    3. fail()
2. red: write test —> AssertionFailedError (expected != actual)
    1. instantiate objects
    2. define actual value (execute tested method on object)
    3. (optional) define expected value
    4. assertion: actual vs expected
3. green: write code
4. refactor: make code more readable (adding methods, variables etc)

STRUCTURE TEST CASE
test case = class in directory ‘test’ with unit tests, linked to an existing class in directory ‘main’ in same project
title test case: [The name of the tested class]Test
declaration repeatedly used variables
conditions that should be evaluated before and after each test case (expensive resources)
	@BeforeAll: static setUpBeforeClass()
	@AfterAll: static tearDownAfterClass()
conditions that should be evaluated before and after each unit test
	@BeforeEach: setUp()
	@AfterEach: tearDown()

ANNOTATION: which type of test?
@Test
@ParameterizedTest (name = "{0} length is {1}")
	@ValueSource: single test data (only input)
	@CsvSource (comma separated values): multiple test data (input & output)
	@EnumSource	
@RepeatedTest: : repeat same test multiple times
@Nested: nested testcase (subcalss) with tests related to a certain context (e.g. empty strings, large strings)

OPTIONAL ANNOTATIONS
@Enabled: e.g. select operating system on which test should run (@EnabledOnOs)
@DisplayName: what does test do? 
- cf. comment Java: makes it more readable
- option to name tests in a clear way, e.g. using questions
@Disabled

NAME TEST METHOD
return type void
3 possible types of naming
1. [the name of the tested feature]_[expected input / tested state]_[expected behavior]
2. what the test does
3. minimal name in method, specify with question in @DisplayName

STRUCTURE UNIT TEST
- instantiate objects (if this didn’t happen yet in @BeforeEach)
- define actual value (execute tested method on object)
- assertion: compare actual value to expected value 

WHICH TESTS SHOULD YOU WRITE?
find out by asking the 4 following questions
—> results in 9 tests to be written for validating an ISBN
1. What should the logic be?
    1. valid 10 digit isbn
    2. valid 13 digit isbn
2. What is the opposite of that logic?
    1. invalid 10 digit isbn, only numbers
    2. invalid 13 digit isbn, only numbers
3. Are there any edge cases?
    1. valid 10 digit isbn with X
    2. invalid 10 digit isbn with X
4. Are there any error conditions?
    1. invalid 10 digit isbn not numeric
    2. invalid 13 digit isbn not numeric
    3. isbn with length not 10 or 13

ASSERTIONS
function used in a unit test that verifies the behavior of the system under test
syntax: 1) expected value, 2) actual value, 3) message if failure

1. Asserting equality (cf. ‘equals’ in Java)
    - assertEquals()
    - assertNotEquals()
    - assertArrayEquals()
2. Asserting boolean expressions
    - assertTrue()
    - assertFalse()
3. Asserting identity objects (cf. == in Java)
    - assertSame()
    - assertNotSame()
4. Asserting empty or non-empty objects
    - assertNull()
    - assertNotNull()
5. Check if expected exception is thrown
    - assertThrows
6. Performance test
    - assertTimeOut (parameter duration, executable)

ASSUMPTIONS
context guarantees, conditions to be fulfilled before test can be run
- assumeTrue, assumeFalse
- assumingThat: if boolean condition is true, execute specified method

TESTING RESTFUL SERVICES
web layer = mvc (controller!)	—>	Spring Mock MVC framework
business layer = service			—>	Mockito
data layer	 = repository = dao	—>	DataJPA tests

