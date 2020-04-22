import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class Problem10 {
	public static void main(String[] args) {
		String[] textArr = new String[5];
		int lost = 0;
		int lossPercentage = 0;
		String ping = "";
		ArrayList<Integer> speeds = new ArrayList<>();


		try {
			Scanner input = new Scanner(System.in);
            File file = new File("problem10.txt");
            input = new Scanner(file);

            int i = 0;
            while (input.hasNextLine()) {
                textArr[i] = input.nextLine();
                if (textArr[i].split(" ")[0].equals("ping")) {
                	ping = textArr[i].split(" ")[1];
                } else if (textArr[i].split(" ")[0].equals("Time")) {
                	lost++;
                	lossPercentage += 25;
                } else {
                	speeds.add(Integer.parseInt(textArr[i].split("=")[1]));
                }
                i++;
            }
            input.close();
		} catch (Exception ex) {}
		 

		System.out.println("Ping statistics for " + ping);
		System.out.println("Packets: Sent = 4 Received = " + (4-lost) + " Lost = " + lost + " (" + lossPercentage +"% loss)" );
		if (lost < 4) {
			int min = Collections.min(speeds);
			int max = Collections.max(speeds);
			System.out.println("Approximate round trip times:");
			System.out.println("Minimum = " + min + " Maximum = " + max +" Average = " + (max+min)/2);
		}


	}
}