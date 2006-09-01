package jvisualfs;
/*
 * ImagePanel.java
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

import java.awt.Graphics;
import java.awt.Image;
import java.io.Serializable;
import javax.swing.JPanel;

/**
 *
 * @author dud
 */

public class ImagePanel extends JPanel implements Serializable {
    Image image = null;    
    public ImagePanel() {
    }    
    public ImagePanel(Image image) {
        this.image = image;
    }        
    public void setImage(Image image){
        this.image = image;
    }    
    public Image getImage(Image image){
        return image;
    }    
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //paint background
        if (image != null) { //there is a picture: draw it
            int height = this.getHeight();
            int width = this.getWidth();
            //System.out.println("DIM:" + width + "..." + height);
            g.drawImage(image,0,0, /*width, height,*/ this);
        }
    }
}

