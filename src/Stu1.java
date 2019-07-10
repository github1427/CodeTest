/**
 * @ Author     ：vain
 * @ Date       ：Created in 1:51 PM 2019/3/18
 * @ Description：
 */
 public  class  Stu1 implements Cloneable{
    private String name;

    public Stu1(String name){
        this.name=new String(name);
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Stu1 student=null;
        student= (Stu1) super.clone();
        return student;
    }

    public int getName() {
        return System.identityHashCode(name);
    }

    public void setName(String name) {
        this.name = name;
    }
    public void returnName(){
        System.out.println(name);
    }
}
class CopyTess{
    public static void main(String[] args) {
        Stu1 stu1=new Stu1("小明");
        try {
            Stu1 stu11= (Stu1) stu1.clone();
            System.out.println(stu1.getName());
            System.out.println(stu11.getName());
            System.out.println("-----------");
            stu11.setName("324");
            stu1.returnName();
            stu11.returnName();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
