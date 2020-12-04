public class App {
  public static void main(String[] args) {
    Rule pdfExtension = NameRule.get("pdf");
    Rule txtExtension = NameRule.get("txt");
    Rule size = SizeRule.get(2.5f, SizeRule.KB);
    Rule lastModified = ModifyRule.get(2020, 8, 1, 0, 0, 0);

    FileFinder ff = new FileFinder(System.getProperty("user.home") + "/Desktop");

    System.out.println("Found " + ff.getFiles().size() + " file(s).");

    ff.filter.or(pdfExtension, txtExtension).and(size, lastModified);

    System.out.println(ff.getFiles());
    System.out.println("Filtered to " + ff.getFiles().size() + " file(s).");
  }
}
