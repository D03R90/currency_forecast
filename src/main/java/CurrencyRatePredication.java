import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

public class CurrencyRatePredication {

    /**
     * Считывает последние 7 курсов из файла валют и возвращет их
     * "rate TRY tomorrow" Пн 22.02.2022 - 6,11;
     * "rate USD week"
     * @param args - валюта, например = USD, TRY,EUR
     * @return последние 7 курсов валют номиналом 1
     */
    public static void main(String[] args) {

        System.out.print("Enter request: ");
        String input = new Scanner(System.in).nextLine();

        String currency = input.substring(5, 8);
        String period = input.substring(9);

        if (currency.equals("USD") || currency.equals("EUR") || currency.equals("TRY")) {
            double[] cost = FileReader.fileRead(currency);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate today = LocalDate.now();

            HashMap<String, String> translit = new HashMap<>();

            translit.put("MONDAY", "Пн");
            translit.put("TUESDAY", "Вт");
            translit.put("WEDNESDAY", "Ср");
            translit.put("THURSDAY", "Чт");
            translit.put("FRIDAY", "Пт");
            translit.put("SATURDAY", "Сб");
            translit.put("SUNDAY", "Вс");

            if (period.equals("tomorrow")) {
                LocalDate tomorrow = today.plusDays(1);
                DayOfWeek day = tomorrow.getDayOfWeek();
                double forecast = forecastDays(cost);

                System.out.print(translit.get(day.toString()) + " " + tomorrow.format(formatter) + " - " + String.format("%.2f", forecast));
            } else if (period.equals("week")) {
                double[] forecast = forecastWeek(cost);
                LocalDate[] weekDates = processingWeek(today);
                DayOfWeek[] weekDays = processingDays(weekDates);
                for (int i = 0; i < Constans.CONST_DAYS; i++) {
                    System.out.println(translit.get(weekDays[i].toString()) + " " + weekDates[i].format(formatter) + " - " + String.format("%.2f", forecast[i]));
                }
            }
        } else {
            System.out.print("Данной валюты нет!");
        }
    }

        /**
         * Обработка прогноза на 1 день
         *
         * @param cost - входное значение
         */
        public static double forecastDays(double[] cost) {
            double sum = 0;
            for (double x : cost) {
                sum += x;
            }
            return sum / cost.length;
        }

        /**
         * Обработка прогноза на неделю
         *
         * @param cost - входное значение
         */
        public static double[] forecastWeek(double[] cost) {
            double[] costWeek = new double[Constans.CONST_DAYS];
            int counter = Constans.CONST_DAYS;
            for (int i = 0; i < Constans.CONST_DAYS; i++) {
                costWeek[i] = forecastDays(cost);
                cost[counter - 1] = costWeek[i];
                counter--;
            }
            return costWeek;
        }

    /**
     * Функция для генерации массива из дат на CONST_DAYS дней начиная с завтрашней  даты
     *
     * @param today - дата в формате "2022-06-28"
     */
    public static LocalDate[] processingWeek(LocalDate today) {
        LocalDate[] weekDates = new LocalDate[Constans.CONST_DAYS];
        for (int i = 0; i < Constans.CONST_DAYS; i++) {
            if (i == 0) {
                weekDates[i] = today.plusDays(1);
            } else {
                weekDates[i] = weekDates[i - 1].plusDays(1);
            }
        }
        return weekDates;
    }
    /**
     * Функция для получения массива Дней недели
     *
     * @param week
     */
    public static DayOfWeek[] processingDays(LocalDate[] week) {
        DayOfWeek[] weekDays = new DayOfWeek[Constans.CONST_DAYS];
        for (int i = 0; i < Constans.CONST_DAYS; i++) {
            weekDays[i] = week[i].getDayOfWeek();
        }
        return weekDays;
    }
}