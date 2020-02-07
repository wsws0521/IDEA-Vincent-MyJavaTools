package cn.vincent.service;

import cn.vincent.pojo.TmpLjzWithIdOld;

import java.util.List;

/**
 * 往新库同步
 */
public interface SynCumuService {
    void synLjzIntoVdCcumuValue(List<TmpLjzWithIdOld> tmpLjzList);
}
