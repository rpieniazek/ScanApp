package com.globallogic.scanapp.service;

import com.globallogic.scanapp.model.Medicine;

/**
 * Created by Rafal Pieniążek on 2016-02-11.
 */
public class MedicineService {
    private static MedicineService ourInstance = new MedicineService();

    public static MedicineService getInstance() {
        return ourInstance;
    }

    private MedicineService() {
    }

    public Medicine getMedicineByCode(String code){
        return new Medicine("ibalgin",400,code);

    }
}
