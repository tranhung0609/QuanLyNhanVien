package manager;

import model.Staff;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StaffManagement {
    int index;
    public static final String PATH_NAME = "src\\StaffFile.csv";
    private ArrayList<Staff> staffArrayList;
    private final Scanner scanner = new Scanner(System.in);

    public StaffManagement() {
        this.staffArrayList = readFile(PATH_NAME);
    }

    public ArrayList<Staff> getStaffArrayList() {
        return staffArrayList;
    }

    public Staff addStaff() {
        System.out.println("Nhập tên Nhân Viên");
        String name = scanner.nextLine();
        System.out.println("Nhập loại hoạt động của Nhân viên // true => fulltime hoặc false => parttime");
        boolean type = scanner.nextBoolean();
        System.out.println("Nhập trạng thái của Nhân viên // true => đang làm hoặc false => thôi việc");
        boolean status = scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("Nhập lương của Nhân viên ($)");
        int salary = scanner.nextInt();
        Staff staff = new Staff(name, type, status, salary);
        staffArrayList.add(staff);
        writeFile(staffArrayList, PATH_NAME);
        scanner.nextLine();
        return staff;
    }

    public int salaryFullTime() {
        int sum1 = 0;
        for (int i = 0; i < staffArrayList.size(); i++) {
            if (staffArrayList.get(i).getType().equals("fullTime")) {
                sum1 += staffArrayList.get(i).getSalary();
            }
        }
        return sum1;
    }

    public int salaryPartTime() {
        int sum2 = 0;
        for (int i = 0; i < staffArrayList.size(); i++) {
            if (staffArrayList.get(i).getType().equals("PartTime")) {
                sum2 += staffArrayList.get(i).getSalary();
            }
        }
        return sum2;
    }

    public void displayAll() {
        for (Staff staff :
                staffArrayList) {
            System.out.println(staff);
        }
    }

//    public int searchByName(String name) {
//        for (int i = 0; i < staffArrayList.size(); i++) {
//            if (staffArrayList.get(i).getName().equals(name)) {
//                return i;
//            }
//        }
//        return -1;
//    }

    public void searchByName(String name) {
        Staff staff = null;
        for (Staff s :
                staffArrayList) {
            if (s.getName().equals(name)) {
                staff = s;
            }
        }
        if (staff != null) {
            System.out.println(staff);
        } else {
            System.out.println("Không tìm thấy nhân viên! Vui lòng nhập lại !!");
        }
    }

    public ArrayList<Staff> readFile(String path) {
        ArrayList<Staff> staffArrayList = new ArrayList<>();
        File file = new File(PATH_NAME);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",");
                staffArrayList.add(new Staff(strings[0], Boolean.parseBoolean(strings[1]), (Boolean.parseBoolean(strings[2])), Integer.parseInt(strings[3])));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return staffArrayList;
    }

    public void writeFile(ArrayList<Staff> staffArrayList, String path) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            String line = "Tên Nhân Viên, Trạng thái, Hoạt Động, Lương";
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            for (Staff staff :
                    staffArrayList) {
                bufferedWriter.write(staff.getName() + "," + staff.getType() + "," + staff.getStatus() + "," + staff.getSalary() + "\n");
            }
            bufferedWriter.close();
            System.out.println("Ghi tệp thành công!!!!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void statusChange(String name) {
        searchByName(name);
        boolean status = staffArrayList.get(index).isStatus();
        status = !status;
        staffArrayList.get(index).setStatus(status);
    }

    public void pritnFullTime(){
        int count = 0;
        for (Staff s:
             staffArrayList) {
            if (s.isType()){
                System.out.println(s);
                count++;
            }
        }
        if (count==0){
            System.out.println("Không có nhân viên FullTime");
        }
    }
    public void pritnPartTime(){
        int count = 0;
        for (Staff s:
                staffArrayList) {
            if (!s.isType()){
                System.out.println(s);
                count++;
            }
        }
        if (count==0){
            System.out.println("Không có nhân viên PartTime");
        }
    }

//    public Staff editStaff(String name){
//        Staff editStaff = null;
//        for (Staff staff:
//             staffArrayList) {
//            if (staff.getName().equals(name)){
//                editStaff=staff;
//            }
//        }
//        if (editStaff!=null){
//            int index = staffArrayList.indexOf(editStaff);
//            System.out.println("Nhập lại tên Nhân Viên");
//            editStaff.getName(scanner.nextLine());
//        }
//    }

}
