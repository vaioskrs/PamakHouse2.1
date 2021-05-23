import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

/**
 * Created by Dimitris on 20-Dec-16.
 */
public class UserGUI extends JFrame {

    private JPanel           panel;
    private JLabel           labelRecentPost, labelSuggestedFriend;
    private JTextField       textFieldName, textFieldMail, textFieldSuggFriend;
    private JButton          buttonBack, buttonPost, sortButton;
    private JTextArea        textAreaPost;/*, textAreaRecentPosts;*/
    private JScrollPane      scrollPane1, scrollPane2;
    private JList            list;
    private static int       i = 0;
    private DefaultListModel model;

    public UserGUI(User user, ArrayList<User> allUsers)
    {
        panel = new JPanel();

        textFieldName       = new JTextField(user.getName(),7);
        textFieldMail       = new JTextField(user.getEmail());
        textFieldSuggFriend = new JTextField("Gianna", 10);

        buttonBack = new JButton("Πίσω στο παράθυρο εισόδου");
        buttonPost = new JButton("Πόστ");
        sortButton = new JButton("Ταξινόμηση");

        labelRecentPost      = new JLabel("Πρόσφατα ποστ φίλων");
        labelSuggestedFriend = new JLabel("Προτεινόμενοι φίλοι");

        textAreaPost         = new JTextArea(13, 30);/*
        textAreaRecentPosts  = new JTextArea(13, 30);*/

        scrollPane1  = new JScrollPane(textAreaPost, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        model        = new DefaultListModel();
        list         = new JList();
        scrollPane2  = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        list.setModel(model);

        textAreaPost.setLineWrap(true);
        textAreaPost.setWrapStyleWord(true);/*
        textAreaRecentPosts.setLineWrap(true);
        textAreaRecentPosts.setWrapStyleWord(true);*/

        panel.add(textFieldName);
        panel.add(textFieldMail);
        panel.add(buttonBack);
        panel.add(scrollPane1);
        panel.add(buttonPost);
        panel.add(labelRecentPost);
        panel.add(scrollPane2);
        panel.add(labelSuggestedFriend);
        panel.add(textFieldSuggFriend);
        panel.add(sortButton);

        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                panel.setVisible(false);
                new EnterGUI(allUsers);
            }
        });
        buttonPost.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(i==0){
                    model.addElement("15/04/2016 15:03:12 Gianna, Java class");
                    model.addElement("06/04/2016 12:04:49 Petros, I'll join this class too");
                }
                model.addElement((new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()) + " " + user.getName() + ", \n" + textAreaPost.getText() + "\n"));
                i++;
            }
        });
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> posts = Collections.list(model.elements());
                Collections.sort(posts);
                model.clear();
                for(String s: posts) {
                    model.addElement(s);
                }
            }
        });

        this.setContentPane(panel);
        this.setTitle("Σελίδα χρήστη");
        this.setVisible(true);
        textAreaPost.requestFocus();
        this.setResizable(true);
        this.setSize(500, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
