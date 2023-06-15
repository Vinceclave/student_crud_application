import javax.swing.*;
public class adminAccountList {
    private final int adminAccountSize = 5;
    public int count = 0;

    public adminAccount[] list;

    public adminAccountList() {
        list = new adminAccount[adminAccountSize];
    }

    public void addAccount(adminAccount e) {
        list[count] = e;
        count++;
    }

    public adminAccount[] getAdminList() {
        adminAccount[] adminArray = new adminAccount[count];
        for (int i = 0; i < count; i++) {
            adminArray[i] = list[i];
        }
        return adminArray;
    }
    public int getAdminAccountSize() {
        return adminAccountSize;
    }
}
