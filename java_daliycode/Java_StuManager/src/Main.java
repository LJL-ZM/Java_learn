import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Major major = new Major();
        CourseManager courseManager = new CourseManager();
        ScoreManager scoreManager = new ScoreManager();

        while (true) {
            System.out.println("\n======== 学生信息管理系统 ========");
            System.out.println("1. 添加班级");
            System.out.println("2. 查看某年级所有班级");
            System.out.println("3. 查看所有课程");
            System.out.println("4. 查看班级所有学生");
            System.out.println("5. 添加学生");
            System.out.println("6. 删除学生");
            System.out.println("7. 修改学生");
            System.out.println("8. 按姓名查询学生");
            System.out.println("9. 添加课程");
            System.out.println("10. 删除课程");
            System.out.println("11. 录入成绩");
            System.out.println("12. 查询学生成绩");
            System.out.println("13. 退出系统");
            System.out.print("请输入功能编号：");
            int op = sc.nextInt();
            sc.nextLine();

            // 1. 添加班级
            if (op == 1) {
                System.out.print("请输入年级(1-4)：");
                int g = sc.nextInt();
                System.out.print("请输入班级ID：");
                int cid = sc.nextInt();
                Grade grade = major.getGrade(g);
                if (grade == null) {
                    System.out.println("年级不存在！");
                } else {
                    boolean res = grade.add(new Class(cid));
                    System.out.println(res ? "班级添加成功" : "该班级ID已存在");
                }
            }

            // 2. 查看某年级所有班级
            else if (op == 2) {
                System.out.print("请输入要查询的年级(1-4)：");
                int g = sc.nextInt();
                Grade grade = major.getGrade(g);
                if (grade == null) {
                    System.out.println("年级不存在！");
                    continue;
                }
                int size = grade.getSize();
                if (size == 0) {
                    System.out.println("该年级暂无班级");
                    continue;
                }
                System.out.println("===== 该年级所有班级 =====");
                for (int i = 0; i < size; i++) {
                    System.out.println("班级ID：" + grade.getPos(i).getId());
                }
            }

            // 3. 展示所有课程
            else if (op == 3) {
                int size = courseManager.getSize();
                if (size == 0) {
                    System.out.println("暂无任何课程");
                    continue;
                }
                System.out.println("===== 所有课程列表 =====");
                for (int i = 0; i < size; i++) {
                    Course c = courseManager.getPos(i);
                    System.out.println("课程ID:" + c.getId()
                            + " | 课程名:" + c.getName()
                            + " | 学分:" + c.getCredit());
                }
            }

            // 4. 查看班级所有学生
            else if (op == 4) {
                System.out.print("请输入年级(1-4)：");
                int g = sc.nextInt();
                Grade grade = major.getGrade(g);
                if (grade == null) {
                    System.out.println("年级不存在！");
                    continue;
                }
                if (grade.getSize() == 0) {
                    System.out.println("该年级暂无班级");
                    continue;
                }
                // 先展示该年级所有班级
                System.out.println("===== 该年级已有班级 =====");
                for (int i = 0; i < grade.getSize(); i++) {
                    System.out.println("班级ID：" + grade.getPos(i).getId());
                }
                System.out.print("请选择班级ID：");
                int cid = sc.nextInt();
                Class cls = grade.getClassById(cid);
                if (cls == null) {
                    System.out.println("班级不存在");
                    continue;
                }
                // 遍历班级所有学生
                int stuSize = cls.getSize();
                if (stuSize == 0) {
                    System.out.println("该班级暂无学生");
                    continue;
                }
                System.out.println("===== 班级所有学生 =====");
                for (int i = 0; i < stuSize; i++) {
                    System.out.println(cls.getPos(i));
                }
            }

            // 5. 添加学生
            else if (op == 5) {
                System.out.print("请输入年级(1-4)：");
                int g = sc.nextInt();
                Grade grade = major.getGrade(g);
                if (grade == null || grade.getSize() == 0) {
                    System.out.println("该年级无班级，请先添加班级");
                    continue;
                }
                System.out.println("===== 该年级已有班级 =====");
                for (int i = 0; i < grade.getSize(); i++) {
                    System.out.println("班级ID：" + grade.getPos(i).getId());
                }
                System.out.print("选择班级ID：");
                int cid = sc.nextInt();
                Class cls = grade.getClassById(cid);
                if (cls == null) {
                    System.out.println("班级不存在");
                    continue;
                }
                sc.nextLine();
                System.out.print("学生姓名：");
                String name = sc.nextLine();
                System.out.print("性别(1男 0女)：");
                int sex = sc.nextInt();
                System.out.print("年龄：");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.print("学号：");
                String sid = sc.nextLine();

                Student stu = new Student(name, sex, age, sid, cid, 1, g);
                boolean res = cls.add(stu);
                System.out.println(res ? "学生添加成功" : "该姓名学生已存在");
            }

            // 6. 删除学生
            else if (op == 6) {
                System.out.print("请输入年级(1-4)：");
                int g = sc.nextInt();
                Grade grade = major.getGrade(g);
                if (grade == null || grade.getSize() == 0) {
                    System.out.println("无班级");
                    continue;
                }
                System.out.println("===== 该年级已有班级 =====");
                for (int i = 0; i < grade.getSize(); i++) {
                    System.out.println("班级ID：" + grade.getPos(i).getId());
                }
                System.out.print("选择班级ID：");
                int cid = sc.nextInt();
                Class cls = grade.getClassById(cid);
                if (cls == null) {
                    System.out.println("班级不存在");
                    continue;
                }
                sc.nextLine();
                System.out.print("输入要删除的学生姓名：");
                String name = sc.nextLine();
                boolean res = cls.erase(name);
                System.out.println(res ? "删除成功" : "学生不存在");
            }

            // 7. 修改学生
            else if (op == 7) {
                System.out.print("请输入年级(1-4)：");
                int g = sc.nextInt();
                Grade grade = major.getGrade(g);
                if (grade == null || grade.getSize() == 0) {
                    System.out.println("无班级");
                    continue;
                }
                System.out.println("===== 该年级已有班级 =====");
                for (int i = 0; i < grade.getSize(); i++) {
                    System.out.println("班级ID：" + grade.getPos(i).getId());
                }
                System.out.print("选择班级ID：");
                int cid = sc.nextInt();
                Class cls = grade.getClassById(cid);
                if (cls == null) {
                    System.out.println("班级不存在");
                    continue;
                }
                sc.nextLine();
                System.out.print("要修改的学生姓名：");
                String name = sc.nextLine();
                System.out.print("新性别(1男0女)：");
                int sex = sc.nextInt();
                System.out.print("新年龄：");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.print("新学号：");
                String sid = sc.nextLine();

                Student s = new Student(name, sex, age, sid, cid, 1, g);
                boolean res = cls.modify(s);
                System.out.println(res ? "修改成功" : "学生不存在");
            }

            // 8. 按姓名查询学生
            else if (op == 8) {
                System.out.print("请输入年级(1-4)：");
                int g = sc.nextInt();
                Grade grade = major.getGrade(g);
                if (grade == null || grade.getSize() == 0) {
                    System.out.println("无班级");
                    continue;
                }
                System.out.println("===== 该年级已有班级 =====");
                for (int i = 0; i < grade.getSize(); i++) {
                    System.out.println("班级ID：" + grade.getPos(i).getId());
                }
                System.out.print("选择班级ID：");
                int cid = sc.nextInt();
                Class cls = grade.getClassById(cid);
                if (cls == null) {
                    System.out.println("班级不存在");
                    continue;
                }
                sc.nextLine();
                System.out.print("输入学生姓名：");
                String name = sc.nextLine();
                int pos = cls.find(name);
                if (pos == Class.NPOS) {
                    System.out.println("未找到该学生");
                } else {
                    System.out.println("学生信息：" + cls.getPos(pos));
                }
            }

            // 9. 添加课程
            else if (op == 9) {
                System.out.print("课程名称：");
                String name = sc.nextLine();
                System.out.print("课程编号ID：");
                int id = sc.nextInt();
                System.out.print("课程学分：");
                int credit = sc.nextInt();
                boolean res = courseManager.add(new Course(name, id, credit));
                System.out.println(res ? "课程添加成功" : "课程ID已存在");
            }

            // 10. 删除课程
            else if (op == 10) {
                if (courseManager.getSize() == 0) {
                    System.out.println("暂无课程可删除");
                    continue;
                }
                System.out.println("===== 所有课程 =====");
                for (int i = 0; i < courseManager.getSize(); i++) {
                    Course c = courseManager.getPos(i);
                    System.out.println(c.getName() + " | ID:" + c.getId());
                }
                sc.nextLine();
                System.out.print("输入要删除的课程名称：");
                String name = sc.nextLine();
                int cid = getCourseId(courseManager, name);
                if (cid == -1) {
                    System.out.println("课程不存在");
                } else {
                    courseManager.erase(cid);
                    System.out.println("课程删除成功");
                }
            }

            // 11. 录入成绩
            else if (op == 11) {
                if (courseManager.getSize() == 0) {
                    System.out.println("请先添加课程");
                    continue;
                }
                System.out.println("===== 所有可选课程 =====");
                for (int i = 0; i < courseManager.getSize(); i++) {
                    Course c = courseManager.getPos(i);
                    System.out.println("课程名：" + c.getName() + "  学分：" + c.getCredit());
                }
                sc.nextLine();
                System.out.print("学生姓名：");
                String stuName = sc.nextLine();
                System.out.print("课程名称：");
                String courseName = sc.nextLine();
                int cid = getCourseId(courseManager, courseName);
                if (cid == -1) {
                    System.out.println("课程不存在");
                    continue;
                }
                System.out.print("输入分数：");
                int score = sc.nextInt();
                boolean res = scoreManager.add(new Score(stuName, cid, score));
                System.out.println(res ? "成绩录入成功" : "该学生此课程成绩已存在");
            }

            // 12. 查询学生成绩
            else if (op == 12) {
                if (courseManager.getSize() == 0) {
                    System.out.println("暂无课程");
                    continue;
                }
                System.out.println("===== 所有可选课程 =====");
                for (int i = 0; i < courseManager.getSize(); i++) {
                    System.out.println("课程名：" + courseManager.getPos(i).getName());
                }
                sc.nextLine();
                System.out.print("学生姓名：");
                String stuName = sc.nextLine();
                System.out.print("课程名称：");
                String courseName = sc.nextLine();
                int cid = getCourseId(courseManager, courseName);
                if (cid == -1) {
                    System.out.println("课程不存在");
                    continue;
                }
                int pos = scoreManager.find(stuName, cid);
                if (pos == ScoreManager.NPOS) {
                    System.out.println("暂无该科成绩");
                } else {
                    System.out.println("该课程成绩：" + scoreManager.getPos(pos).getScore());
                }
            }

            // 13. 退出
            else if (op == 13) {
                System.out.println("系统退出成功！");
                break;
            }

            else {
                System.out.println("输入编号无效，请重新选择！");
            }
        }
    }

    // 根据课程名查课程ID
    public static int getCourseId(CourseManager cm, String courseName) {
        for (int i = 0; i < cm.getSize(); i++) {
            Course c = cm.getPos(i);
            if (courseName.equals(c.getName())) {
                return c.getId();
            }
        }
        return -1;
    }
}