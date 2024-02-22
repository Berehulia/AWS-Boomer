package team.boomer;

import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.Optional;

@Command(name = "aws-boomer", mixinStandardHelpOptions = true, version = "aws-boomer 1.0",
        description = "aws-boomer CLI tool")
public class Application implements Runnable {

  @CommandLine.Option(names = {"-f"}, description = "Your first name")
  private String firstName;

  @CommandLine.Option(names = {"-s"}, description = "Your second name")
  private String secondName;

  @Override
  public void run() { // your business logic goes here...
    System.out.println("Hello " + firstName + " "+ secondName);

    // get value from environment
    String prop = Optional.ofNullable(System.getenv("MY_PROP"))
            .orElse("Test prop value");

    System.out.println("Your prop value: " + prop);
  }

  public static void main(String... args) {
    int exitCode = new CommandLine(new Application()).execute(args);
    System.exit(exitCode);
  }
}