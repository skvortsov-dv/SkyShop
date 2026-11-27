package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService (StorageService storageService) {
        this.storageService = storageService;

    }

    public Collection<SearchResult> search  (String pattern) {
        Collection<Searchable> searchables = storageService.getAllSearchables();

        Collection <SearchResult> result =  searchables.stream().filter(searchable -> searchable.getStringRepresentation().contains(pattern)).map (searchable -> SearchResult.fromSearchable(searchable)).collect(Collectors.toList());

        return result;
    }
}

