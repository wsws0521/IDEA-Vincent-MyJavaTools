package webserviceTest;

/*     */ 
/*     */ import com.sun.crypto.provider.SunJCE;
/*     */ import java.io.PrintStream;
/*     */ import java.security.Key;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.Security;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.spec.SecretKeySpec;
/*     */ 
/*     */ public class TdDES
/*     */ {
/* 104 */   public static String deskey = "{PONY}";
/*     */ 
/*     */   public static String encrypt(String strKey, String strIn)
/*     */     throws Exception
/*     */   {
/*  15 */     Security.addProvider(new SunJCE());
/*  16 */     Key key = getKey(strKey);
/*     */ 
/*  18 */     Cipher encryptCipher = Cipher.getInstance("DES");
/*  19 */     encryptCipher.init(1, key);
/*     */ 
/*  21 */     return byteArr2HexStr(encryptCipher.doFinal(strIn.getBytes()));
/*     */   }
/*     */ 
/*     */   public static String decrypt(String strKey, String strIn) throws Exception {
/*  25 */     Security.addProvider(new SunJCE());
/*  26 */     Key key = getKey(strKey);
/*     */ 
/*  28 */     Cipher decryptCipher = Cipher.getInstance("DES");
/*  29 */     decryptCipher.init(2, key);
/*  30 */     return new String(decryptCipher.doFinal(hexStr2ByteArr(strIn)));
/*     */   }
/*     */ 
/*     */   private static Key getKey(String strKey) throws Exception
/*     */   {
/*  35 */     byte[] arrBTmp = strKey.getBytes();
/*  36 */     byte[] arrB = new byte[8];
/*     */ 
/*  38 */     for (int i = 0; (i < arrBTmp.length) && (i < arrB.length); i++) {
/*  39 */       arrB[i] = arrBTmp[i];
/*     */     }
/*     */ 
/*  42 */     Key key = new SecretKeySpec(arrB, "DES");
/*     */ 
/*  44 */     return key;
/*     */   }
/*     */ 
/*     */   private static String byteArr2HexStr(byte[] arrB) throws Exception {
/*  48 */     int iLen = arrB.length;
/*     */ 
/*  50 */     StringBuffer sb = new StringBuffer(iLen * 2);
/*  51 */     for (int i = 0; i < iLen; i++) {
/*  52 */       int intTmp = arrB[i];
/*     */ 
/*  54 */       while (intTmp < 0) {
/*  55 */         intTmp += 256;
/*     */       }
/*     */ 
/*  58 */       if (intTmp < 16) {
/*  59 */         sb.append("0");
/*     */       }
/*  61 */       sb.append(Integer.toString(intTmp, 16));
/*     */     }
/*  63 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   private static byte[] hexStr2ByteArr(String strIn) throws Exception {
/*  67 */     byte[] arrB = strIn.getBytes();
/*  68 */     int iLen = arrB.length;
/*     */ 
/*  70 */     byte[] arrOut = new byte[iLen / 2];
/*  71 */     for (int i = 0; i < iLen; i += 2) {
/*  72 */       String strTmp = new String(arrB, i, 2);
/*  73 */       arrOut[(i / 2)] = (byte)Integer.parseInt(strTmp, 16);
/*     */     }
/*  75 */     return arrOut;
/*     */   }
/*     */ 
/*     */   public static String Md5(String inStr) throws Exception {
/*  79 */     MessageDigest md5 = null;
/*     */     try {
/*  81 */       md5 = MessageDigest.getInstance("MD5");
/*     */     } catch (Exception e) {
/*  83 */       System.out.println(e.toString());
/*  84 */       e.printStackTrace();
/*     */     }
/*  86 */     char[] charArray = inStr.toCharArray();
/*  87 */     byte[] byteArray = new byte[charArray.length];
/*     */ 
/*  89 */     for (int i = 0; i < charArray.length; i++) {
/*  90 */       byteArray[i] = (byte)charArray[i];
/*     */     }
/*  92 */     byte[] md5Bytes = md5.digest(byteArray);
/*     */ 
/*  94 */     StringBuffer hexValue = new StringBuffer();
/*     */ 
/*  96 */     for (int i = 0; i < md5Bytes.length; i++) {
/*  97 */       int val = md5Bytes[i] & 0xFF;
/*  98 */       if (val < 16)
/*  99 */         hexValue.append("0");
/* 100 */       hexValue.append(Integer.toHexString(val));
/*     */     }
/* 102 */     return hexValue.toString();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 106 */     String pwdstr = "hx888888";
/*     */     try {
/* 108 */       String pwd = encrypt(deskey, pwdstr);
/* 109 */       System.out.println("传输的密文为:" + pwd);
/*     */     }
/*     */     catch (Exception e) {
/* 112 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }

