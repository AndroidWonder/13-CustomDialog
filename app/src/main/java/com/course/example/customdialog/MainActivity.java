package com.course.example.customdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    Button btnGo;
    EditText txtMsg, userName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMsg =  (EditText)findViewById(R.id.txtMsg);

        btnGo = (Button) findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //create custom dialog
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                dialogBuilder.setView(R.layout.custom);
                AlertDialog dialog = dialogBuilder.create();

                //set title
                dialog.setTitle("Lego Toy Corporation");

                //set option buttons
                dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Continue", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        //whatever should be done when answering "YES" goes here

                        Uri uri = Uri.parse("tel:8005559999");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);

                    }
                });//setPositiveButton

                dialog.setButton(DialogInterface.BUTTON_NEUTRAL, "Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        //whatever should be done when answering "CANCEL" goes here
                        txtMsg.setText("Cancel");
                    }//OnClick
                });//setNeutralButton

                dialog.show();


                txtMsg.setText("Hello");

            }

        });
    }//onCreate


}

