package com.globallogic.scanapp.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.globallogic.scanapp.R;
import com.globallogic.scanapp.presenter.MainPresenterImpl;
import com.globallogic.scanapp.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView {


    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";

    private MainPresenterImpl mainPresenter;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenterImpl(this);
        button = (Button) findViewById(R.id.scan_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TAG", "button text: " + button.getText() + ", R. string: " + getString(R.string.validate));

                if (button.getText().equals(getString(R.string.validate))) {
                    validate();
                } else {
                    scanBar();
                }
            }
        });
    }

    private void validate() {
        try {
            //start the scanning activity from the com.google.zxing.client.android.SCAN intent
            Intent intent = new Intent(ACTION_SCAN);
            // intent.putExtra("SCAN_MODE", "PRODUCT_MODE");
            Log.i("TAG", "in validate 1");

            startActivityForResult(intent, 1);
        } catch (ActivityNotFoundException anfe) {
            //on catch, show the download dialog
            showDialog(MainActivity.this, "No Scanner Found", "Download a scanner code activity?", "Yes", "No").show();
        }
    }

    //product barcode mode
    public void scanBar() {
        try {
            //start the scanning activity from the com.google.zxing.client.android.SCAN intent
            Intent intent = new Intent(ACTION_SCAN);
            // intent.putExtra("SCAN_MODE", "PRODUCT_MODE");
            startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException anfe) {
            //on catch, show the download dialog
            showDialog(MainActivity.this, "No Scanner Found", "Download a scanner code activity?", "Yes", "No").show();
        }
    }


    //alert dialog for downloadDialog
    private static AlertDialog showDialog(final Activity act, CharSequence title, CharSequence message, CharSequence buttonYes, CharSequence buttonNo) {
        AlertDialog.Builder downloadDialog = new AlertDialog.Builder(act);
        downloadDialog.setTitle(title);
        downloadDialog.setMessage(message);
        downloadDialog.setPositiveButton(buttonYes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Uri uri = Uri.parse("market://search?q=pname:" + "com.google.zxing.client.android");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    act.startActivity(intent);
                } catch (ActivityNotFoundException anfe) {

                }
            }
        });
        downloadDialog.setNegativeButton(buttonNo, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return downloadDialog.show();
    }

    //on ActivityResult method
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Log.i("TAG", "request code: "+requestCode);

        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String contents = intent.getStringExtra("SCAN_RESULT");
                mainPresenter.generateQRCode(contents);
                Log.i("TAG", "MainActivity.onActivityResult() = 0");
            }

        } else if (requestCode == 1) {
//            if (resultCode == RESULT_OK) {
             Log.i("TAG", "MainActivity.onActivityResult() = 1");
                String contents = intent.getStringExtra("SCAN_RESULT");
                mainPresenter.validateData(contents);

          //  }
        }


    }

    @Override
    public void setQRCode(Bitmap bitmap) {
        ImageView qrCode = (ImageView) findViewById(R.id.qr_code);
        button.setText(R.string.validate);
        qrCode.setVisibility(View.VISIBLE);
        qrCode.setImageBitmap(bitmap);
    }

    @Override
    public void setMedicineDetails(String medicine) {
        TextView textView = (TextView) findViewById(R.id.details);
        textView.setVisibility(View.VISIBLE);
        textView.setText(medicine);
    }

    @Override
    public void startValidateResultActivity(boolean valid) {
            Intent intent = new Intent(this, ValidateActivity.class);
        intent.putExtra("VALID", valid);
        startActivity(intent);
    }
}
