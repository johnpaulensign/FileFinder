import java.util.ArrayList;
import java.util.List;

public class RuleEngine {
  List<String> files;

  public RuleEngine() {
  }

  public RuleEngine(List<String> files) {
    this.files = files;
  }

  public RuleEngine and(Rule... rules) {
    ArrayList<String> filteredFiles = new ArrayList<>();
    for (Rule rule : rules) {
      for (String filename : files) {
        if (!rule.check(filename)) {
          filteredFiles.add(filename);
        }
      }
    }
    for (String filename : filteredFiles) {
      files.remove(filename);
    }
    return new RuleEngine(files);
  }

  public RuleEngine or(Rule... rules) {

    ArrayList<String> filteredFiles = new ArrayList<>();

    for (Rule rule : rules) {

      for (String filename : files) {
        if (rule.check(filename)) {
          filteredFiles.add(filename);
        }
      }
    }

    files.clear();

    for (String filename : filteredFiles) {
      files.add(filename);
    }
    return new RuleEngine(files);
  };

  public RuleEngine not(Rule... rules) throws Exception {
    throw new Exception("The 'not' rule has not been implemented");
  }

  public List<String> get() {
    return this.files;
  }

  public ArrayList<String> check(ArrayList<String> files, Rule rule) {
    ArrayList<String> filteredFiles = new ArrayList<>();

    for (String filename : files) {
      if (rule.check(filename)) {
        filteredFiles.add(filename);
      }
    }
    return filteredFiles;
  }
}
