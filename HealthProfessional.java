/**
 * 健康专业人员基类（Part1必做）
 * 功能：定义所有健康工作者的通用属性和行为，为子类提供继承基础
 */
public class HealthProfessional {
    // 必选实例变量：ID（仅数字）、姓名 + 1个通用基本信息（此处选“所属科室”）
    private int id;          // 仅数字（用int确保类型约束，避免非数字输入）
    private String name;     // 健康专业人员姓名
    private String department; // 额外通用信息：所属科室（所有医生均需该属性）

    // 1. 默认构造函数（无参，Part1必做）
    public HealthProfessional() {
        this.id = 0;
        this.name = "未填写";
        this.department = "未分配";
    }

    // 2. 全参构造函数（初始化所有实例变量，Part1必做）
    public HealthProfessional(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // 3. 打印所有实例变量的方法（Part1必做，格式易读）
    public void printBasicInfo() {
        System.out.println("基础信息：");
        System.out.println("  - ID：" + this.id);
        System.out.println("  - 姓名：" + this.name);
        System.out.println("  - 所属科室：" + this.department);
    }

    // Getter/Setter（子类需访问父类私有变量，必写，否则子类无法操作父类属性）
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}