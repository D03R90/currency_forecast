package liga;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyRatePredication {

    /**
     * Приимает запрос из консоли от пользователя
     * Возвращает Карс на завтра или на неделю в зависимости от запроса
     */
    public void  currencyRate() {
        System.out.println("Введите запрос формата : rate EUR week/tomorrow");
        String input = new Scanner(System.in).nextLine();
        String currency = input.substring(5, 8);
        String period = input.substring(9);

        if (currency.equals("USD") || currency.equals("EUR") || currency.equals("TRY")) {
            double[] cost = FileReader.fileRead(currency);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate today = LocalDate.now();

            if (period.equals("tomorrow")) {
                LocalDate tomorrow = today.plusDays(1);
                String day = tomorrow.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.forLanguageTag("Ru"));
                double forecast = CurrencyPeriodTomorrow.forecastForDay(cost);
                System.out.print(day + " " + tomorrow.format(formatter) + " - " + String.format("%.2f", forecast));
            } else if (period.equals("week")) {
                double[] forecast = CurrencyPeriodWeek.forecastForWeek(cost);
                LocalDate[] weekDates = FunctionsProcessingData.processingWeek(today);
                String[] weekDays = FunctionsProcessingData.processingDays(weekDates);
                for (int i = 0; i < Constans.DAYS; i++) {
                    System.out.println(weekDays[i] + " " + weekDates[i].format(formatter) + " - " + String.format("%.2f", forecast[i]));
                }
            } else {
                System.out.print("Период для расчёта валюты указан не корректно");
            }
        } else {
            System.out.print("Данной валюты нет!");
        }
    }
}