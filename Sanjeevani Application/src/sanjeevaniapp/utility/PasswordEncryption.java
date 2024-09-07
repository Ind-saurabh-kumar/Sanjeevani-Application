/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanjeevaniapp.utility;

import java.util.Base64;

/**
 *
 * @author TANMAY KUMAR
 */
public class PasswordEncryption {
    public static String getEncryptedPassword(String password){
        Base64.Encoder en = Base64.getEncoder();
        return en.encodeToString(password.getBytes());
    }
}
