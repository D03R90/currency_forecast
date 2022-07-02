package liga;
public class CurrencyPeriodWeek {
    /**
     * Обработка прогноза на 7 дней курсов валют из файла и возвращет их
     *
     * @param cost - входное значение карсов валют за 7 дней
     * @return последние 7 курсов валют номиналом 1
     */
    public static double[] forecastForWeek(double[] cost) {
        double[] costWeek = new double[Constans.DAYS];
        int counter = Constans.DAYS;
        for (int i = 0; i < Constans.DAYS; i++) {
            costWeek[i] = CurrencyPeriodTomorrow.forecastForDay(cost);
            cost[counter - 1] = costWeek[i];
            counter--;
        }
        return costWeek;
    }
}
