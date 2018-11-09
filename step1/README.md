# Step 1

Start with a gradle init

    gradle init

This will create a new gradle project with nothing else in it.

## Gradle Config
Update your settings.gradle with some plugin config so our project knows how to load gradle plugins:

```gradle
pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
}
```

Update your build.gradle with some java stuff

```gradle
// buildscript has to go at the top of the file, it configures gradle itself
buildscript {
    repositories {
        mavenLocal()
    }
}

// Start with a java-library plugin, we are building a jar file
plugins {
    id "java-library"
    id "application"
}

// Add a local and remote repository to fetch dependencies from
repositories {
    mavenLocal()
    jcenter()
}

// For easier testing, let's add a mainClassName
mainClassName = 'frc.robot.Robot'
```

## Add some code

Right click on your folder and select New Folder to add a new package folder:

    src/main/java/frc/robot

Right click on the newly created robot/ folder and add a new file named Robot.java

### Barebones Robot.java

```java
package frc.robot;

public class Robot {
    public static void main(String[] args) {
        System.out.println("Hello, Robot");
    }
}
```

## Test it!

```
    gradle run

    > Task :run
    Hello, Robot

    BUILD SUCCESSFUL in 0s
    2 actionable tasks: 2 executed
```
