package com.uestc2h.u2pc.entity;

import java.io.File;

public class Picture {
    /**
     * name
     */
    String name;

    /**
     * size
     */
    Long size;

    /**
     * file
     */
    File file;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
