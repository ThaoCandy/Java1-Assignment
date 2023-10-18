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
public class TiepThi extends NhanVien {

    private double doanhSo;
    private double tiLeHH;

    public TiepThi() {
    }

    public TiepThi(String hoTen, String maNV, double luong, double doanhSo, double tiLeHH) {
        super(hoTen, maNV, luong);
        this.doanhSo = doanhSo;
        this.tiLeHH = tiLeHH;
    }

    public double getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(double doanhSo) {
        this.doanhSo = doanhSo;
    }

    public double getTiLeHH() {
        return tiLeHH;
    }

    public void setTiLeHH(double tiLeHH) {
        this.tiLeHH = tiLeHH;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        super.input();
        
        String nhap;
        while(true){
            System.out.print("\t doanh số: ");
            nhap = sc.nextLine();
            if(nhap.matches(fm)){
                doanhSo = Double.parseDouble(nhap);
                break;
            }
        }
        while(true){
            System.out.print("\t tỉ lệ HH: ");
            nhap = sc.nextLine();
            if(nhap.matches(fm)){
                tiLeHH = Double.parseDouble(nhap);
                break;
            }
        }
        
    }
    
    public double getThuNhap(){
        double thuNhap = getLuong() + doanhSo * tiLeHH;
        return thuNhap;
    }
    
   
    public void hienThiTT() {
        System.out.printf(" %s: TT - %s \t lương CB: %.0f \t "
                + "thuế TN: %.0f \t doanh số: %.0f \t tỷ lệ HH: %.1f\n",
                getHoTen(), getMaNV(), getLuong(),
                super.getThue(getThuNhap()), doanhSo, tiLeHH );
    }

}
