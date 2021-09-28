package lk.mustaqj.codereviews.refactordayofyear;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lk.mustaqj.codereviews.refactorydayofyear.RefactorDayOfYear;
import org.junit.jupiter.api.Test;

class RefactorDayOfYearTest
{
  private static final int LEAP_YEARS_DAYS_IN_YEAR = 366;
  private static final int THIRTY_ONE_DAYS = 31;
  private static final int THIRTY_DAYS = 30;
  private static final int TWENTY_EIGHT_DAYS = 28;

  @Test
  void whenGivenALeapYear_shouldReturnDayOfYearAs366 ()
  {
    final int actualDayOfYear = RefactorDayOfYear.dayOfYear(12, 31, 2020);

    assertEquals(actualDayOfYear, LEAP_YEARS_DAYS_IN_YEAR);
  }

  @Test
  void whenGivenANonLeapYear_shouldReturnDayOfYearAs366 ()
  {
    final int actualDayOfYear = RefactorDayOfYear.dayOfYear(12, 31, 2021);

    assertEquals(actualDayOfYear, LEAP_YEARS_DAYS_IN_YEAR - 1);
  }

  @Test
  void whenGivenALeapYear_februaryShouldReturn29Days ()
  {
    @SuppressWarnings("UnnecessaryLocalVariable")
    final int daysInJanuary = THIRTY_ONE_DAYS;
    final int actualDayInFebForLeapYear = RefactorDayOfYear.dayOfYear(2, 29, 2020) - daysInJanuary ;

    assertEquals(actualDayInFebForLeapYear, TWENTY_EIGHT_DAYS + 1);
  }

  @Test
  void whenGivenANonLeapYear_februaryShouldReturn28Days ()
  {
    @SuppressWarnings("UnnecessaryLocalVariable")
    final int daysInJanuary = THIRTY_ONE_DAYS;
    final int actualDayInFebForLeapYear = RefactorDayOfYear.dayOfYear(2, 28, 2021) - daysInJanuary ;

    assertEquals(actualDayInFebForLeapYear, TWENTY_EIGHT_DAYS);
  }
}