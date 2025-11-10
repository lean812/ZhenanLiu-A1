
/**
 * 全科医生子类（Part2必做）
 * 继承自HealthProfessional，添加全科医生特有的属性和行为
 */
public class GeneralPractitioner extends HealthProfessional {
    // 差异化实例变量：全科医生特有（接诊类型，如“普通门诊/慢病管理”）
    private String consultationType;

    // 1. 默认构造函数（无参，Part2必做）
    public GeneralPractitioner() {
        super(); // 调用父类默认构造，初始化父类属性
        this.consultationType = "普通门诊"; // 默认接诊类型
    }

    // 2. 全参构造函数（含父类所有变量，Part2必做）
    public GeneralPractitioner(int id, String name, String department, String consultationType) {
        super(id, name, department); // 调用父类全参构造，初始化父类属性
        this.consultationType = consultationType;
    }

    // 3. 打印医生详情（含“全科医生”类型标识，Part2必做）
    @Override
    public void printBasicInfo() {
        System.out.println("【健康专业人员类型：全科医生】");
        super.printBasicInfo(); // 调用父类方法，打印通用基础信息
        System.out.println("  - 接诊类型：" + this.consultationType);
        System.out.println(); // 空行分隔，增强可读性
    }

    // Getter/Setter（访问私有差异化变量）
    public String getConsultationType() {
        return consultationType;
    }

    public void setConsultationType(String consultationType) {
        this.consultationType = consultationType;
    }
}