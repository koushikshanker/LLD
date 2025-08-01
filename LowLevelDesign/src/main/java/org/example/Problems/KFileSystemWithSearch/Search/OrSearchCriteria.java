package org.example.Problems.KFileSystemWithSearch.Search;

import org.example.Problems.KFileSystemWithSearch.Core.FileComponent;

import java.util.List;

public class OrSearchCriteria implements SearchCriteria {
    private List<SearchCriteria> criteria;

    public OrSearchCriteria(List<SearchCriteria> criteria) {
        this.criteria = criteria;
    }

    public boolean matches(FileComponent component) {
        for (SearchCriteria c : criteria) {
            if (c.matches(component)) {
                return true;
            }
        }
        return false;

    }
}