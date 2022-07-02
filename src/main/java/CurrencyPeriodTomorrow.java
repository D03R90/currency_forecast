import java.math.BigDecimal;

public class CurrencyPeriodTomorrow {
    /**
     * Обработка прогноза на 1 день
     *
     * @param cost - входное значение
     */
    public static double forecastForDay(double[] cost) {
        double sum = 0;
        for (double x : cost) {
            sum += x;
        }
        return sum / cost.length;
    }
}
