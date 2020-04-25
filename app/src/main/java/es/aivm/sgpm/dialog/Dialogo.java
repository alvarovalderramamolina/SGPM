package es.aivm.sgpm.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;


import es.aivm.sgpm.Espera;
import es.aivm.sgpm.Factura;
import es.aivm.sgpm.ProbadorCliente;
import es.aivm.sgpm.Producto;
import es.aivm.sgpm.PromocionesCliente;
import es.aivm.sgpm.R;
import es.aivm.sgpm.CestaCliente;
import es.aivm.sgpm.SolicitudProbadorPersonal;
import es.aivm.sgpm.model.DataModel;
import es.aivm.sgpm.model.ProductModel;

public class Dialogo extends Dialog implements android.view.View.OnClickListener {
    public Activity c;
    public Dialog d;
    public Button yes, no;
    private String text;
    public String actionType;
    private TextView title;
    public int position;

    public Dialogo(Activity a, String actionType, String text) {
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
                    if(DataModel.currentUser.isGuest()){
                        Intent intent = new Intent (c.getApplicationContext(), Factura.class);
                        c.startActivity(intent);
                    }
                    else {
                        Intent intent = new Intent (c.getApplicationContext(), PromocionesCliente.class);
                        c.startActivity(intent);
                    }
                } else if (actionType.equals("PedirProductos")) {
                    Intent intent = new Intent(c.getApplicationContext(), SolicitudProbadorPersonal.class);
                    c.startActivity(intent);
                } else if (actionType.equals("EliminarProductoCesta")) {
                    DataModel.currentUser.removeProductFromCesta(position);
                    Intent intent = new Intent (c.getApplicationContext(), CestaCliente.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    c.startActivity(intent);
                } else if (actionType.equals("EliminarProductoProbador")) {
                    DataModel.currentUser.removeProductFromProbador(position);
                    Intent intent = new Intent (c.getApplicationContext(), ProbadorCliente.class);
                    c.startActivity(intent);
                } else if (actionType.equals("AñadirProductoProbador")) {
                    try {
                        ProductModel copy = (ProductModel) DataModel.currentProduct.clone();
                        DataModel.currentUser.addProductToProbador(copy);
                        c.recreate();
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                    dismiss();
                } else if (actionType.equals("AñadirProductoCesta")) {
                    try {
                        ProductModel copy = (ProductModel) DataModel.currentProduct.clone();
                        DataModel.currentUser.addProductToCesta(copy);
                        c.recreate();
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }

                    dismiss();
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
