package webserviceTest;

/*    */ 
/*    */ public class TdExprExtend
/*    */ {
/*  5 */   public static String deskey = "{PONY}";
/*    */ 
/*    */   public static String DESSTR(String msg)
/*    */     throws Exception
/*    */   {
/* 11 */     return TdDES.encrypt(deskey, msg);
/*    */   }
/*    */ 
/*    */   public static String DES(String msg, String strKey) throws Exception
/*    */   {
/* 16 */     return TdDES.encrypt(strKey, msg);
/*    */   }
/*    */ 
/*    */   public static String MD5STANDARD(String msg) throws Exception
/*    */   {
/* 21 */     return Md5Algorithm.getInstance().md5Digest(msg.getBytes("utf-8"));
/*    */   }

	public static void main(String[] args) throws Exception {
		System.out.println(DESSTR("td888888"));
	}
/*    */ }

/* Location:           C:\Users\HEH157\Desktop\TdExprExtend.jar
 * Qualified Name:     tangdi.aes.TdExprExtend
 * JD-Core Version:    0.6.0
 */


