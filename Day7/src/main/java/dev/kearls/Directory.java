package dev.kearls;

import java.util.*;

public class Directory {
    private final String name;
    private final Directory parent;
    private List<File> files;
    private Map<String, Directory> directories;

    public Directory(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
        this.files = new ArrayList<>();
        this.directories = new HashMap<>();
    }

    public void addFile(File f) {
        files.add(f);
    }

    public void addDirectory(Directory d) {
        directories.put(d.name, d);
    }

    public int getTotalSizeOfFiles() {
        int total = 0;
        for (File f : files) {
            total += f.size;
        }
        for (Directory d : directories.values()) {
            total += d.getTotalSizeOfFiles();
        }

        return total;
    }

    public Directory getSubdirectory(String name) {
        return directories.get(name);
    }

    public Directory getParent() {
        return this.parent;
    }

    public String getName() {
        return this.name;
    }

    public Collection<Directory> getSubDirectories() {
        return directories.values();
    }
}
