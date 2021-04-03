#Test Doubles

Sometime ago I came across this article [The Little Mocker](https://blog.cleancoder.com/uncle-bob/2014/05/14/TheLittleMocker.html) 
by Robert C. Martin (Uncle Bob) and decide to what is in the article into practice.

There's a misconception about what is a Mock. What we call Mock in our day to day, is in fact Double Test.

Double Tests:
* **Dummy** - Object that are passed but in fact they're never used, reason why they return null values. 
* **Stub** - they facilitate testing by providing answers to calls. A good example is a logged in.  Part of a sistem will
  depend on it, but they're not important for some test. To avoid retesting it or to force a login which is slow, it simply
  return the state we want to simulate (logged in or not)
* **Spy** - Are in some sense Stub, but they record some information to be used later. For example, we can record how many
  users have logged in a system.
* **Mock** - are pre programed with expectation which form a specification of calls they are expected to receive.
* **Fake** - objects that have working implementations, but usually take some shortcut. An in memory database is an example.
