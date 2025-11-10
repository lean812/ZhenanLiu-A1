/**
 * 预约类（Part4必做）
 * 功能：存储患者预约信息，关联对应的健康专业人员
 */
public class Appointment {
    // 必选实例变量（Part4要求）
    private String patientName;    // 患者姓名
    private String patientMobile;  // 患者手机号（用于取消预约，唯一标识）
    private String timeSlot;       // 预约时间段（格式如“08:30”“14:15”）
    private HealthProfessional doctor; // 预约的医生（多态：支持全科/心内科医生）

    // 1. 默认构造函数（无参，Part4必做）
    public Appointment() {
        this.patientName = "未填写";
        this.patientMobile = "未填写";
        this.timeSlot = "未预约";
        this.doctor = new HealthProfessional();
    }

    // 2. 全参构造函数（初始化所有实例变量，Part4必做）
    public Appointment(String patientName, String patientMobile, String timeSlot, HealthProfessional doctor) {
        this.patientName = patientName;
        this.patientMobile = patientMobile;
        this.timeSlot = timeSlot;
        this.doctor = doctor;
    }

    // 3. 打印预约详情（Part4必做，含所有实例变量）
    public void printAppointmentInfo() {
        System.out.println("预约详情：");
        System.out.println("  - 患者姓名：" + this.patientName);
        System.out.println("  - 患者手机号：" + this.patientMobile);
        System.out.println("  - 预约时间段：" + this.timeSlot);
        System.out.println("  - 预约医生信息：");
        this.doctor.printBasicInfo(); // 多态体现：自动调用对应医生子类的打印方法
    }

    // Getter/Setter（Part5取消预约需读取手机号，必写）
    public String getPatientMobile() {
        return patientMobile;
    }

    public void setPatientMobile(String patientMobile) {
        this.patientMobile = patientMobile;
    }

    public HealthProfessional getDoctor() {
        return doctor;
    }

    public void setDoctor(HealthProfessional doctor) {
        this.doctor = doctor;
    }
}
