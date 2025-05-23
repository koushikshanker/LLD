package org.example.Problems.FileSystemWithSearch.Core;

public abstract class FileComponent {
    protected String name;
    protected Directory parent;

    public FileComponent(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public abstract long getSize();

    public String getPath() {
        if (parent == null) return name;
        return parent.getPath() + "/" + name;
    }
}
