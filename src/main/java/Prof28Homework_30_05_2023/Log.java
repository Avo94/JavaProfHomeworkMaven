package Prof28Homework_30_05_2023;

import java.io.FileWriter;
import java.io.IOException;
import java.util.GregorianCalendar;

import static Prof28Homework_30_05_2023.FlightApp.*;

public class Log implements Runnable {

    @Override
    public void run() {
        FileWriter txtFile = null;
        try {
            txtFile = new FileWriter(path, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            if (counter == 0) {
                try {
                    txtFile.write(new GregorianCalendar().getTime() + " \"" + log + "\"\n");
                    txtFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                counter++;
            }
        }
    }
}