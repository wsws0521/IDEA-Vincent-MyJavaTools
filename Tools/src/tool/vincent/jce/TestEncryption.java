package tool.vincent.jce;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 不好使
 *
 * 项目依赖   spring-cloud-config-server
 * 便会自带 /encrypt 和 /decrypt 端点
 * 通过 key密钥  去加解密  详见  微服务 9.7.2
 */
public class TestEncryption {
    private SecretKey key;
    // 加密算法，JCE可用DES,DESede和Blowfish
    private static final String algorithm = "DES";

    public TestEncryption() throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance(algorithm);
        key = generator.generateKey();
    }

    public String encryptData(String s) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher c = Cipher.getInstance(algorithm);
        c.init(Cipher.ENCRYPT_MODE, key);
        return new String(c.doFinal(s.getBytes()));
    }

    public String decryptData(String s) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher c = Cipher.getInstance(algorithm);
        c.init(Cipher.DECRYPT_MODE, key);
        return new String(c.doFinal(s.getBytes()));
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        String s = "hello";
        TestEncryption test = new TestEncryption();
        String encryption = test.encryptData(s);
        System.out.println(encryption);
        String decryption = test.decryptData(encryption);
        System.out.println(decryption);
    }
}
