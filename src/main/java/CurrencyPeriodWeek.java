public class CurrencyPeriodWeek {
    /**
     * Обработка прогноза на неделю
     *
     * @param cost - входное значение
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
