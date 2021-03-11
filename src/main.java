import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;

public class main {


    public static void main(String[] args) throws IOException {
        //Путь до файлу
        String fileRead = "resources\\acme_worksheet.csv";
        Path fileWrite = FileSystems.getDefault().getPath("resources", "acme_worksheet_new.csv");

        BufferedReader reader = null;
        BufferedReader writer = null;
        String oneLine = "";
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(fileRead));

            while((line = reader.readLine()) != null){
                String[] row = line.split(",");
                for(String index : row){
                    System.out.printf("%-20s", index);

                }
                //Переносы
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }

    }
}