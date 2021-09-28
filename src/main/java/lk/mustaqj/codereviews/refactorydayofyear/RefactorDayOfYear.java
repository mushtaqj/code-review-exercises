package lk.mustaqj.codereviews.refactorydayofyear;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.stream.IntStream;

public class RefactorDayOfYear
{

  private static final int THIRTY_ONE_DAYS = 31;
  private static final int THIRTY_DAYS = 30;
  private static final int TWENTY_EIGHT_DAYS = 28;

  /**
   * @param month      {@link Month}
   * @param dayOfMonth should be between 1 and 31 or 30 depending on the month
   * @param year       should be the full year, giving 20 would assume the year is the year 20 AD not 20202
   * @return calculated day of the year adding/removing a day based on the leap year
   */
  public static int dayOfYear (final Month month, final int dayOfMonth, final int year)
  {
    final int maxDaysForMonth = getMaxDaysForMonth(month, year);

    checkArgument(dayOfMonth > 0, "dayOfMonth");
    checkArgument(year > 0, "year");
    checkArgument(dayOfMonth <= THIRTY_ONE_DAYS, "dayOfMonth");
    checkArgument(dayOfMonth >= maxDaysForMonth,
                  String.format("dayOfMonth for month %s should be not be greater than %d", month, maxDaysForMonth));

    final int lastCompletedMonthSum = IntStream.range(Month.JAN.getIndex(), month.getIndex()).map(monthIdx -> {

      return getMaxDaysForMonth(Month.of(monthIdx), year);
    }).reduce(0, Integer::sum);

    return lastCompletedMonthSum + dayOfMonth;
  }

  private static int getMaxDaysForMonth (Month month, int year)
  {
    final boolean isLeapYear = year % 4 == 0;
    final boolean isEvenMonth = month.getIndex() % 2 == 0;
    final int daysForMonth;

    if (month == Month.FEB)
    {
      daysForMonth = isLeapYear ? TWENTY_EIGHT_DAYS + 1 : TWENTY_EIGHT_DAYS;
    }
    else if (month.getIndex() < Month.AUG.getIndex())
    {
      daysForMonth = isEvenMonth ? THIRTY_DAYS : THIRTY_ONE_DAYS;
    }
    else
    {
      daysForMonth = isEvenMonth ? THIRTY_ONE_DAYS : THIRTY_DAYS;
    }

    return daysForMonth;
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