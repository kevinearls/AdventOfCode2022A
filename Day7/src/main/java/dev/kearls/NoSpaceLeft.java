package dev.kearls;

import java.io.IOException;
import java.util.List;

import static dev.kearls.Common.getInput;

public class NoSpaceLeft {
    public static final Integer TOTAL_SPACE_AVAILABLE=70000000;
    public static final Integer NEEDED_FOR_UPDATE=30000000;
    public Directory processInput(List<String> lines) {
        Directory root = new Directory("/", null);
        Directory currentDirectory = root;

        int index = 1;  // Skip the first command as it should be "cd /"
        String line = lines.get(index);
        while(index < lines.size()) {
            if (line.charAt(0) == '$') {
                // Commands can only be cd or ls...
                String command = line.substring(2, 4);
                switch (command) {
                    case "cd":
                        String destination = line.substring(4).trim();
                        if (destination.equals("..")) {
                            currentDirectory = currentDirectory.getParent();
                        } else {
                            currentDirectory = currentDirectory.getSubdirectory(destination);
                        }
                        index++;
                        line = lines.get(index);
                        break;
                    case "ls":
                        // Get everything till EOF or the next $
                        index++;
                        while (index < lines.size()) {
                            line = lines.get(index);
                            if (line.charAt(0) == '$') {
                                break;
                            } else {
                                var parts = line.split(" ");
                                assert(parts.length == 2);
                                if (parts[0].equals("dir")) {
                                    Directory child = new Directory(parts[1], currentDirectory);
                                    currentDirectory.addDirectory(child);
                                } else {
                                    var size = Integer.valueOf(parts[0]);
                                    File f = new File(parts[1], size);
                                    currentDirectory.addFile(f);
                                }
                                index++;
                            }
                        }
                        break;
                    default:
                        System.out.println("******* We should never get here!!!!");
                }
            }
        }

        return root;
    }
}
