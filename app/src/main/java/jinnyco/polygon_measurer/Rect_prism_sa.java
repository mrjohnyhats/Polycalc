package jinnyco.polygon_measurer;

import android.os.Bundle;

public class Rect_prism_sa extends FunctionActivity {
    @Override
    protected void doFunction(){
        double rb = inputs[0];
        double rh = inputs[1];
        double h = inputs[2];
        output.setText(Double.toString(2*rb*rh+h*(2*rb+2*rh)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        input_heads = new String[]{"rectangle base", "rectangle height", "height"};
        super.onCreate(savedInstanceState);
    }
}
