package org.example.Problems.FileSystemWithSearch.Core;

import org.example.Problems.FileSystemWithSearch.Search.SearchCriteria;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {
    private Directory root;

    public FileSystem() {
        root = new Directory("root", null);
    }

    public Directory getRoot() {
        return root;
    }

    public List<FileComponent> search(SearchCriteria criteria) {
        List<FileComponent> result = new ArrayList<>();
        searchRecursive(root, criteria, result);
        return result;
    }

    private void searchRecursive(FileComponent current, SearchCriteria criteria, List<FileComponent> result) {
        if (criteria.matches(current)) {
            result.add(current);
        }
        if (current instanceof Directory) {
            for (FileComponent child : ((Directory) current).getChildren() ) {
                searchRecursive(child, criteria, result);
            }
        }
    }
}