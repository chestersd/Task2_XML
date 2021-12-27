package com.epam.xml.entity;

import java.util.Objects;

public class VisualParameters extends Gem {
    private String color;
    private String opacity;
    private String facets;
    private String weight;
    private VisualParameters visualParameters;

    public VisualParameters(String color, String opacity, String facets, String weight) {
        this.color = color;
        this.opacity = opacity;
        this.facets = facets;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOpacity() {
        return opacity;
    }

    public void setOpacity(String opacity) {
        this.opacity = opacity;
    }

    public String getFacets() {
        return facets;
    }

    public void setFacets(String facets) {
        this.facets = facets;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisualParameters that = (VisualParameters) o;
        return color.equals(that.color) && opacity.equals(that.opacity) && facets.equals(that.facets) && weight.equals(that.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, opacity, facets, weight);
    }

    @Override
    public String toString() {
        return "VisualParameters{" +
                "color='" + color + '\'' +
                ", opacity='" + opacity + '\'' +
                ", facets='" + facets + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}
