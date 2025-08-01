package org.example.Problems.KFileSystemWithSearch.Search;

import org.example.Problems.KFileSystemWithSearch.Core.FileComponent;
import org.example.Problems.KFileSystemWithSearch.Core.File;


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