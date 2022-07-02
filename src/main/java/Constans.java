public class Constans {

    /**
     * Константа для ограничения циклов одной неделей
     */
    public static int DAYS = 7;

    /**
     * Преобразование курсов валют из String в double
     *
     * @param cost - значение 7 валют
     * @return costdouble - массив с преобразованными значениями валюты
     */
    public static double[] setDoubleCosts(String[] cost) {
        double[] costdouble = new double[cost.length];
        for (int i = 0; i < cost.length; i++) {
            costdouble[i] = Double.parseDouble(cost[i].substring(2, 9).replace(",", "."));
        }
        return costdouble;
    }



}
