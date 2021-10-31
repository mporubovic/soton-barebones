package uk.ac.soton.ecs.mp3u21.comp1202.sc2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        FileReader reader = new FileReader();
        String commandString = reader.readFile("barebones.txt");
        String[] commands = commandString.split(";");

        HashMap<String, Integer> variables = new HashMap<>();
        Deque<Integer> whileStack = new ArrayDeque<Integer>();
        Integer lastEndLine = 0;

        for (int i = 0; i < commands.length; i++) {
            String[] cmd = commands[i].split(" ");

            switch (cmd[0]) {
                case "clear":
                    variables.put(cmd[1], 0);
                    break;

                case "incr":
                    variables.put(cmd[1], variables.get(cmd[1]) + 1);
                    break;

                case "decr":
                    variables.put(cmd[1], variables.get(cmd[1]) - 1);
                    break;

                case "while":
                    if (variables.get(cmd[1]) == 0) {
                        if (!whileStack.isEmpty()) whileStack.pop();
                        i = lastEndLine;
                    }
                    else if (!whileStack.contains(i-1)) {
                        whileStack.push(i-1);
                    }
                    break;

                case "end":
                    if (!whileStack.isEmpty()) {
                        lastEndLine = i;
                        i = whileStack.getFirst();
                    }
                    break;

                default:
                    break;
            }

        }
        System.out.println("Final state: " + variables);

    }
}
