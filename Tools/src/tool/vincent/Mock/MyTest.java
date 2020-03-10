//package tool.vincent.Mock;
//
//import org.easymock.EasyMock;
//import org.junit.Test;
//
//import cn.vincent.junit.BaseDao;
//import junit.framework.TestCase;
//
//
//public class MyTest {
//	@Test
//	public void testBaseDao() {
//		// 1������mock�����Խӿ���ʽ����
//		BaseDao baseDaoMock = EasyMock.createMock(BaseDao.class);
//		// 2���趨��Ԥ�ںͷ��أ���ѯԤ��ֵ�õ����趨��Ԥ�ڽ��
//		EasyMock.expect(baseDaoMock.queryById("1")).andReturn("111abc").anyTimes();
//		// 3������¼��
//		EasyMock.replay(baseDaoMock);
//
//
//		// �Ƚ�service���õ�ֵ�Ƿ����趨��ֵ��ͬ
//		ToolService toolService = new ToolService();
//		toolService.setBaseDao(baseDaoMock);
//		String result = toolService.getInfoById("1");
//		String result2 = toolService.getInfoById("1");
//		System.out.println("result=" + result);
//		TestCase.assertNotNull(result);
//		TestCase.assertEquals("111abc", result);
//		// 4���ط�¼��
//		EasyMock.verify(baseDaoMock);
//
//	}
//
//}
