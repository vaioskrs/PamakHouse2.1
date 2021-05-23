import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Dimitris on 20-Dec-16.
 */
public class EnterGUI extends JFrame
{
    private JButton     button;
    private JTextField  text;
    private JPanel      panel;
    private boolean     flag = false;

    public EnterGUI(ArrayList<User> allUsers)
    {
        panel   = new JPanel();
        button  = new JButton("Είσοδος");
        text    = new JTextField(10);

        button.setToolTipText("Θα μεταβείς στην σελίδα χρήστη αν τον πατήσεις");
        text.setToolTipText("Πρέπει να βάλεις το όνομα χρήστη");

        panel.add(text);
        panel.add(button);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                User user = null;
                if(e.getSource().equals(button))
                {
                    String name = text.getText();
                    for(User u: allUsers)
                    {
                        if(u.getName().equals(name))
                        {
                            flag = true;
                            user = u;
                        }
                    }
                    if(flag == true)
                    {
                        JOptionPane.showMessageDialog(EnterGUI.this, "User " + name + " found", "Message", JOptionPane.INFORMATION_MESSAGE);
                        new UserGUI(user, allUsers);
                        panel.setVisible(false);
                    }
                    else
                        JOptionPane.showMessageDialog(EnterGUI.this, "User " + name + " not found", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        this.setContentPane(panel);
        this.setTitle("Είσοδος Χρήστη");
        this.setVisible(true);
        this.setSize(270, 100);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

