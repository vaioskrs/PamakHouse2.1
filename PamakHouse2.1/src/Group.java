import java.util.ArrayList;

/**
 * Created by vaios on 20-Dec-16.
 */
public class Group {

    protected String name;
    protected String description;
    protected ArrayList<User> arrayGroup = new ArrayList<User>();

    public Group(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * ÅëÝã÷åé áí åßíáé ìÝëïò ôïõ ãêñïõð Þ ü÷é
     * @param aUser
     * @return
     */
    public boolean isItMember(User aUser) {

        boolean flag = false;

        for(User u : arrayGroup)
            if(u.equals(aUser))
                flag = true;
        return flag;
    }

    /**
     * ÐñïóèÝôåé ÷ñÞóôç óôï ãêñïýð
     * @param aUser
     */
    public void addToGroup(User aUser) {
        if(!this.isItMember(aUser)){
            arrayGroup.add(aUser);
            System.out.println(aUser.getName() + " has successfully enrolled in group " + this.name);
        }
        else
            System.out.println("\n" + aUser.getName() + " is already member of the Web Gurus group.\n");
    }

    /**
     * Åêôõðþíåé ôïõò ÷ñÞóôåò ðïõ âñßóêïíôáé óôï ãêñïýð
     */
    public void printInfo() {

        System.out.println("\n**************************************");
        System.out.println("Members of group " + this.name);
        System.out.println("**************************************");

        int count = 0;

        for(User u : arrayGroup) {
            count ++;
            System.out.println(count + ": " + u.getName());
        }
        System.out.println("--------------------------------------");
    }

    public String getName() {
        return name;
    }
}
