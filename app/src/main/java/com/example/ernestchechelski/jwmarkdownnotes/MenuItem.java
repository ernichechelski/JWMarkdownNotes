package com.example.ernestchechelski.jwmarkdownnotes;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * Created by ernest.chechelski on 11/30/2017.
 */

public class MenuItem {

    String name;
    int innerResourceId;
    int outerResourceId;
    List<MenuItem> children = new ArrayList<>();
    MenuItem parent;
    SwipeListViewAdapter parentAdapter;
    MenuItemInterface handler;


    public MenuItem(String name,MenuItemInterface handler) {
        this.name = name;
        this.handler = handler;
    }

    public MenuItem(String name, int innerResourceId, int outerResourceId,MenuItemInterface handler) {
        this.name = name;
        this.innerResourceId = innerResourceId;
        this.outerResourceId = outerResourceId;
        this.handler = handler;
    }


    public MenuItem(String name, int innerResourceId, int outerResourceId, MenuItem parent,MenuItemInterface handler) {
        this.name = name;
        this.innerResourceId = innerResourceId;
        this.outerResourceId = outerResourceId;
        this.parent = parent;
        this.handler = handler;
    }

    public MenuItem(String name, int innerResourceId, int outerResourceId, List<MenuItem> children,MenuItemInterface handler) {
        this.name = name;
        this.innerResourceId = innerResourceId;
        this.outerResourceId = outerResourceId;
        this.children = children;
        this.handler = handler;
    }

    public MenuItem(String name, int innerResourceId, int outerResourceId, List<MenuItem> children, MenuItem parent,MenuItemInterface handler) {
        this.name = name;
        this.innerResourceId = innerResourceId;
        this.outerResourceId = outerResourceId;
        this.children = children;
        this.parent = parent;
        this.handler = handler;
    }

    public MenuItem init(SwipeListViewAdapter adapter){
        this.parentAdapter = adapter;
        return this;
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
