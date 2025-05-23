package org.example.Problems.FileSystemWithSearch.Search;

import org.example.Problems.FileSystemWithSearch.Core.FileComponent;

public class SizeSearchCriteria implements SearchCriteria {
    private long minSize;

    public SizeSearchCriteria(long minSize) {
        this.minSize = minSize;
    }

    public boolean matches(FileComponent component) {
        return component.getSize() >= minSize;
    }
}