package ge;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Steve Mk
 */
public class LocaleDemo {
public static void main(String []args){
      String lang = "hi";
  String country = "IN";
  
  Locale l = new Locale(lang, country);
  
  ResourceBundle r = ResourceBundle.getBundle("localedemo/Bundle",l);
  
  String str = r.getString("Wish");
  System.out.println(str);
}
  
 
}