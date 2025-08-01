package org.example.Problems.KFileSystemWithSearch.Search;

import org.example.Problems.KFileSystemWithSearch.Core.FileComponent;

public interface SearchCriteria {
    boolean matches(FileComponent component);
}
