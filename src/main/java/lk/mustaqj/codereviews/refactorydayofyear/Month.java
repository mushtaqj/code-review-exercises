package lk.mustaqj.codereviews.refactorydayofyear;

import java.time.DateTimeException;

import com.google.common.base.Preconditions;

public enum Month
{
  JAN(1),
  FEB(2),
  MAR(3),
  APR(4),
  MAY(5),
  JUN(6),
  JUL(7),
  AUG(8),
  SEP(9),
  OCT(10),
  NOV(11),
  DEC(12);
  
  private final int index;
  private static final Month[] ENUMS = Month.values();

  Month (int monthIndex)
  {
    this.index = monthIndex;
  }

  //-----------------------------------------------------------------------
  /**
   * Obtains an instance of {@code Month} from an {@code int} value.
   * <p>
   * {@code Month} is an enum representing the 12 months of the year.
   * This factory allows the enum to be obtained from the {@code int} value.
   * The {@code int} value follows the ISO-8601 standard, from 1 (January) to 12 (December).
   *
   * @param month  the month-of-year to represent, from 1 (January) to 12 (December)
   * @return the month-of-year, not null
   */
  public static Month of(int month) {
    Preconditions.checkArgument(month > 0 && month < 13, "month should be between");
    return ENUMS[month];
  }

  public int getIndex ()
  {
    return index;
  }
}