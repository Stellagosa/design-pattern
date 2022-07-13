public class PropotypeCitatio {

    public static void main(String[] args) {
        Citation c1 = new Citation("小明", "同学：在2020年表现优异，被评为三好学生。", "UESTC");
        Citation c2 = (Citation) c1.clone();
        c2.setName("小莉");
        c1.display();
        c2.display();
    }
}

class Citation implements Cloneable {

    private String name;
    private String info;
    private String college;

    public Citation(String name, String info, String college) {
        this.name = name;
        this.info = info;
        this.college = college;
    }

    public Object clone() {
        Citation c = null;
        try {
            c = (Citation) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("拷贝失败");
        }
        return c;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println(name + info + college);
    }
}

