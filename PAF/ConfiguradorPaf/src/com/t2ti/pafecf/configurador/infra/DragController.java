/*
 * The MIT License
 *
 * Copyright: Copyright (C) 2014 T2Ti.COM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 * The author may be contacted at: t2ti.com@gmail.com
 * 
 * @author Claudio de Barros (T2Ti.com)
 * @version 2.0
 */
package com.t2ti.pafecf.configurador.infra;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DragController extends MouseAdapter implements MouseMotionListener {

    int baseX = -1;
    int baseY = -1;

    /**
     * @see
     * java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
     */
    public void mouseDragged(MouseEvent e) {
        if ((this.baseX != -1) && (this.baseY != -1)) {
            Component c = e.getComponent();
            int x = c.getX() + e.getX() - this.baseX;
            int y = c.getY() + e.getY() - this.baseY;
            Container parent = c.getParent();
            Dimension pSize = parent.getSize();
            Rectangle cSize = c.getBounds();

            x = Math.max(x, 0);
            x = Math.min(x, pSize.width - cSize.width);
            y = Math.max(y, 0);
            y = Math.min(y, pSize.height - cSize.height);

            c.setLocation(x, y);
            c.getParent().repaint();
        }
    }

    /**
     * @see
     * java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
     */
    public void mouseMoved(MouseEvent e) {
        //  
    }

    /**
     * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
     */
    public void mousePressed(MouseEvent e) {

        Component c = e.getComponent();

        if (!c.getName().equals("labelImagemTela")) {
            Container parent = c.getParent();
            Component[] all = parent.getComponents();
            for (int i = 0; i < all.length; i++) {
                parent.remove(all[i]);
            }
            parent.add(c);
            for (int i = 0; i < all.length; i++) {
                if (all[i] != c) {
                    parent.add(all[i]);
                }
            }
            c.requestFocus();
        }
        
        this.baseX = e.getX();
        this.baseY = e.getY();
    }

    /**
     * @see
     * java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
     */
    public void mouseReleased(MouseEvent e) {
        this.baseX = -1;
        this.baseY = -1;
    }
    
    public void mous (MouseEvent e) {
        this.baseX = -1;
        this.baseY = -1;
    }

}
