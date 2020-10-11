package com.sspl.utility;

public class Checker 
{

    public static void main(String[] args) throws Exception 
    {

        String password = "1";
        String passwordEnc = AESencrp.encrypt(password);
        String passwordDec = AESencrp.decrypt(passwordEnc);

        
               
        System.out.println("Plain Text : " + password);
        System.out.println("Encrypted Text : " + passwordEnc);
        System.out.println("Decrypted Text : " + passwordDec);
        
        
   
        
              
    }
}