import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class FileReader {
    /**
     * Чтение файла по пути в соответствии с переданной валютой
     *
     * @param currency - переданный тип валюты
     * @return costNew - массив из преобразованных значений 7 последних курсов валюты
     */
    public static double[] fileRead(String currency) {

        String filePath = "src//main//resources//RC_F01_06_2002_T17_06_2022_" + currency + ".csv";

        BufferedReader reader = null;
        double[] costNew = new double[Constans.DAYS];
        try {
            String line;
            String[] cost = new String[Constans.DAYS];
            reader = new BufferedReader(new java.io.FileReader(filePath));

            for (int i = 0; i < 8; i++) {
                line = reader.readLine();
                if (i > 0) {
                    String[] row = line.split(";");
                    cost[i - 1] = row[2];
                }
            }
            costNew = Constans.setDoubleCosts(cost);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert reader != null;
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return costNew;
    }
}