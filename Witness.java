import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Witness extends Command {

    public Witness() {
        startorall = true;
        trigger = ".witness ";
		name = "Witness";
		description = "Uhh, it does something?";
    }

    public String Execute(String channel, String sender, String login, String hostname, String message) {
		String time = new java.util.Date().toString();
		String witness = "Witness: " + time + " <" + sender + "> " + message.substring(8) + "\r\n";
		
		try {
		FileWriter fileWritter = new FileWriter("WitnessLog.txt",true);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(witness);
			bufferWritter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "Mediocre!";
    }
}