package com.nexusy.glp.data;

import java.util.List;

/**
 * @author lanhuidong
 * @since 2016-12-06
 */
public class Statistic {

    public static final Statistic EMPTY = new Statistic();

    private List<ParNewData> parNewDatas;

    private List<DefNewData> defNewDatas;

    public List<ParNewData> getParNewDatas() {
        return parNewDatas;
    }

    public void setParNewDatas(List<ParNewData> parNewDatas) {
        this.parNewDatas = parNewDatas;
    }

    public List<DefNewData> getDefNewDatas() {
        return defNewDatas;
    }

    public void setDefNewDatas(List<DefNewData> defNewDatas) {
        this.defNewDatas = defNewDatas;
    }
}
