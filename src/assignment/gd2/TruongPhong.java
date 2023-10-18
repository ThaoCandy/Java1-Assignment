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
public class TruongPhong extends NhanVien{
    private double luongTN;

    public TruongPhong() {
    }
    
    public TruongPhong(String hoTen, String maNV, double luong, double luongTN) {
        super(hoTen, maNV, luong);
        this.luongTN = luongTN;
    }

    public double getLuongTN() {
        return luongTN;
    }

    public void setLuongTN(double luongTN) {
        this.luongTN = luongTN;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        super.input();
        
        String nhap;
        while(true){
            System.out.print("\t lương TN: ");
            nhap = sc.nextLine();
            if(nhap.matches(fm)){
                luongTN = Double.parseDouble(nhap);
                break;
            }
        }
    }
    
    public double getThuNhap(){
        double thuNhap = getLuong() + luongTN;
        return thuNhap;
    }
    
    public void hienThiTT() {
        System.out.printf(" %s: TP - %s \t lương CB: %.0f \t "
                + "thuế TN: %.0f \t lương TN: %.0f\n",
                getHoTen(), getMaNV(), getLuong(),
                super.getThue(getThuNhap()), luongTN); 
    }
}
