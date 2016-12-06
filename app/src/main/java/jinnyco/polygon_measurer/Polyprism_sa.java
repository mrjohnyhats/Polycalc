package jinnyco.polygon_measurer;

import android.os.Bundle;

public class Polyprism_sa extends FunctionActivity {
    @Override
    protected void doFunction(){
        double s = inputs[0];
        double l = inputs[1];
        double t_len = l/2.0;
        double angle = 2.0*Math.PI/s;
        double h = t_len / Math.tan(angle/2.0);
        double area = (s*l*h)/2.0;
        output.setText(Double.toString(area*h));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        input_heads = new String[]{"number of sides", "side length", "height"};
        super.onCreate(savedInstanceState);
    }
}
