/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryptiondecryption;

/**
 *
 * @author Dell
 */
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;

import sun.misc.BASE64Encoder;
public class EncryptionDecryption {

    private String input; 
    private KeyGenerator keygen;
    private SecretKey secretkey;
    private Cipher allCipher;
    private byte[] plaintext;
    private byte[] ciphertext;
    private byte[] decrypttext;
    private String strciphertext;
    private String strdecrypttext;
    private int len;
    private int max_len;
    
   
    public EncryptionDecryption(String input, String al) throws Exception{
      
        secretkey = keygen.generateKey();
        
       
        allCipher = Cipher.getInstance(al+"/CBC/PKCS5Padding");
        allCipher.init(Cipher.ENCRYPT_MODE, secretkey);
        
        
        plaintext = input.getBytes();   
    }

   
    
    //Getter method to return encryption result
    public String encrypt() throws Exception{
        //Start encrypt
        ciphertext = allCipher.doFinal(plaintext);
        
        //Covert the encryption output to string
        strciphertext = new BASE64Encoder().encode(ciphertext);
        
    return strciphertext;
    }
    
    
    public String decrypt() throws Exception{
       
        allCipher.init(Cipher.DECRYPT_MODE, secretkey, allCipher.getParameters());
        
       
        decrypttext = allCipher.doFinal(ciphertext);
        
       
        strdecrypttext = new String(decrypttext);
        
        return strdecrypttext;
    }
    
    
    public int len_key(){
     
        len = strciphertext.length();
        
        return len;
    }
    
    
    public int max_len(String in) throws Exception{
        max_len = Cipher.getMaxAllowedKeyLength(in);
        
        return max_len;
    }
    
}
