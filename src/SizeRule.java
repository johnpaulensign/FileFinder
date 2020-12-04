import java.io.File;

public class SizeRule extends Rule {

  private float size;

  public static final int B = 1;
  public static final int KB = 1000;
  public static final int MB = 1000000;

  public static Rule get(float size) {
    return new SizeRule(size);
  }

  public static Rule get(float size, int scale) {
    return new SizeRule(size * scale);
  }

  public SizeRule(float size) {
    this.size = size;
  }

  public boolean check(String file) {
    return check(file, size);
  }

  public boolean check(String filename, float size) {
    File file = new File(filename);
    if (validFile(filename)) {
      return file.length() > size;
    }
    return false;
  }

}
