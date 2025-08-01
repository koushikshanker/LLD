package org.example.Problems.KFileSystemWithSearch.Core;

public class File extends FileComponent {
    private long size;
    private String extension;

    public File(String name, long size, String extension, Directory parent) {
        super(name, parent);
        this.size = size;
        this.extension = extension;
    }

    public long getSize() {
        return size;
    }

    public String getExtension() {
        return extension;
    }
}