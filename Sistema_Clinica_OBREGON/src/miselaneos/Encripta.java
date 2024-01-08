/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miselaneos;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.exceptions.EncryptionOperationNotPossibleException;

/**
 *
 * @author pablo
 * //http://www.jasypt.org/encrypting-texts.html
 */
public class Encripta {
    private static String key = "semilla";
    
    public String encryt(String plainText) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(key);
        String result = plainText;
        try {
            result = encryptor.encrypt(plainText);
        } catch (EncryptionOperationNotPossibleException e) {
            //log.error("Unable to encrypt", e);
        }
        return result;
    }

    public String desencrypt(String encPassword) {
        String result = null;        
        StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
        try {
            decryptor.setPassword(key);
            result = decryptor.decrypt(encPassword);
        } catch (EncryptionOperationNotPossibleException ex) {
        }
        return result;
    }
}
