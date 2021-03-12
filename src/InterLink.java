import java.io.*;
import java.util.ArrayList;

public class InterLink {


    public static void main(String[] args) throws IOException {
        //Путь до файлу
        String fileRead = "resources\\acme_worksheet.csv";
        FileWriter pw = new FileWriter("resources\\out\\data.csv", true);
        BufferedReader reader = null;
        String line;
        ArrayList<String> employee = new ArrayList<>();
        ArrayList<String> dates = new ArrayList<>();
        ArrayList<String> hours = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(fileRead));

            while((line = reader.readLine()) != null){
                DateFormater dateFormater = new DateFormater();
                String[] row = line.split(",");
                employee.add(row[0]);
                String[] date = row[1].split(" ");

                if(date[0].length() != 3){
                    dates.add(date[0]);
                }
                else{
                    String finalDate = "";
                    finalDate += (date[2]);
                    finalDate += ("-");
                    finalDate += (dateFormater.DateForm(date[0]));
                    finalDate += ("-");
                    finalDate += (date[1]);
                    dates.add(finalDate);
                }

                hours.add(row[2]);

            }
            pw.write(employee.toString());
            pw.write("\n");
            pw.write(dates.toString());
            pw.write("\n");
            pw.write(hours.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reader.close();
            pw.flush();
            pw.close();
        }
    }
}