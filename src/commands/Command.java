package commands;

import org.jibble.pircbot.PircBot;

public abstract class Command {
    //If it only needs the start of the message, it's true, otherwise if it's like .time it needs to be the entire message;
    protected boolean doesMsgStartWithTrigger;
    protected String trigger;
    protected String name;
    protected String description;

    private PircBot bot;

    public Command(PircBot bot) {
        this.bot = bot;
    }

    protected abstract void execute(String channel, String sender, String login, String hostname, String message);

    public void evaluate(String channel, String sender, String login, String hostname, String message) {
        if (doesMsgStartWithTrigger && message.startsWith(trigger)) {
            execute(channel, sender, login, hostname, message);
        } else if (!doesMsgStartWithTrigger && message.equalsIgnoreCase(trigger)) {
            execute(channel, sender, login, hostname, message);
        }
    }

    protected void sendMessage(String recipient, String message) {
        bot.sendMessage(recipient, message);
    }
}
