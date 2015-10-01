package commands;

import org.jibble.pircbot.*;

public class Command extends PircBot {
    //If it only needs the start of the message, it's true, otherwise if it's like .time it needs to be the entire message;
    boolean startorall;
    String trigger;
    String name;
    String description;

    public String Execute(String channel, String sender, String login, String hostname, String message) {
        return "";
    }

    public String Evaluate(String channel, String sender, String login, String hostname, String message) {
        String output = "";
        if (startorall) {
            if (message.startsWith(trigger)) {
                output = Execute(channel, sender, login, hostname, message);
            }
        }

        if (!startorall) {
            if (message.equalsIgnoreCase(trigger)) {
                output = Execute(channel, sender, login, hostname, message);
            }
        }

        return output;
    }
}
