import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by vaios on 20-Dec-16.
 */
public class ManageGUI extends JFrame {

    private JButton       addFriendButton, mutualFriendButton, printFriendsButton, addToGroupButton, addToClosedGroupButton;
    private JList<String> list1, list2;
    private JPanel        panel;
    private JButton       nextPageButton;
    private String[]      nameList = new String[10];

    public ManageGUI(ArrayList<User> allUsers, Group g1, Group g2) {

        int i = 0;
        for(User u: allUsers)
        {
            nameList[i] = u.getName();
            i++;
        }

        panel                   = new JPanel();
        addFriendButton         = new JButton("Add friend");
        mutualFriendButton      = new JButton("Find mutual friends");
        printFriendsButton      = new JButton("Print friends");
        addToGroupButton        = new JButton("Add to group");
        addToClosedGroupButton  = new JButton("Add to closed group");
        nextPageButton          = new JButton("Click here to go to the next page");


        list1 = new JList<>(nameList);
        list2 = new JList<>(nameList);


        list1.setSelectedIndex(0);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list1.setToolTipText("ÅðÝëåîå áðü áõôÞ ôçí ëßóôá ôïí 1ï ößëï");

        list2.setSelectedIndex(1);
        list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list2.setToolTipText("ÅðÝëåîå áðü áõôÞ ôçí ëßóôá ôïí 2ï ößëï");

        panel.add(addFriendButton);
        panel.add(mutualFriendButton);
        panel.add(printFriendsButton);
        panel.add(addToGroupButton);
        panel.add(addToClosedGroupButton);
        panel.add(list1);
        panel.add(list2);
        panel.add(nextPageButton);

        nextPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EnterGUI(allUsers);
                panel.setVisible(false);
            }
        });
        addToClosedGroupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                for(User u: allUsers)
                {
                    if(u.getName().equals(list1.getSelectedValue()))
                    {
                        g2.addToGroup(u);
                        break;
                    }
                }

            }
        });
        addToGroupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                for(User u: allUsers)
                {
                    if(u.getName().equals(list1.getSelectedValue()))
                    {
                        g1.addToGroup(u);
                        break;
                    }
                }

            }
        });
        mutualFriendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                User tempUser = new User();
                for(User u: allUsers)
                {
                    if(u.getName().equals(list2.getSelectedValue()))
                    {
                        tempUser = u;
                        break;
                    }
                }

                for(User u: allUsers)
                {
                    if(u.getName().equals(list1.getSelectedValue()))
                    {
                        u.mutualFriends(tempUser);
                    }
                }
            }
        });
        addFriendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                User tempUser = new User();
                for(User u: allUsers)
                {
                    if(u.getName().equals(list2.getSelectedValue()))
                    {
                        tempUser = u;
                        break;
                    }
                }

                for(User u: allUsers)
                {
                    if(u.getName().equals(list1.getSelectedValue()))
                    {
                        u.addFriend(tempUser);
                    }
                }
            }
        });
        printFriendsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                User tempUser = new User();
                for(User u: allUsers)
                {
                    if(u.getName().equals(list1.getSelectedValue()))
                    {
                        tempUser = u;
                        break;
                    }
                }
                tempUser.printFriends();
            }
        });

        this.setTitle("Manage Friends");
        this.setVisible(true);
        this.setContentPane(panel);
        this.setResizable(false);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
