package lk.mustaqj.codereviews.refactorydayofyear;

import java.util.stream.IntStream;

public class RefactorDayOfYear
{
  private static final int THIRTY_ONE_DAYS = 31;
  private static final int THIRTY_DAYS = 30;
  private static final int TWENTY_EIGHT_DAYS = 28;
  private static final int FEBRUARY = 2;

  public static int dayOfYear (final int month, final int dayOfMonth, final int year)
  {
    // TODO - Add validation for max days for month
    // TODO - Add validation for min days for month
    // TODO - Month min max validation
    // TODO - Year min validation
    // TODO - Leap year validation

    final boolean isLeapYear = year % 4 == 0;

    final int lastCompletedMonthSum = IntStream.range(1, month).map(monthIdx -> {

      final boolean isEvenMonth = monthIdx % 2 == 0;

      if (monthIdx == FEBRUARY)
      {
        return isLeapYear ? TWENTY_EIGHT_DAYS + 1 : TWENTY_EIGHT_DAYS;
      }

      if (monthIdx < 8)
      {
        return isEvenMonth ? THIRTY_DAYS : THIRTY_ONE_DAYS;
      }

      return isEvenMonth ? THIRTY_ONE_DAYS : THIRTY_DAYS;
    }).reduce(0, Integer::sum);

    return lastCompletedMonthSum + dayOfMonth;
  }

  public static int dayOfYearLegacy (int month, int dayOfMonth, int year)
  {
    if (month == 2)
    {
      dayOfMonth += 31;
    }
    else if (month == 3)
    {
      dayOfMonth += 59;
    }
    else if (month == 4)
    {
      dayOfMonth += 90;
    }
    else if (month == 5)
    {
      dayOfMonth += 31 + 28 + 31 + 30;
    }
    else if (month == 6)
    {
      dayOfMonth += 31 + 28 + 31 + 30 + 31;
    }
    else if (month == 7)
    {
      dayOfMonth += 31 + 28 + 31 + 30 + 31 + 30;
    }
    else if (month == 8)
    {
      dayOfMonth += 31 + 28 + 31 + 30 + 31 + 30 + 31;
    }
    else if (month == 9)
    {
      dayOfMonth += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
    }
    else if (month == 10)
    {
      dayOfMonth += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
    }
    else if (month == 11)
    {
      dayOfMonth += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
    }
    else if (month == 12)
    {
      dayOfMonth += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 31;
    }
    return dayOfMonth;
  }

  private static void printDayOfYear (int dayOfYear)
  {
    System.out.print("\t Day Of The Year : " + dayOfYear + "\n");
  }
}