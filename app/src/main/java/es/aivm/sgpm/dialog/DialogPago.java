package es.aivm.sgpm.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;


import es.aivm.sgpm.Bill;
import es.aivm.sgpm.R;
import es.aivm.sgpm.ShoppingBasket;

public class DialogPago extends Dialog implements android.view.View.OnClickListener {
    public Activity c;
    public Dialog d;
    public Button yes, no;

    public DialogPago(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog);
        yes = (Button) findViewById(R.id.continuar);
        no = (Button) findViewById(R.id.cancelar);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.continuar:
                Intent intent = new Intent (c.getApplicationContext(), Bill.class);
                c.startActivity(intent);
                break;
            case R.id.cancelar:
                Intent intent1 = new Intent (c.getApplicationContext(), ShoppingBasket.class);
                c.startActivity(intent1);
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }


}
