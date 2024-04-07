## Prerequisites
- Java 21 

## Project Structure

This project is organized into several key directories:

- **Main Folder**
    - Contains the core application logic and entry points.
        - `ConfigLoader.java`: Loads configurations from `config.json`.
        - `BasketLoader.java`: Loads baskets data from `baskets.json`.
        - `BasketSplitter.java`: Main class for calculating delivery options, designed with readability in mind.

- **Resources Folder**
    - Houses JSON files necessary for the application's operation and testing.
        - `config.json`: Configuration settings.
        - `baskets.json`: Example basket data.

- **Test Folder**
    - Includes tests for all main classes, ensuring functionality works as expected.


## Using a .jar File in Your Project

To properly integrate a `.jar` file into your project, follow the steps below.

### Step 1: Add the .jar File to Your Project Directory

- **Place the .jar File**: Ensure the `.jar` file is within your project's directory, specifically within the `dir` folder of your project.

### Step 2: Include the .jar File as a Dependency

If you are using Maven to manage your project dependencies, include the `.jar` file as a dependency in your `pom.xml` file by adding the following lines:

```xml
<dependency>
    <groupId>com.supermarket</groupId>
    <artifactId>super_market</artifactId>
    <version>1.0-SNAPSHOT</version>
    <scope>system</scope>
    <systemPath>${project.basedir}/dir/super_market-1.0-SNAPSHOT-jar-with-dependencies.jar</systemPath>
</dependency>
