import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FileFinder {
  private File directory;
  private List<String> files;
  public final RuleEngine filter;

  public FileFinder(String directory) {
    this.directory = new File(directory);

    files = new ArrayList<>();
    find();

    filter = new RuleEngine(files);
  }

  public List<String> getFiles() {
    return this.files;
  }

  public void find() {
    Stack<String> directories = new Stack<>();

    if (!directory.isDirectory()) {
      this.files = new ArrayList<>();
      return;
    }

    directories.add(directory.getAbsolutePath());

    while (!directories.isEmpty()) {
      File currentDirectory = new File(directories.pop());
      for (String file : currentDirectory.list()) {
        File currentFile = new File(currentDirectory.getAbsolutePath(), file);
        if (currentFile.isDirectory()) {
          directories.add(currentFile.getAbsolutePath());
        } else {
          files.add(currentFile.getAbsolutePath());
        }
      }
    }
  }
}
