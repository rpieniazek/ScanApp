package com.globallogic.scanapp.service;

import com.globallogic.scanapp.model.Medicine;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

//        String barcode [] = {"036000291452", "4008617149637", "8594739205734", "4030142018345", "864642020700" };
//        String qrcode [] = {"ibalgin|400|2x400mg|zentiva|tbl_flm",
//                "neongin|100|24x200mg|divapharma|lozeng",
//                "patalen|500|12x200mg|zentiva|tbl_ent",
//                "wobenzym|x|800X250mg|mucos_pharma|tbl_ent",
//                "B12|x|100x250mg|jamieson|tbl"
//        };


        HashMap<String, String> map = new HashMap<String, String>();
        map.put("036000291452", "ibalgin|400|2x400mg|zentiva|tbl_flm");
        map.put("4008617149637", "neongin|100|24x200mg|divapharma|lozeng");
        map.put("8594739205734", "patalen|500|12x200mg|zentiva|tbl_ent");
        map.put("4030142018345", "wobenzym|x|800X250mg|mucos_pharma|tbl_ent");
        map.put("864642020700", "B12|x|100x250mg|jamieson|tbl");

//        HashMap<String,Object> map=new HashMap<String,Object>();
        Set<Map.Entry<String,String>> entrySet=map.entrySet();

        for (Map.Entry<String,String> pair : entrySet) {
            if (code.equals(pair.getKey())) {
                return new Medicine(pair.getValue());// нашли наше значение и возвращаем  ключ
            }
        }
        return new Medicine("0");
//
//        for( Map.Entry<String, String> entry : map.entrySet() ){
//            entry.
//            return new Medicine( entry.getValue(code));
//        }

//        for (i = 0, i < 5, i++) {
//            if (barcode[i].equals(code)) {
//                return new Medicine();
//            }
//        }

//        return new Medicine("ibalgin",400,code);

    }
}
