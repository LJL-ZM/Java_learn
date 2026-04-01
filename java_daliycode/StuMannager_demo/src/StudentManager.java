import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class StudentManager {
    private static final String FILE_PATH = "students.txt";
    private static final int INITIAL_CAPACITY = 10;
    private static String[] names = new String[INITIAL_CAPACITY];
    private static String[] ids = new String[INITIAL_CAPACITY];
    private static int[] chineseScores = new int[INITIAL_CAPACITY];
    private static int[] mathScores = new int[INITIAL_CAPACITY];
    private static int[] englishScores = new int[INITIAL_CAPACITY];
    private static int[] totalScores = new int[INITIAL_CAPACITY];
    private static int size = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadData();
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    sortById();
                    break;
                case 6:
                    sortByTotalScore();
                    break;
                case 7:
                    saveData();
                    System.out.println("系统已退出，数据已保存。");
                    return;
                default:
                    System.out.println("无效选项，请重新选择。");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n===== 学生信息管理系统 =====");
        System.out.println("1. 添加学生信息");
        System.out.println("2. 查看所有学生信息");
        System.out.println("3. 修改学生信息");
        System.out.println("4. 删除学生信息");
        System.out.println("5. 按学号排序");
        System.out.println("6. 按总成绩排序");
        System.out.println("7. 退出系统");
        System.out.print("请选择操作：");
    }

    private static void ensureCapacity() {
        if (size == names.length) {
            int newCapacity = names.length * 2;
            names = Arrays.copyOf(names, newCapacity);
            ids = Arrays.copyOf(ids, newCapacity);
            chineseScores = Arrays.copyOf(chineseScores, newCapacity);
            mathScores = Arrays.copyOf(mathScores, newCapacity);
            englishScores = Arrays.copyOf(englishScores, newCapacity);
            totalScores = Arrays.copyOf(totalScores, newCapacity);
        }
    }

    private static void loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                ensureCapacity();
                String[] parts = line.split(",");
                names[size] = parts[0];
                ids[size] = parts[1];
                chineseScores[size] = Integer.parseInt(parts[2]);
                mathScores[size] = Integer.parseInt(parts[3]);
                englishScores[size] = Integer.parseInt(parts[4]);
                totalScores[size] = chineseScores[size] + mathScores[size] + englishScores[size];
                size++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("数据文件不存在，将创建新文件。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (int i = 0; i < size; i++) {
                bw.write(names[i] + "," + ids[i] + "," + chineseScores[i] + "," + mathScores[i] + "," + englishScores[i]);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addStudent() {
        ensureCapacity();
        System.out.print("请输入学生姓名：");
        String name = scanner.nextLine();
        System.out.print("请输入学生学号：");
        String id = scanner.nextLine();
        System.out.print("请输入语文成绩：");
        int chinese = scanner.nextInt();
        System.out.print("请输入数学成绩：");
        int math = scanner.nextInt();
        System.out.print("请输入英语成绩：");
        int english = scanner.nextInt();
        scanner.nextLine();

        names[size] = name;
        ids[size] = id;
        chineseScores[size] = chinese;
        mathScores[size] = math;
        englishScores[size] = english;
        totalScores[size] = chinese + math + english;
        size++;
        saveData();
        System.out.println("学生信息添加成功！");
    }

    private static void viewStudents() {
        if (size == 0) {
            System.out.println("暂无学生信息。");
            return;
        }
        System.out.println("\n===== 学生信息列表 =====");
        for (int i = 0; i < size; i++) {
            System.out.printf("序号：%d | 姓名：%s | 学号：%s | 语文：%d | 数学：%d | 英语：%d | 总分：%d%n",
                    i + 1, names[i], ids[i], chineseScores[i], mathScores[i], englishScores[i], totalScores[i]);
        }
    }

    private static int findIndexById(String id) {
        for (int i = 0; i < size; i++) {
            if (ids[i].equals(id)) {
                return i;
            }
        }
        return -1;
    }

    private static void updateStudent() {
        System.out.print("请输入要修改的学生学号：");
        String id = scanner.nextLine();
        int index = findIndexById(id);
        if (index == -1) {
            System.out.println("未找到该学号的学生。");
            return;
        }

        System.out.print("请输入新的学生姓名（原：" + names[index] + "）：");
        String name = scanner.nextLine();
        System.out.print("请输入新的语文成绩（原：" + chineseScores[index] + "）：");
        int chinese = scanner.nextInt();
        System.out.print("请输入新的数学成绩（原：" + mathScores[index] + "）：");
        int math = scanner.nextInt();
        System.out.print("请输入新的英语成绩（原：" + englishScores[index] + "）：");
        int english = scanner.nextInt();
        scanner.nextLine();

        names[index] = name;
        chineseScores[index] = chinese;
        mathScores[index] = math;
        englishScores[index] = english;
        totalScores[index] = chinese + math + english;
        saveData();
        System.out.println("学生信息修改成功！");
    }

    private static void deleteStudent() {
        System.out.print("请输入要删除的学生学号：");
        String id = scanner.nextLine();
        int index = findIndexById(id);
        if (index == -1) {
            System.out.println("未找到该学号的学生。");
            return;
        }

        for (int i = index; i < size - 1; i++) {
            names[i] = names[i + 1];
            ids[i] = ids[i + 1];
            chineseScores[i] = chineseScores[i + 1];
            mathScores[i] = mathScores[i + 1];
            englishScores[i] = englishScores[i + 1];
            totalScores[i] = totalScores[i + 1];
        }
        size--;
        saveData();
        System.out.println("学生信息删除成功！");
    }

    private static void swap(int i, int j) {
        String tempName = names[i];
        names[i] = names[j];
        names[j] = tempName;

        String tempId = ids[i];
        ids[i] = ids[j];
        ids[j] = tempId;

        int tempChinese = chineseScores[i];
        chineseScores[i] = chineseScores[j];
        chineseScores[j] = tempChinese;

        int tempMath = mathScores[i];
        mathScores[i] = mathScores[j];
        mathScores[j] = tempMath;

        int tempEnglish = englishScores[i];
        englishScores[i] = englishScores[j];
        englishScores[j] = tempEnglish;

        int tempTotal = totalScores[i];
        totalScores[i] = totalScores[j];
        totalScores[j] = tempTotal;
    }

    private static void sortById() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (ids[j].compareTo(ids[j + 1]) > 0) {
                    swap(j, j + 1);
                }
            }
        }
        System.out.println("已按学号排序。");
        viewStudents();
    }

    private static void sortByTotalScore() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (totalScores[j] < totalScores[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
        System.out.println("已按总成绩排序（从高到低）。");
        viewStudents();
    }
}