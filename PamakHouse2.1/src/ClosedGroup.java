/**
 * Created by Dimitris on 20-Dec-16.
 */
public class ClosedGroup extends Group {

    public ClosedGroup(String name, String description) {
        super(name, description);
    }

    /**
     * ����������� ��� ��������� ��� ������ Group ��� ��� ����������� ���� ���� �� ������ �� ���� �������
     * �� ��� ������� ����� ���� ��� � ����� ������ ��� ���� ������ ����� ��� ��������� ��� ����
     * ������� ����� ���� �� �� ����� ��� ������ ������.
     */
    public void addToGroup(User aUser) {

        boolean flag1 = false;
        User temp1 = new User();

        //������� �� � ������� ��� ���� �� ����� ������� ��� ����� ������� ���
        for (int x = 0; x < this.arrayGroup.size(); x++) {
            temp1 = this.arrayGroup.get(x);

            if (temp1.getName().equals(aUser.getName())) {
                System.out.println("\n" + aUser.getName() + " is already enrolled in the Exam Solutions group.\n");
                flag1 = true;
            }
        }

        //��� �� ����� ����� ����� � ������� ������� ��� ����� ���� ��� �� ����
        if (this.arrayGroup.size() == 0) {
            this.arrayGroup.add(aUser);
            System.out.println(aUser.getName() + " has successfully enrolled in group " + this.name);
        } else {
            //������� ��� � ������� ��� ���� �� ������� ��� ����� ������� ���
            if (flag1 == true) return;

            User temp2 = new User();
            boolean flag2 = false;
            int sizeOfArray = this.arrayGroup.size();

            //������� �� � ������� ��� ���� �� ����� ������� ��� ����� ���� ����� ���� �� �������
            //��� ����� ��� ������������
            for (int i = 0; i < sizeOfArray; i++) {

                temp2 = arrayGroup.get(i);
                if (flag2 == true) break;

                if (temp2.isHeInMyFriendList(aUser)) {
                    this.arrayGroup.add(aUser);
                    System.out.println(aUser.getName() + " has successfully enrolled in group " + this.name);
                    flag2 = true;
                }
            }
            if (flag2 == false)
                System.out.println("\n" + aUser.getName() + " don't have a mutual friend, so she can't join the Exam Solution group.\n");
        }
    }
}