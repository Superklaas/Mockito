# Mockito

BENEFITS MOCKS & STUBS
fake Java objects that replace external dependencies, e.g. web service or database
- test doesn’t fail if third party system is down
- test is repeatable if data in database changes
- test doesn’t change important data, e.g. connection with payment provider

MOCKITO METHODS

Database database = mock(Database.class)
instantiates mock
possible with annotations as well
@ExtendWith(MockitoExtension.class) before test class
@Mock: mock data
@InjectMock: object that will use mock data

ArrayList arrayList = spy(ArrayList.class)
instantiates spy
spy object behaves like normal object, until mock method is called upon it
good compromis between object and mock
for if you want to use normal methods and mock methods (when-then, verify) on the same object

stubs: test data
when(database.lookup(params)).thenReturn(return-value)
tell test what to return when mock is called (“put data in mock database”)
- return value: single or multiple (call several times)
- params
    - specific e.g. one item from an arraylist
    - generic e.g. anyInt()

mocks: test behaviour
verify(database, times(?)).lookup(params)
check if method is called
- times() : times(1), times(0), never(), atLeast(7), …
- params 
    - specific
    - generic: e.g. anyString(), any(Book.class), atLeast(2), atMost(5), never()
