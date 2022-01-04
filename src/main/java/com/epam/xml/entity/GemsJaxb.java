package com.epam.xml.entity;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Gem")

@XmlType(propOrder = {"origin", "name", "preciousness", "synthesized"})
public class GemsJaxb {
    private int id;
    private String origin;
    private String name;
    private String preciousness;
    private String synthesized;

    public GemsJaxb(int id, String origin, String name, String preciousness, String synthesized) {
        this.id = id;
        this.origin = origin;
        this.name = name;
        this.preciousness = preciousness;
        this.synthesized = synthesized;
    }

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreciousness() {
        return preciousness;
    }

    public void setPreciousness(String preciousness) {
        this.preciousness = preciousness;
    }

    public String getSynthesized() {
        return synthesized;
    }

    public void setSynthesized(String synthesized) {
        this.synthesized = synthesized;
    }

    @Override
    public String toString() {
        return "GemsJaxb{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                ", name='" + name + '\'' +
                ", preciousness='" + preciousness + '\'' +
                ", synthesized='" + synthesized + '\'' +
                '}';
    }
}