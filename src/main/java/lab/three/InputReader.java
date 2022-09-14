package lab.three;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader implements Closeable {
    private Scanner s = new Scanner(System.in);
    public int readUInt(String paramName) {
        int number;

        while (true) {
            System.out.print("Please enter " + paramName + ": ");
            number = s.nextInt();

            if (number > 0) break;

            System.out.println(paramName + " cant be negative value!");
        }
        return number;
    }

    public List<String> readStrings(String header) {
        var strings = new ArrayList<String>();

        System.out.println(header + ", one line is model name, type \"end\" to stop reading:");

        while (true){
            String input = s.nextLine();
            if (input.equals("end")) break;

            strings.add(input);
        }

        return strings;
    }

    @Override
    public void close() throws IOException {
        s.close();
    }
}
