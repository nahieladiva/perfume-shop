package com.nahiely.perfume_shop.domain.valueobjects;

import java.util.ArrayList;
import java.util.List;

public class OlfactoryNotes {
    private final List<String> topNotes;
    private final List<String> heartNotes;
    private final List<String> baseNotes;

    public OlfactoryNotes(List<String> topNotes, List<String> heartNotes, List<String> baseNotes) {
        this.topNotes = new ArrayList<>(topNotes);
        this.heartNotes = new ArrayList<>(heartNotes);
        this.baseNotes = new ArrayList<>(baseNotes);
    }

    public List<String> getTopNotes() { return new ArrayList<>(topNotes); }
    public List<String> getHeartNotes() { return new ArrayList<>(heartNotes); }
    public List<String> getBaseNotes() { return new ArrayList<>(baseNotes); }

    public List<String> getAllNotes() {
        List<String> all = new ArrayList<>();
        all.addAll(topNotes);
        all.addAll(heartNotes);
        all.addAll(baseNotes);
        return all;
    }

    @Override
    public String toString() {
        return "Top: " + String.join(", ", topNotes) +
               " | Heart: " + String.join(", ", heartNotes) +
               " | Base: " + String.join(", ", baseNotes);
    }
}