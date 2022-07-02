package liga;

public class CurrencyPeriodTomorrow {
    /**
     * Обработка прогноза курса переданной валюты на завтра
     *
     * @param cost - входное значение карсов валют за 7 дней
     * @return Срендий курс валюты за неделю
     */
    public static double forecastForDay(double[] cost) {
        double sum = 0;
        for (double x : cost) {
            sum += x;
        }
        return sum / cost.length;
    }
}
