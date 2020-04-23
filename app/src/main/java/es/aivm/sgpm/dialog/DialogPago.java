package es.aivm.sgpm.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;


import es.aivm.sgpm.Factura;
import es.aivm.sgpm.ProbadorCliente;
import es.aivm.sgpm.R;
import es.aivm.sgpm.CestaCliente;
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
        setContentView(R.layout.dialogo_confirmacion);
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
                    Intent intent = new Intent (c.getApplicationContext(), Factura.class);
                    c.startActivity(intent);
                } else if (actionType.equals("EliminarProductoCesta")) {
                    DataModel.currentUser.removeProductFromCesta(position);
                    Intent intent = new Intent (c.getApplicationContext(), CestaCliente.class);
                    c.startActivity(intent);
                } else if (actionType.equals("EliminarProductoProbador")) {
                    DataModel.currentUser.removeProductFromProbador(position);
                    Intent intent = new Intent (c.getApplicationContext(), ProbadorCliente.class);
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
