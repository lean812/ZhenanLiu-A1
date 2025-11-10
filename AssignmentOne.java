import java.util.ArrayList;

/**
 * 主类（Part3+Part5必做）
 * 功能：含main方法，演示类与对象使用（Part3）、预约集合管理（Part5）
 */
public class AssignmentOne {
    // 全局预约集合（Part5用，所有方法可访问，存储所有预约对象）
    private static ArrayList<Appointment> appointmentList = new ArrayList<>();

    public static void main(String[] args) {
        // ==================== Part3：类与对象使用（Part3要求）====================
        System.out.println("========== Part3：类与对象使用演示 ==========");
        // 1. 添加Part3注释（Part3必做）
        // Part 3 – Using classes and objects
        
        // 2. 创建3个全科医生对象（Part3必做）
        GeneralPractitioner gp1 = new GeneralPractitioner(301, "赵医生", "全科门诊", "普通门诊+慢病管理");
        GeneralPractitioner gp2 = new GeneralPractitioner(302, "孙医生", "全科门诊", "普通门诊+健康体检");
        GeneralPractitioner gp3 = new GeneralPractitioner(303, "周医生", "全科门诊", "普通门诊+儿童保健");

        // 3. 创建2个心脏病科医生对象（Part3必做）
        Cardiologist cardio1 = new Cardiologist(401, "吴医生", "心内科", "冠心病+心力衰竭");
        Cardiologist cardio2 = new Cardiologist(402, "郑医生", "心内科", "心律失常+高血压");

        // 4. 打印所有医生详情（Part3必做）
        gp1.printBasicInfo();
        gp2.printBasicInfo();
        gp3.printBasicInfo();
        cardio1.printBasicInfo();
        cardio2.printBasicInfo();

        // 5. 添加Part3分割线（Part3必做）
        System.out.println("------------------------------");
        System.out.println();


        // ==================== Part5：预约集合管理（Part5要求）====================
        System.out.println("========== Part5：预约集合管理演示 ==========");
        // 1. 添加Part5注释（Part5必做）
        // Part 5 – Collection of appointments
        
        // 2. 演示预约功能（Part5必做：2个全科+2个心内科预约）
        // 创建预约1：全科医生（赵医生）
        createAppointment("张三", "13500135001", "09:00", gp1);
        // 创建预约2：全科医生（孙医生）
        createAppointment("李四", "13500135002", "10:15", gp2);
        // 创建预约3：心内科医生（吴医生）
        createAppointment("王五", "13500135003", "14:30", cardio1);
        // 创建预约4：心内科医生（郑医生）
        createAppointment("赵六", "13500135004", "15:45", cardio2);

        // 3. 打印初始预约列表（Part5必做）
        System.out.println("【步骤1：打印所有初始预约】");
        printExistingAppointments();
        System.out.println();

        // 4. 取消1个预约（按手机号：13500135002，Part5必做）
        System.out.println("【步骤2：取消手机号为13500135002的预约】");
        cancelBooking("13500135002");
        System.out.println();

        // 5. 打印取消后的预约列表（Part5必做）
        System.out.println("【步骤3：打印取消后的预约】");
        printExistingAppointments();

        // 6. 添加Part5分割线（Part5必做）
        System.out.println("------------------------------");
    }


    // ------------------------------ Part5必实现方法 ------------------------------
    /**
     * 方法1：创建预约并添加到集合（Part5必做）
     * 功能：验证信息完整性，支持全科/心内科医生预约（多态）
     * @param patientName 患者姓名
     * @param patientMobile 患者手机号
     * @param timeSlot 预约时间段
     * @param doctor 预约的医生（多态参数：GeneralPractitioner/Cardiologist）
     */
    public static void createAppointment(String patientName, String patientMobile, String timeSlot, HealthProfessional doctor) {
        // 验证所有信息是否齐全（Part5要求：信息不全则不创建）
        if (patientName == null || patientName.trim().isEmpty() ||
            patientMobile == null || patientMobile.trim().isEmpty() ||
            timeSlot == null || timeSlot.trim().isEmpty() ||
            doctor == null) {
            System.out.println("预约创建失败！患者姓名、手机号、时间段、医生信息均不可为空！");
            return;
        }

        // 信息齐全：创建预约对象并加入集合
        Appointment newAppt = new Appointment(patientName, patientMobile, timeSlot, doctor);
        appointmentList.add(newAppt);
        System.out.println("预约创建成功！患者：" + patientName + " | 预约医生：" + doctor.getName());
    }

    /**
     * 方法2：打印现有预约（Part5必做）
     * 功能：无预约时提示，有预约则遍历打印
     */
    public static void printExistingAppointments() {
        if (appointmentList.isEmpty()) {
            System.out.println("当前无任何预约记录！");
            return;
        }

        // 遍历集合，打印每个预约详情
        for (int i = 0; i < appointmentList.size(); i++) {
            System.out.println("【第" + (i + 1) + "个预约】");
            appointmentList.get(i).printAppointmentInfo();
            if (i != appointmentList.size() - 1) {
                System.out.println("----------------------------------------");
            }
        }
    }

    /**
     * 方法3：按手机号取消预约（Part5必做）
     * 功能：找到匹配手机号的预约并删除，未找到则提示
     * @param targetMobile 待取消预约的患者手机号
     */
    public static void cancelBooking(String targetMobile) {
        boolean isCancelled = false;

        // 遍历集合查找匹配手机号的预约
        for (int i = 0; i < appointmentList.size(); i++) {
            Appointment appt = appointmentList.get(i);
            if (appt.getPatientMobile().equals(targetMobile)) {
                appointmentList.remove(i); // 删除预约
                System.out.println("预约取消成功！已删除手机号为" + targetMobile + "的预约");
                isCancelled = true;
                break; // 假设手机号唯一，找到后退出循环
            }
        }

        // 未找到匹配预约时提示
        if (!isCancelled) {
            System.out.println("预约取消失败！未找到手机号为" + targetMobile + "的预约记录");
        }
    }
}
