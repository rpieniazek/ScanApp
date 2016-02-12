package com.globallogic.scanapp.presenter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import com.globallogic.scanapp.model.Medicine;
import com.globallogic.scanapp.service.MedicineService;
import com.globallogic.scanapp.service.QRCodeGenerator;
import com.globallogic.scanapp.view.MainView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;

/**
 * Created by Rafal Pieniążek on 2016-02-11.
 */
public class MainPresenterImpl implements MainPresenter {


    MainView mainView;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }


    public void generateQRCode(String barcode) {

        try {
            String info = findMedicineWithBarcode(barcode).getDescription();

            QRCodeGenerator qrCodeGenerator = QRCodeGenerator.getInstance();
            Bitmap bitmap = qrCodeGenerator.encodeAsBitmap(info, BarcodeFormat.QR_CODE, 600, 300);
            mainView.setQRCode(bitmap);
            mainView.setMedicineDetails(info);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Medicine findMedicineWithBarcode(String barcode) {
        return MedicineService.getInstance().getMedicineByCode(barcode);
    }

    @Override
    public void validateData(String readData,String storedData) {
        String qrCodeDescription = findMedicineWithBarcode(storedData).getDescription();
        boolean valid = readData.equals(qrCodeDescription);

        Log.i("TAG","READED : " + readData + " STORED:  "+qrCodeDescription );
        mainView.startValidateResultActivity(valid);

    }


}
