package com.epam.xml.entity;

import java.util.List;

public class Gem {
    private Integer id;
    private String origin;
    private String name;
    private String preciousness;
    private String synthesized;
    private VisualParameters visualParameters;
    
//    Gem gem = new Gem();
    private List<Gem> gem(){
        List<Gem> gem = null;
        return gem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public VisualParameters getVisualParameters() {
        return visualParameters();
    }

    @Override
    public String toString() {
        return "Gem{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                ", name='" + name + '\'' +
                ", preciousness='" + preciousness + '\'' +
                ", synthesized='" + synthesized + '\'' +
                ", visualParameters=" + visualParameters +
                '}';
    }

    private VisualParameters visualParameters() {
        return visualParameters();
    }


}
