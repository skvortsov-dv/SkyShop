package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {
    default String getStringRepresentation() {
        return getName() + " - " + getType();
    }

    String getType();

    String getName();

    UUID getId();
}
