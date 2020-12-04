import java.io.File;

public abstract class Rule {

  public abstract boolean check(String filename);

  public boolean validFile(String filename) {
    return new File(filename).exists();
  }

}
