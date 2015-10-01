# IrcBotExample

# Setup
1. Make sure you have java jdk installed
2. Make sure that you change the information regarding channels and whatnot so it doesn't join the one I'm testing in
3. Maybe (as of writing it's not in but) make sure that you have the authentication done in the config file setup right
so the nickserv doesn't go "wait what password are you putting in this isn't right" (Also you might wanna have the nick
regged that the bot is going to use otherwise that bot gonna get kicked 'cause someone's gonna steal its nick.

# Building

    gradlew botJar

This will build a jar in build/libs/IrcBotExample-1.0.jar

# Running

    java -jar IrcBotExample-1.0.jar