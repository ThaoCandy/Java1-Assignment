/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.gd2;

import java.text.Collator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author user
 */
public class QuanLyNV {

    private static ArrayList<NhanVien> list = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);
    
    public void addOb(NhanVien x){
        list.add(x);
    }

    public QuanLyNV() {
    }

    public ArrayList<NhanVien> getList() {
        return list;
    }

    public void setList(ArrayList<NhanVien> list) {
        this.list = list;
    }

    // hàm chung cho 2 hàm nhapDS() & capNhat()
    public static void nhapChung(int CN, int index) {
        String fm_vt = "[1-3]{1}"; // bắt người dùng nhập đúng 1~3
        String vt1;
        while (true) {
            System.out.print("\t vị trí: ");
            vt1 = sc.nextLine();
            if (vt1.matches(fm_vt)) {
                break;
            }
        }
        int vt = Integer.parseInt(vt1);

        if (vt == 1) {
            System.out.println("\t --> hành chính");
            NhanVien hc = new NhanVien();
            hc.input();

            if (CN == 1) {
                list.add(hc);
            } else if (CN == 2) {
                list.set(index, hc);
            }

        } else if (vt == 2) {
            System.out.println("\t --> tiếp thị");
            TiepThi tt = new TiepThi();
            tt.input();
            if (CN == 1) {
                list.add(tt);
            } else if (CN == 2) {
                list.set(index, tt);
            }

        } else if (vt == 3) {
            System.out.println("\t --> trưởng phòng");
            TruongPhong tp = new TruongPhong();
            tp.input();
            if (CN == 1) {
                list.add(tp);
            } else if (CN == 2) {
                list.set(index, tp);
            }
        }
    }

    public void nhapDS() {
        int i = 0;
        while (true) {
            System.out.println("Nhân viên thứ " + (++i) + " :");

            nhapChung(1, -1); // CN=1 gọi chức năng nhập danh sách

            System.out.print("nhập nữa không? Y/N: ");
            if (sc.nextLine().equalsIgnoreCase("n")) {
                break;
            }
        }
        System.out.printf("==> Có tất cả %d nhân viên được nhập thành công.", i);
    }

    public void xuat(ArrayList<NhanVien> A) {
        if (A.isEmpty()) {
            System.out.println("Danh sách còn rỗng");
            return;
        }
        System.out.printf("----- %d nhân viên -----\n", A.size());
        int i = 1;
        for (NhanVien nv : A) {
            System.out.printf(" %d.", i);
            nv.hienThiTT();
            i++;
        }
    }

    public static NhanVien find(String ma) {
        NhanVien NV = null;
        for (NhanVien nv : list) {
            if (ma.equalsIgnoreCase(nv.getMaNV())) {
                NV = nv;
                break;
            }
        }
        return NV;
    }
    public static ArrayList<NhanVien> findA(String ma){
        ArrayList<NhanVien> Arr = new ArrayList<>();
        for (NhanVien nv : list) {
            if(nv.getMaNV().equalsIgnoreCase(ma)){
                Arr.add(nv);
            }
        }
        return Arr;
    }
    public void timTheoMa() {
        if (list.isEmpty()) {
            System.out.println("Danh sách còn rỗng");
            return;
        }
        System.out.println("Chức năng 3: Tìm và hiển thị nhân viên theo mã.");

        System.out.print("Mời nhập mã nhân viên cần tìm: ");
        String ma;
        do {
            ma = sc.nextLine();
        } while (ma.isEmpty());
        
        if (findA(ma).isEmpty()) {
            System.out.println("Không có nhân viên nào có mã " + ma);
        } else {
            xuat(findA(ma));
        }
    }

    public void xoaTheoMa() {
        if (list.isEmpty()) {
            System.out.println("Danh sách còn rỗng");
            return;
        }
        System.out.println("Chức năng 4: Xóa nhân viên theo mã");
        System.out.print("Mời nhập mã nhân viên muốn xóa: ");
        String ma;
        do {
            ma = sc.nextLine();
        } while (ma.isEmpty());
        
        if (findA(ma).isEmpty()) {
            System.out.println("Không có nhân viên nào có mã " + ma);
        } else {
            xuat(findA(ma));
            System.out.print("Bạn có chắc muốn xóa (các)nhân viên này không?\nChọn [y / n-nhấn phím bất kỳ]: ");

            if (sc.nextLine().equalsIgnoreCase("y")) {
                list.removeAll(findA(ma));
                System.out.println("--> Xóa thành công.");
            } else {
                System.out.println("Không có nhân viên nào được xóa.");
            }
        }
    }

    public void capNhat() {
        if (list.isEmpty()) {
            System.out.println("Danh sách còn rỗng");
            return;
        }
        System.out.println("Chức năng 5: Cập nhật thông tin nhân viên.");
        System.out.print("Mời nhập mã nhân viên cần cập nhật: ");
        String ma;
        do {
            ma = sc.nextLine();
        } while (ma.isEmpty());

        if (find(ma) == null) {
            System.out.println("Không có nhân viên nào có mã " + ma);
        } else {
            int index = list.indexOf(find(ma));
            for (NhanVien nv : list) {
                if(nv.getMaNV().equalsIgnoreCase(ma)){
                    nv.hienThiTT();
                    nhapChung(2, list.indexOf(nv));
                }
            }
            System.out.println("Cập nhật thành công!");
        }
    }

    public void timTheoKhoangLuong() {
        if (list.isEmpty()) {
            System.out.println("Danh sách còn rỗng");
            return;
        }
        System.out.println("Chức năng 6: Tìm các nhân viên theo khoảng lương.");
        System.out.print("Mời nhập giá trị nhỏ nhất: ");
        double minV = Double.parseDouble(sc.nextLine());
        System.out.print("Mời nhập giá trị lớn nhất: ");
        double maxV = Double.parseDouble(sc.nextLine());

        System.out.println("-----------");
        int i = 0;
        for (NhanVien nv : list) {
            if (nv.getLuong() >= minV && nv.getLuong() <= maxV) {
                System.out.printf(" %d.", (i + 1));
                nv.hienThiTT();
                i++;
            }
        }
        if (i == 0) {
            System.out.println("==> KHÔNG có nhân viên nào thỏa mãn điều kiện trên.");
        }
    }

    static Comparator<NhanVien> vnComp = new Comparator<NhanVien>() {
        @Override
        // thư viện Collator giúp xử lý phân biệt ngôn ngữ, kí tự, hoa/thường, mã uni
        // giúp so sánh trên mức độ phân biệt Primary, Secondary,.... mà có thể điều chỉnh
        // thông thường PC chỉ công nhận- ưu tiên so sánh EN
        public int compare(NhanVien e1, NhanVien e2) {
            Collator collator = Collator.getInstance(java.util.Locale.forLanguageTag("vi-VN"));
            collator.setStrength(Collator.PRIMARY);
            return collator.compare(e1.getHoTen(), e2.getHoTen());
        }
    };

    public void xepTheoHoTen() {
        if (list.isEmpty()) {
            System.out.println("Danh sách còn rỗng");
            return;
        }
        System.out.println("Chức năng 7: Danh sách nhân viên tăng dần theo họ tên.");
        ArrayList<NhanVien> listClone = (ArrayList<NhanVien>) list.clone();
        Collections.sort(listClone, vnComp);
        xuat(listClone);
    }

    public void xepTheoThuNhap() {
        if (list.isEmpty()) {
            System.out.println("Danh sách còn rỗng");
            return;
        }
        
        System.out.println("Chức năng 8: Danh sách nhân viên tăng dần theo thu nhập");
        System.out.println("\t (thu nhập là tổng các khoản lương,...)");
        ArrayList<NhanVien> listClone = (ArrayList<NhanVien>) list.clone();
        listClone.sort(
                (o1, o2) -> {
                    return Double.compare(o1.getThuNhap(), o2.getThuNhap());
                }
        );
        xuat(listClone);
    }

    public void namNVThuNhapCaoNhat() {
        if (list.isEmpty()) {
            System.out.println("Danh sách còn rỗng");
            return;
        }
        System.out.println("Chức năng 9: Danh sách 5 nhân viên thu nhập cao nhất");
        ArrayList<NhanVien> listClone = (ArrayList<NhanVien>) list.clone();
        listClone.sort(
                (o1, o2) -> {
                    return Double.compare(o2.getThuNhap(), o1.getThuNhap());
                }
        );
        int i = 1;
        for (NhanVien nv : listClone) {
            System.out.printf("%d.", i);
            nv.hienThiTT();
            i++;
            if (i == 6) {
                break;
            }
        }
    }

}
