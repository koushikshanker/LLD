package org.example.Problems.FileSystemWithSearch.Core;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileComponent {
    private List<FileComponent> children = new ArrayList<>();

    public Directory(String name, Directory parent) {
        super(name, parent);
    }

    public void add(FileComponent component) {
        children.add(component);
    }

    public List<FileComponent> getChildren() {
        return children;
    }

    public long getSize() {
        return children.stream().mapToLong(FileComponent::getSize).sum();
    }
}
