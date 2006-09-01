/*
 * DirStruct.java
 *
 * Copyright 2006, Dag Rune Sneeggen
 * 
 * This file is part of Vispace.
 * 
 * Vispace is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * Vispace is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Vispace; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

package jvisualfs;

import java.io.File;
import java.util.Vector;

/**
 *
 * @author dud
 */
public class DirStruct {
    
    // Fields declarations
    private File fp;
    private String name;
    private long length;
    private String size;
    // coord[0] = x1, coord[1] = x2, coord[2] = y1, coord[3] = y2
    private int[] coord;
    private DirStruct parent;
    private Vector childs;
    private boolean hilight;

    
    // Constructor
    public DirStruct(File fp) {
        this.fp = fp;
        this.name = fp.getAbsolutePath();
        this.length = fp.length();
        this.coord = new int[3];
        this.childs = new Vector(/*3, 3*/);
        this.size = calcSize();
    }

    public File getFp() {
        return fp;
    }

    
    // Class methods (POJO!)...

    public String getName() {
        return name;
    }

    public long getLength() {
        return length;
    }

    public String getSize() {
        return size;
    }

    public int[] getCoord() {
        return coord;
    }

    public DirStruct getParent() {
        return parent;
    }

    public boolean hasParent(String parent) {
        try {
            if (this.getParent().getName().equals(parent)) {
                return true;
            } else {
                return false;
            }  
        } catch (NullPointerException e) {
            return false;
        }
    }
    public boolean hasParent() {
        try {
            this.getParent().getName();
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }
    public boolean hasChild() {
        if (this.childs.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
    public DirStruct getChilds(String path) {
        for (int i=0; i<this.childs.size(); i++) {
            DirStruct tmp = (DirStruct) this.childs.get(i);
            if (tmp.getName().equals(path)) {
                return (DirStruct) this.childs.get(i);
            }
        }
        return null;    
    }

    public boolean isHilight() {
        return hilight;
    }

    public void setHilight(boolean hilight) {
        this.hilight = hilight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLength(long length) {
        this.length = length;
        setSize(calcSize());
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setCoord(int[] coord) {
        this.coord = coord;
    }

    public void setParent(DirStruct parent) {
        this.parent = parent;
    }

    public void addChild(DirStruct child) {
        this.childs.add(child);
    }

    private String calcSize() {
        double tenth = Math.log10((double) this.length);
        if (tenth > 3d) {
            if (tenth > 6d) {
                if (tenth > 9d) {
                    if (tenth > 12d) {
                        return ((int) (this.length * Math.pow(10d, -12d)) + "TB");
                    }
                    return ((int) (this.length * Math.pow(10d, -9d)) + "GB");
                }
                return ((int) (this.length * Math.pow(10d, -6d)) + "MB");
            }
            return ((int) (this.length * Math.pow(10d, -3d)) + "KB");
        } else {
            return ((int) this.length + "B");
        }
    }


}
