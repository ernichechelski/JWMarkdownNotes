package com.example.ernestchechelski.jwmarkdownnotes;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ernest.chechelski on 11/30/2017.
 */
@Parcel
public class MenuItem {

    String name;
    List<MenuItem> children = new ArrayList<>();
    MenuItem parent;

    public MenuItem(String name) {
        this.name = name;

    }

    public MenuItem(String name,List<MenuItem> children) {
        this.name = name;
        for(MenuItem i:children){
            i.setParent(this);
        }
        this.children = children;
    }
    public MenuItem(String name,MenuItem parent) {
        this.name = name;
        this.parent = parent;
    }
    public MenuItem(String name,List<MenuItem> children,MenuItem parent) {
        this.name = name;
        this.children = children;
        this.parent = parent;
    }

    public MenuItem(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuItem> getChildren() {
        return children;
    }

    public void setChildren(List<MenuItem> children) {
        this.children = children;
    }

    public MenuItem getParent() {
        return parent;
    }

    public void setParent(MenuItem parent) {
        this.parent = parent;
    }
}
