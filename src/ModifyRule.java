import java.io.File;
import java.util.Calendar;

public class ModifyRule extends Rule {

  private Calendar calendar;

  public static Rule get(int year, int month, int day, int hours, int minutes, int seconds) {
    Calendar cal = Calendar.getInstance();
    cal.set(year, month - 1, day, hours, minutes, seconds);
    return new ModifyRule(cal);
  }

  public ModifyRule(Calendar calendar) {
    this.calendar = calendar;
  }

  public boolean check(String file) {
    return check(file, calendar);
  }

  public boolean check(String filename, Calendar calendar) {
    File file = new File(filename);
    if (validFile(filename)) {
      return file.lastModified() > calendar.getTimeInMillis();
    }
    return false;
  }

}
