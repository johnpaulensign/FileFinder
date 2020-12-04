import java.io.File;

public class NameRule extends Rule {

  private String name;

  public static Rule get(String name) {
    return new NameRule(name);
  }

  public NameRule(String name) {
    this.name = name;
  }

  public boolean check(String filename) {
    return check(filename, name);
  }

  public boolean check(String filename, String name) {
    if (validFile(filename)) {
      return new File(filename).getAbsolutePath().contains(name);
    }
    return false;
  }

}
