How to run this exercise
========================================

1. Create build folder: 
`mkdir build`

2. Build the exercise: 
`javac -cp lib/junit.jar -d build $(find ./src/* | grep .java)`

3. Run the exercise to calculate total unique ways: 
`java -cp src com.xeasony.Main`

4. Run testcases: 
`java -cp "build:lib/*" org.junit.runner.JUnitCore test.RobotTest`