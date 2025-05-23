package org.example.Problems.FileSystemWithSearch.Search;

import org.example.Problems.FileSystemWithSearch.Core.FileComponent;
import org.example.Problems.FileSystemWithSearch.Core.File;


public class ExtensionSearchCriteria implements SearchCriteria {
    private final String extension;

    public ExtensionSearchCriteria(String extension) {
        this.extension = extension;
    }

    public boolean matches(FileComponent component) {
        if (component instanceof File) {
            return ((File) component).getExtension().equalsIgnoreCase(extension);
        }
        return false;
    }
}