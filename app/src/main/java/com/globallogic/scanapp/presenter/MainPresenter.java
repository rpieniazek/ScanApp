package com.globallogic.scanapp.presenter;

import com.globallogic.scanapp.model.Medicine;

/**
 * Created by Rafal Pieniążek on 2016-02-11.
 */
public interface MainPresenter {

    void generateQRCode(String barcode);
    Medicine findMedicineWithBarcode(String barcode);
}
