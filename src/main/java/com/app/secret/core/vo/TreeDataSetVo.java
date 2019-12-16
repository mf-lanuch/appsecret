package com.app.secret.core.vo;

import java.util.ArrayList;
import java.util.List;

public class TreeDataSetVo {

    private String id;

    private String code;

    private String name;

    private String icon;

    private String path;

    private List<TreeDataSetVo> children;

    public TreeDataSetVo() {
        children = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TreeDataSetVo> getChildren() {
        return children;
    }

    public void setChildren(List<TreeDataSetVo> children) {
        this.children = children;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void addChildren(TreeDataSetVo child) {
        this.children.add(child);
    }
}
