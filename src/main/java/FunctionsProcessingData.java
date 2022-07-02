import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class FunctionsProcessingData {
    /**
     * Функция для генерации массива из дат на CONST_DAYS дней начиная с завтрашней  даты
     *
     * @param today - дата в формате "2022-06-28"
     */
    static LocalDate[] processingWeek(LocalDate today) {
        LocalDate[] weekDates = new LocalDate[Constans.DAYS];
        for (int i = 0; i < Constans.DAYS; i++) {
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
     * @param week Запрос на обработку недели
     */public static String[] processingDays(LocalDate[] week) {
        String[] weekDays = new String[Constans.DAYS];
        for (int i = 0; i < Constans.DAYS; i++) {
            weekDays[i] = week[i].getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.forLanguageTag("Ru"));
        }
        return weekDays;
    }
}
