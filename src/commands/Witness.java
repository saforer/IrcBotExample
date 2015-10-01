package commands;

import commands.Command;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Witness extends Command {

    public Witness() {
        startorall = true;
        trigger = ".witness ";
        name = "commands.Witness";
        description = "Uhh, it does something?";
    }

    public String Execute(String channel, String sender, String login, String hostname, String message) {
        String time = new java.util.Date().toString();
        String witness = "commands.Witness: " + time + " <" + sender + "> " + message.substring(8) + "\r\n";

        try {
            FileWriter fileWriter = new FileWriter("WitnessLog.txt", true);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            bufferWriter.write(witness);
            bufferWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Mediocre!";
    }
}