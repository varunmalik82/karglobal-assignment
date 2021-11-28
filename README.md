### Set up

make sure `Java`, `maven` and latest `chrome/firefox` browser is installed on local machine,
Once you have downloaded or cloned the repo you are all set to run the tests

### Run test suite
```cli
# default execution set for chrome browser
 mvn clean test
```

```cli
# execution on specific browser
mvn clean test -Dbrowser=firefox
mvn clean test -Dbrowser=chrome
```

```cli
# tested browser version  (latest)
chrome - Version 96.0.4664.55 (Official Build) (x86_64)
firefox - 94.0.2 (64-bit)
```

### Report
after first execution of tests `.allure` & `target` folder will created at the root of project. You can browse the html report by executing the following command on CLI
```cli
mvn io.qameta.allure:allure-maven:serve
```

### logs
test execution logs are logged at the root of the project `log4j-application.log`

### Test Execution images

![Screenshot 2021-11-27 at 9 44 55 PM](https://user-images.githubusercontent.com/17876410/143727159-8485c62d-070a-4542-982e-2af2656e4342.png)


