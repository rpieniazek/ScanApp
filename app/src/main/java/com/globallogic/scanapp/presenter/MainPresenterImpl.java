package com.globallogic.scanapp.presenter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;

import com.globallogic.scanapp.R;
import com.globallogic.scanapp.model.Medicine;
import com.globallogic.scanapp.service.MedicineService;
import com.globallogic.scanapp.service.QRCodeGenerator;
import com.globallogic.scanapp.view.MainView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.util.EnumMap;
import java.util.Map;

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
            QRCodeGenerator qrCodeGenerator  = QRCodeGenerator.getInstance();
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
    public void validateData() {
        boolean valid;
      mainView.startValidateResultActivity(true);

    }


}
