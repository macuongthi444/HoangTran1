/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.pkg73;

/**
 *
 * @author hoang
 */
import common.validate;
import java.util.ArrayList;
import java.util.List;
import model.expense;
public class expenselist {
    List<expense> list = new ArrayList<>(); //luu tru danh sach chi phí
    validate check = new validate();

    public List<expense> getList() {  //tra ve danh sach chi phi
        return list;
    }
    public void setList(List<expense> list) { //dat danh sach chi phi vao danh sach da chi dinh         
        this.list = list;
    }
    //them chi phi moi vao danh sach
    public void addExpense(expense e) {
        //add expense to list
        list.add(e);
    }
    //xoa di chi phi chi dinh
    public void removeExpense(int id) {
        
        //point to each expense in list
        for (int i = 0; i < sizeList(); i++) { //lap qua tung phan tu
            expense e = list.get(i);
            
            if (e.getId() == id) { //neu id chi dinh co trong danh sach
                list.remove(i);   //id do se bi xoa 
                resetID(i);     //lap lai cac thu tu id moi bat dau tu 1 
                return;
            }
        }
    }
    public void resetID(int n) {
        for (int i = n; i < sizeList(); i++) { //lap qua tung phan tu
            expense e = list.get(i);  //truy xuat chi phi va luu tru trong bien e
            e.setId(i+1);  //dat id duy nhat cho 1 chi phi va tang dan 
        }
    }
    
    //bieu thi kich thuoc cua 1 danh sach
    public int sizeList() {
        int size = list.size();
        return size;
    }
    //kiem tra id da ton tai hay chua
    public int checkIdExist(int id) {
        for (int i = 0; i < sizeList(); i++) { //lap qua danh sach
            if (list.get(i).getId() == id) { //kiem tra neu gia tri khop voi ID da cho 
                return i;           //thi tra ve i
            }
        }
        return -1; //neu khong tim thay id phu hop se tra ve -1
    }
}
