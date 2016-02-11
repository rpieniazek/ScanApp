package com.globallogic.scanapp.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
/**
 * Created by Rafal Pieniążek on 2016-02-11.
 */
public class QRCodeGenerator {
    private static QRCodeGenerator ourInstance = new QRCodeGenerator();

    public static QRCodeGenerator getInstance() {
        return ourInstance;
    }

    private QRCodeGenerator() {
    }

    public void generateCode(String Data){



    }




}
