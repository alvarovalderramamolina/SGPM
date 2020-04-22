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
import android.widget.TextView;


import org.w3c.dom.Text;

import es.aivm.sgpm.Bill;
import es.aivm.sgpm.R;
import es.aivm.sgpm.ShoppingBasket;
import es.aivm.sgpm.model.DataModel;

public class DialogPago extends Dialog implements android.view.View.OnClickListener {
    public Activity c;
    public Dialog d;
    public Button yes, no;
    private String text;
    public String actionType;
    private TextView title;
    public int position;

    public DialogPago(Activity a, String actionType, String text) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
        this.text = text;
        this.actionType = actionType;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog);
        yes = (Button) findViewById(R.id.continuar);
        no = (Button) findViewById(R.id.cancelar);
        title = (TextView) findViewById(R.id.my_dialog_text);
        title.setText(this.text);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.continuar:
                if (actionType.equals("GenerarFactura")) {
                    Intent intent = new Intent (c.getApplicationContext(), Bill.class);
                    c.startActivity(intent);
                } else if (actionType.equals("EliminarProducto")) {
                    DataModel.currentUser.removeProductFromCesta(position);
                    Intent intent = new Intent (c.getApplicationContext(), ShoppingBasket.class);
                    c.startActivity(intent);
                }
                break;
            case R.id.cancelar:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }


}
