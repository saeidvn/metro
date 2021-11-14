package com.solvd.metro.vehicle;

import java.util.List;

public class Store<E extends CarObject, T> {

    private List<E> data;
    private T otherData;

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

    public T getOtherData() {
        return otherData;
    }

    public void setOtherData(T otherData) {
        this.otherData = otherData;
    }

}
