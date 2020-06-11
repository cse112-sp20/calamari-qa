# Calamari - QA 

Framework for testing Velocity Raptor chrome extension by CalamariCrew.

# Running tests

EITHER:   
- Use `mvn clean test` from root   
OR  
- Run the testng.xml file in the /ui module to run all tests

# Get Started 

- Clone the project through git
- With Intellij IDEA, hit import project from existing sources
- When prompted, select the pom.xml file in the root directory 
- After that, everything should be correctly set up.

* **NOTE** that if you are trying to test against a new version of the extension, you need the access token for the test github account and you need to modify the app code with that token before packing it into a crx and moving it the resources directory. 

# Libraries used:
- Selenide
- TestNG
- Maven 

