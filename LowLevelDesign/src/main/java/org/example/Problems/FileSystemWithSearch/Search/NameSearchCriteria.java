package org.example.Problems.FileSystemWithSearch.Search;

import org.example.Problems.FileSystemWithSearch.Core.FileComponent;

public class NameSearchCriteria implements SearchCriteria {
    private String pattern;

    public NameSearchCriteria(String pattern) {
        this.pattern = pattern;
    }

    public boolean matches(FileComponent component) {
        return component.getName().contains(pattern);
    }
}