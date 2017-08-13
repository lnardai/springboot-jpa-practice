[![Build Status](https://travis-ci.org/lnardai/springboot-kotlin-practice.svg?branch=master)](https://travis-ci.org/lnardai/springboot-kotlin-practice)

# Springboot used with Kotlin 

Goal of this project is to try out different approaches to Spring boot with the new language features of Kotlin.
I've never used Kotlin before, so I'm happy to hear any suggestions.

### Unit tests

To run unit tests use gradle.
```
gradle clean test
```

###running application while development

To Hot deploying application start one process with continuous compilation (incubating phase):
```
gradle -t classes
```
Other process should start a Spring container
```
gradle bootRun
```