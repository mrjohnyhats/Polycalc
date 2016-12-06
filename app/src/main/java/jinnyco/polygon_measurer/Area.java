package jinnyco.polygon_measurer;

import android.os.Bundle;

public class Area extends FunctionActivity {
    @Override
    protected void doFunction(){
        int sides = (int)inputs[0];
        double len = inputs[1];
        if (sides > 2 && len > 0) {
            double t_len = len/2.0;
            double angle = 2.0*Math.PI/sides;
            double h = t_len / Math.tan(angle/2.0);
            double area = (sides*len*h)/2.0;
            output.setText(Double.toString(Math.round(area*10000.0)/10000.0));
        } else {
            zeroOutputs();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        input_heads = new String[]{"number of sides", "side length"};
        super.onCreate(savedInstanceState);
    }
}
