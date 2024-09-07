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
public class PasswordDecryption {
    public static String getDecryptedPassword(String password){
        Base64.Decoder dn = Base64.getDecoder();
        return new String(dn.decode(password));
    }
}

