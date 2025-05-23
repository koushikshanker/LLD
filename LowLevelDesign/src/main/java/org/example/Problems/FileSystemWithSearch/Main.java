package org.example.Problems.FileSystemWithSearch;

import org.example.Problems.FileSystemWithSearch.Core.Directory;
import org.example.Problems.FileSystemWithSearch.Core.File;
import org.example.Problems.FileSystemWithSearch.Core.FileComponent;
import org.example.Problems.FileSystemWithSearch.Core.FileSystem;
import org.example.Problems.FileSystemWithSearch.Search.AndSearchCriteria;
import org.example.Problems.FileSystemWithSearch.Search.ExtensionSearchCriteria;
import org.example.Problems.FileSystemWithSearch.Search.SearchCriteria;
import org.example.Problems.FileSystemWithSearch.Search.SizeSearchCriteria;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        FileSystem fs = new FileSystem();
        Directory root = fs.getRoot();

        Directory docs = new Directory("docs", root);
        root.add(docs);

        File file1 = new File("report.pdf", 1200, "pdf", docs);
        File file2 = new File("notes.txt", 800, "txt", docs);
        docs.add(file1);
        docs.add(file2);

        // Search for all .txt files larger than 500 bytes
        SearchCriteria search = new AndSearchCriteria(List.of(
                new ExtensionSearchCriteria("txt"),
                new SizeSearchCriteria(500)
        ));

        // asking fs to search for files which meets our searchCriteria in search object
        List<FileComponent> results = fs.search(search);
        results.forEach(f -> System.out.println(f.getPath()));
    }
}
