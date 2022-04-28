package main;

import manager.StaffManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StaffManagement staffManagement = new StaffManagement();
        Scanner scanner = new Scanner(System.in);

        String displayStaff = "    HIỂN THỊ NHÂN VIÊN\n" +
                "                1.Nhân viên FullTime\n" +
                "                2.Nhân viên PartTime";

        int choice = -1;
        do {
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("-----------------------------------");
            System.out.println("CHỌN CHƯƠNG TRÌNH QUẢN LÝ NHÂN VIÊN");
            System.out.println("1.Hiển thị tất cả nhân viên");
            System.out.println("2.Thêm nhân viên");
            System.out.println("3. Tìm kiếm nhân viên");
            System.out.println("4.In ra danh sách nhân viên full time");
            System.out.println("5.Sửa nhân viên");
            System.out.println("6.Đổi trạng thái của nhân viên (Đang làm hoặc nghỉ");
            System.out.println("7.Tính tổng lương các nhân viên");
            System.out.println("8.Thoát");
            System.out.println("-----------------------------------");


            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        staffManagement.displayAll();
                        break;
                    case 2:
                        staffManagement.addStaff();
                        break;
                    case 3:
                        scanner.nextLine();
                        System.out.println("Nhập tên mà bạn muốn tìm kiếm");
                        String searchByName = scanner.nextLine();
                        staffManagement.searchByName(searchByName);

                        break;
                    case 4:
                        int choice2 = -1;
                        do {
                            System.out.println(displayStaff);
                            System.out.println("Nhập lựa chọn");
                            scanner.nextLine();
                            choice2 = Integer.parseInt(scanner.nextLine());
                            switch (choice2) {
                                case 1:
                                    System.out.println("1.Hiển thị nhân viên FullTime");
                                    staffManagement.pritnFullTime();
                                    System.out.println("-----------------------------");
                                    break;
                                case 2:
                                    System.out.println("2.Hiển thị nhân viên PartTime");
                                    staffManagement.pritnPartTime();
                                    System.out.println("------------------------------");
                                    break;
                                default:
                                    System.out.println("Nhập lại lựa chọn");
                            }
                        } while (choice2 != 1 && choice2 != 2);
                        break;
                    case 5:
                        break;
                    case 6:
                        System.out.println("Nhập tên Nhân viên mà bạn muốn đổi trạng thái");
                        String statusChange = scanner.nextLine();
                        staffManagement.statusChange(statusChange);
                        break;
                    case 7:
                        break;
                    case 8:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Chỉ nhập từ 1 => 8 để chọn chức năng");
                }
            } catch (Exception e) {
                System.out.println("Chỉ được nhập số từ 1 => 8");
            }
            scanner.nextLine();
        }
        while (choice != 0);
    }
}