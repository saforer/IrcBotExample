import org.jibble.pircbot.*;
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class MyBot extends PircBot {
    List<Command> commandList = new ArrayList<Command>();
	File witnessLog;

    public MyBot() {
        this.setName("MyBot");
		
		//Setup FileStuffs
        FileInfo();
		
		//List Commands
		commandList.add(new Witness());
		commandList.add(new Time());
    }

    public void onMessage(String channel, String sender,
                       String login, String hostname, String message) {
		
		for (Command com : commandList) {
				String output = com.Evaluate(channel, sender, login, hostname, message);
				if (output.length() > 0) {
					sendMessage(channel, output);
				}
		}
    }
	
	public void FileInfo() {
		try{
			witnessLog = new File("WitnessLog.txt");
			if (!witnessLog.exists()) {
				witnessLog.createNewFile();
			}
		} catch (IOException e) {
				e.printStackTrace();
		}
	}
}
