package tool.vincent.Mock;

import tool.vincent.Mock.BaseDao;

public class ToolService {
	private BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	public String getInfoById(String id) {
		return baseDao.queryById(id);
	}
}
