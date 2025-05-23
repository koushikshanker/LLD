package org.example.Problems.FileSystemWithSearch.Core;

import org.example.Problems.FileSystemWithSearch.Core.Directory;
import org.example.Problems.FileSystemWithSearch.Core.FileComponent;

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