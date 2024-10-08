package applet;

import java.awt.*;
import java.awt.event.*;

class FactEvent extends java.applet.Applet implements ActionListener
{
    TextField t1, t2;
    int fact = 1, m;
    Button b1, b2, b3;
    String msg;
    Label l1, l2;
    FactEvent e;

    public void init()
    {
        e = this;
        t1 = new TextField(3);
        t2 = new TextField(10);
        b1 = new Button("FIND FACTORIAL");
        l1 = new Label("ENTER THE NUMBER");
        l2 = new Label("RESULT");
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b1);
        b1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae)
    {
        String str = t1.getText();
        if (str != "")
        {
            int num = Integer.parseInt(str);
            for (int i = num; i > 0; i--)
            {
                fact = fact * i;
            }

            msg = "" + fact;
            t2.setText(msg);
            fact = 1;
        }
    }
}
