package com.egov.win10.simpelv.data;

/**
 * Created by win10 on 23/06/2019.
 */

public class DataSpinnerJenisTindakanKonsep {

    public String valueTindakan;
    public String namaTindakan;

    public DataSpinnerJenisTindakanKonsep(String valueTindakan, String namaTindakan) {
        this.valueTindakan = valueTindakan;
        this.namaTindakan = namaTindakan;
    }

    public String getValueTindakan() {
        return valueTindakan;
    }

    public void setValueTindakan(String valueTindakan) {
        this.valueTindakan = valueTindakan;
    }

    public String getNamaTindakan() {
        return namaTindakan;
    }

    public void setNamaTindakan(String namaTindakan) {
        this.namaTindakan = namaTindakan;
    }

    @Override
    public String toString() {
        return namaTindakan;
    }
}
