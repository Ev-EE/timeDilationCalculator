package GamePanel;

import javax.swing.*;

public class Window extends JFrame {

    GUI GUI = new GUI();

    public Window(String name)
    {
        setTitle(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        do
            {
                setContentPane(GUI.run());
                pack();
                setLocationRelativeTo(null);
                setVisible(true);

                GUI.update();

            }while (GUI.isRunning());
    }
}
