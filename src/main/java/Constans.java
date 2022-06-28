public class Constans {
    /**
     * Констанда с колличесвтой дней
     *
     * @param cost - значение валюты
     */
    public static int CONST_DAYS = 7;

    /**
     * Подмена разделителя
     *
     * @param cost - значение валюты
     */
    public static double[] setDoubleCosts(String[] cost) {
        double[] costdouble = new double[cost.length];
        for (int i = 0; i < cost.length; i++) {
            costdouble[i] = Double.parseDouble(cost[i].substring(2, 9).replace(",", "."));
        }
        return costdouble;
    }
}
