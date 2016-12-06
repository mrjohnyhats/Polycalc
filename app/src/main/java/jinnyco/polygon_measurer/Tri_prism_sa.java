package jinnyco.polygon_measurer;

import android.os.Bundle;

public class Tri_prism_sa extends FunctionActivity {
    @Override
    protected void doFunction(){
        double l1 = inputs[0];
        double l2 = inputs[1];
        double hyp = Math.sqrt(l1*l1+l2*l2);
        double h = inputs[2];
        output.setText(Double.toString(l1*l2+h*(hyp+l1+l2)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        input_heads = new String[]{"first triangle leg", "second triangle leg", "height"};
        super.onCreate(savedInstanceState);
    }
}
