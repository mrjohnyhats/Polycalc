package jinnyco.polygon_measurer;

import android.os.Bundle;

public class Arc_triangle_area extends FunctionActivity {
    @Override
    protected void doFunction(){
        double angle = inputs[0];
        double radius = inputs[1];
        if(angle > 0 && radius > 0) {
            double radians = angle/360.0*Math.PI;
            double h = Math.cos(radians) * radius;
            double b = 2.0 * Math.sin(radians) * radius;
            output.setText(Double.toString(Math.round(h * b / 2.0 * 1000.0) / 1000.0));
        } else {
            zeroOutputs();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        input_heads = new String[]{"angle measure", "radius"};
        has_pi_output = true;

        super.onCreate(savedInstanceState);
    }
}
