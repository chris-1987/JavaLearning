/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalearning;

import java.awt.*;
import java.applet.*;

/**
 *
 * @author ywu
 */

/*
<applet code="SimpleApplet" width = 200 height=60>
</applet>
 */
public class SimpleApplet extends Applet {

    public void paint(Graphics g) {

        g.drawString("Java makes applets easy.", 20, 20);
    }
}
