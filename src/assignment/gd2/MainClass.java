/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.gd2;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class MainClass {
    static QuanLyNV QLNV = new QuanLyNV();
    public static void main(String[] args) {
       // Danh sách tạo sẵn - phục vụ test các chức năng một cách nhanh chóng
//        QLNV.addOb(new NhanVien("thao", "01", 10000000));
//        QLNV.addOb(new TiepThi("Ánh", "02", 18000000, 3000, 3));
//        QLNV.addOb(new TruongPhong("Nam", "03", 32000000, 500000));
//        QLNV.addOb(new NhanVien("Hải", "04", 8000000));
//        QLNV.addOb(new TiepThi("Yến", "03", 27000000, 2000, 3));
//        QLNV.addOb(new TruongPhong("Sáng", "04", 29000000, 200000));

       memu();
    }

    public static void memu() {
        Scanner sc = new Scanner(System.in);
        try {
            int chose;
            do {
                System.out.println("\n\n\t RỒNG VIỆT");
                System.out.println("+--------------------------+");
                System.out.println("1. Nhập danh sách nhân viên");
                System.out.println("2. Xuất danh sách nhân viên");
                System.out.println("3. Tìm nhân viên theo mã");
                System.out.println("4. Xóa nhân viên theo mã");
                System.out.println("5. Cập nhật thông tin nhân viên theo mã");
                System.out.println("6. Tìm các nhân viên theo khoảng lương");
                System.out.println("7. Sắp xếp tăng dần theo họ tên");
                System.out.println("8. Sắp xếp tăng dần theo thu nhập");
                System.out.println("9. 5 nhân viên thu nhập cao nhất");
                System.out.println("0. Thoát!");
                System.out.println("+--------------------------+");
                System.out.print("Mời chọn: ");
                chose = sc.nextInt();
                sc.nextLine();

                switch (chose) {
                    case 1:
                        System.out.println("Chức năng 1: Nhập danh sách nhân viên.");
                        System.out.println("LƯU Ý: Chọn đúng vị trí nhân viên như sau: \n"
                                + " [1]-Hành chính; [2]-Tiếp thị; [3]-Trưởng phòng");

                        QLNV.nhapDS();
                        break;
                    case 2:
                        System.out.println("Chức năng 2: Hiển thị danh sách nhân viên.\n");
                        QLNV.xuat(QLNV.getList());
                        break;
                    case 3:
                        QLNV.timTheoMa();
                        break;
                    case 4:
                        QLNV.xoaTheoMa();
                        break;
                    case 5:
                        QLNV.capNhat();
                        break;
                    case 6:
                        QLNV.timTheoKhoangLuong();
                        break;
                    case 7:
                        QLNV.xepTheoHoTen();
                        break;
                    case 8:
                        QLNV.xepTheoThuNhap();
                        break;
                    case 9:
                        QLNV.namNVThuNhapCaoNhat();
                        break;
                    case 0:
                        System.out.println("KẾT THÚC CHƯƠNG TRÌNH.\nCảm ơn và hẹn gặp lại!");
                        break;
                    default:
                        System.out.println("CHÚ Ý: Chọn không hợp lệ. Hãy chọn lại!");
                        break;
                }
            } while (chose != 0);

        } catch (Exception e) {
            System.out.println("\nCHƯƠNG TRÌNH BỊ DÁN ĐOẠN.\n Bạn phải nhập đúng kiểu hợp lệ!");
            memu();
        }
    }

}
