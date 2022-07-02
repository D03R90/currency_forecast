package liga;
/**
 * Запускает метод для проноза валюты в зависимости от указанного значения
 * Примеры команд
 * "rate TRY tomorrow" Пн 22.02.2022 - 6,11;
 * "rate USD week"
 */

public class MainLaunch {
    public static void main(String[] args) {
        CurrencyRatePredication currencyRatePredication = new CurrencyRatePredication();
        currencyRatePredication.currencyRate();
    }
}
