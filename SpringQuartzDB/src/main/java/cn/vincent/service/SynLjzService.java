package cn.vincent.service;

import cn.vincent.pojo.TmpLjz;

import java.util.List;

/**
 * 往老库同步
 */
public interface SynLjzService {
    void synVdCcumuValueIntoLjz(List<TmpLjz> tmpljzList);
}
