/**
 * 心脏病科医生子类（Part2自定义类型）
 * 继承自HealthProfessional，添加心内科医生特有的属性和行为
 */
public class Cardiologist extends HealthProfessional {
    // 差异化实例变量：心内科医生特有（擅长病症，如“冠心病/心律失常”）
    private String specializedDisease;

    // 1. 默认构造函数（无参，Part2必做）
    public Cardiologist() {
        super(); // 调用父类默认构造
        this.specializedDisease = "冠心病"; // 默认擅长病症
    }

    // 2. 全参构造函数（含父类所有变量，Part2必做）
    public Cardiologist(int id, String name, String department, String specializedDisease) {
        super(id, name, department); // 调用父类全参构造
        this.specializedDisease = specializedDisease;
    }

    // 3. 打印医生详情（含“心脏病科医生”类型标识，Part2必做）
    @Override
    public void printBasicInfo() {
        System.out.println("【健康专业人员类型：心脏病科医生】");
        super.printBasicInfo(); // 调用父类方法，打印通用基础信息
        System.out.println("  - 擅长病症：" + this.specializedDisease);
        System.out.println(); // 空行分隔
    }

    // Getter/Setter（访问私有差异化变量）
    public String getSpecializedDisease() {
        return specializedDisease;
    }

    public void setSpecializedDisease(String specializedDisease) {
        this.specializedDisease = specializedDisease;
    }
}
