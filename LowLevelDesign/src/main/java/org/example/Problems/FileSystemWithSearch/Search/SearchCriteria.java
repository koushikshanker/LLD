package org.example.Problems.FileSystemWithSearch.Search;

import org.example.Problems.FileSystemWithSearch.Core.FileComponent;

public interface SearchCriteria {
    boolean matches(FileComponent component);
}
