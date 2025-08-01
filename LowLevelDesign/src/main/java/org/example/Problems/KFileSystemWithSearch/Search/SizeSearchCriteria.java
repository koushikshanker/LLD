package org.example.Problems.KFileSystemWithSearch.Search;

import org.example.Problems.KFileSystemWithSearch.Core.FileComponent;

public class SizeSearchCriteria implements SearchCriteria {
    private long minSize;

    public SizeSearchCriteria(long minSize) {
        this.minSize = minSize;
    }

    public boolean matches(FileComponent component) {
        return component.getSize() >= minSize;
    }
}