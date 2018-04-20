# spek-junit-rules

This library provides limited support for JUnit 4 rules within Spek.
Currently, this support is limited to subclasses of the ```org.junit.rules.ExternalResource```
rules of JUnit 4.

Please note that a general support for arbitrary ```org.junit.rules.TestRule```
implementations is not possible within the Spek model.

The main purpose of this library is to provide users with a way
to use JUnit rules in Spek because they need to. A good use case is
having existing JUnit rules that cannot be easily re-written.