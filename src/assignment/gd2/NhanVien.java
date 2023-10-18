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
public class NhanVien{
    private String hoTen;
    private String maNV;
    private double luong;

    public NhanVien() {
    }

    public NhanVien(String hoTen, String maNV, double luong) {
        this.hoTen = hoTen;
        this.maNV = maNV;
        this.luong = luong;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    static String fm = "\\d+([.]\\d+)?";  // BTCQ cho số thực
    static String fm_ten = "[A-zÀ-ỹ ]+";

    
    public void input() {
        Scanner sc = new Scanner(System.in);
        
        do{
            System.out.print("\t tên: ");
            hoTen = sc.nextLine();
        }while(!hoTen.matches(fm_ten));

        do{
            System.out.print("\t mã: ");
            maNV = sc.nextLine();
        }while(maNV.isEmpty());
        
        String nhap;
        while (true) {
            System.out.print("\t lương: ");
            nhap = sc.nextLine();
            if (nhap.matches(fm)) {
                luong = Double.parseDouble(nhap);
                break;
            }
        }
    }

    // Thu Nhập < 9tr    ==> thuế bằng 0
    // 9tr <= TN <= 15tr ==> 10% TN
    // TN > 15tr         ==> 12% TN
    public double getThuNhap() {
        return this.luong;
    }

    public double getThue(double thuNhap) {
        double thue = 0;
        if (thuNhap < 9000000) {
            thue = 0;
        } else if (thuNhap >= 9000000 && thuNhap <= 15000000) {
            thue = (thuNhap - 9000000) * 0.1;
        } else if (thuNhap > 15000000) {
            thue = 6000000 * 0.1 + (thuNhap - 15000000) * 0.12;
        }
        return thue;
    }

    public void hienThiTT() {
        System.out.printf(" %s: HC - %s \t lương CB: %.0f \t thuế TN: %.0f\n",
                hoTen, maNV, luong, getThue(luong));
    }

}
