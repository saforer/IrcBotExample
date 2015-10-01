import commands.Command;
import commands.Deeds;
import commands.Time;
import commands.Witness;
import org.jibble.pircbot.*;

import java.util.*;
import java.io.File;
import java.io.IOException;

public class MyBot extends PircBot {
    List<Command> commandList = new ArrayList<Command>();
    File witnessLog;

    public MyBot() {
        this.setName("MyBot");

        //Setup FileStuffs
        FileInfo();

        //List commands
        commandList.add(new Witness());
        commandList.add(new Time());
        commandList.add(new Deeds());
    }

    public void onMessage(String channel, String sender, String login, String hostname, String message) {

        for (Command com : commandList) {
            String output = com.Evaluate(channel, sender, login, hostname, message);
            //if (output.length() > 0) {
            //    sendMessage(channel, output);
            //}
        }
    }

    public void FileInfo() {
        try {
            witnessLog = new File("WitnessLog.txt");
            if (!witnessLog.exists()) {
                witnessLog.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
