public class LeaveApprovalTest {
    public static void main(String[] args) {
        Leader classAdviser = new ClassAdviser();
        Leader departmentHeader = new DepartmentHeader();
        Leader dean = new Dean();
        Leader deanOfStudies = new DeanOfStudies();

        classAdviser.setNext(departmentHeader);
        departmentHeader.setNext(dean);
        dean.setNext(deanOfStudies);

        classAdviser.handleRequest(8);
    }
}

abstract class Leader {
    private Leader next;

    public void setNext(Leader next) {
        this.next = next;
    }

    public Leader getNext() {
        return next;
    }

    public abstract void handleRequest(int leaveDays);
}

class ClassAdviser extends Leader {
    @Override
    public void handleRequest(int leaveDays) {
        if (leaveDays < 3) {
            System.out.println("班主任批准了" + leaveDays + "天假");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(leaveDays);
            } else {
                System.out.println("请假天数过多，没有人可以批准");
            }
        }
    }
}

class DepartmentHeader extends Leader {
    @Override
    public void handleRequest(int leaveDays) {
        if (leaveDays < 5) {
            System.out.println("系主任批准了" + leaveDays + "天假");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(leaveDays);
            } else {
                System.out.println("请假天数过多，没有人可以批准");
            }
        }
    }
}
class Dean extends Leader {
    @Override
    public void handleRequest(int leaveDays) {
        if (leaveDays < 7) {
            System.out.println("院长批准了" + leaveDays + "天假");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(leaveDays);
            } else {
                System.out.println("请假天数过多，没有人可以批准");
            }
        }
    }
}

class DeanOfStudies extends Leader {
    @Override
    public void handleRequest(int leaveDays) {
        if (leaveDays < 9) {
            System.out.println("教务处长批准了" + leaveDays + "天假");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(leaveDays);
            } else {
                System.out.println("请假天数过多，没有人可以批准");
            }
        }
    }
}













