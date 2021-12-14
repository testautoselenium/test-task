## Configuration

Before test execution rename config file `src\test\resources\config.properties.example` to `src\test\resources\config.properties` 
and set values email and password of a test account.

## Test execution

To run tests use command:

```shell
gradle clean test
```

To generate Allure report use command:

```shell
allure serve build/allure-results
```