package commands;

import commands.Command;

public class Time extends Command {
    public Time() {
        startorall = false;
        trigger = ".time";
        name = "commands.Time";
        description = "Displays time for an example";
    }

    public String Execute(String channel, String sender, String login, String hostname, String message) {
        String time = new java.util.Date().toString();
        return sender + ": The time is now " + time;
    }
}