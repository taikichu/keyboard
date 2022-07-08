package keyboard;

import javax.swing.border.Border;
import java.awt.*;

public class Border1 implements Border {
    public Insets getBorderInsets(Component c){
        return new Insets(1, 1, 0, 1);
    }

    public boolean isBorderOpaque(){
        return false;
    }

    public void paintBorder (Component c, Graphics g,
                             int x, int y, int width, int height){

        Insets insets = getBorderInsets(c);

        g.setColor(Color.BLACK);
        g.fillRect(x, y, insets.left, height);
        g.fillRect(x, y, width, insets.top);

        g.fillRect(x + width - insets.right, y, insets.right, height);
    }
}
