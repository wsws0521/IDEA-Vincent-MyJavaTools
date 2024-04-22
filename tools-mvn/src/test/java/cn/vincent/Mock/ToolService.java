package cn.vincent.Mock;

public class ToolService {
	private BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	public String getInfoById(String id) {
		return baseDao.queryById(id);
	}
}
