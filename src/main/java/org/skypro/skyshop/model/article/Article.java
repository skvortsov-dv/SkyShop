package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public class Article implements Searchable {
    private final UUID id;

    private final String name;
    private final String text;

    public Article(UUID id, String name, String text) {
        this.id = id;
        this.name = name;
        this.text = text;
    }

    @Override
    @JsonIgnore
    public String getStringRepresentation() {
        return toString();
    }

    @Override
    @JsonIgnore
    public String getType() {
        return "ARTICLE";
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return name + "\n" + text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Article article)) return false;
        return Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

//    @Override
//    public int compareTo(Object o) {
//        Article article = (Article) o;
//
//        int lengthCompare = Integer.compare(this.name.length(), article.name.length());
//
//        if (lengthCompare == 0){
//            return this.name.compareTo(article.name);
//        }
//
//        return lengthCompare;
//    }
}
