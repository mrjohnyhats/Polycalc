package jinnyco.polygon_measurer;

import android.os.Bundle;

public class Arc_area extends FunctionActivity {
    @Override
    protected void doFunction(){
        double angle = inputs[0];
        double radius = inputs[1];

        if (angle > 0 && radius > 0) {
            double pi_area = angle/360.0 * radius * radius;
            double area = pi_area * Math.PI;
            output.setText(Double.toString(Math.round(area * 1000.0) / 1000.0));
            pi_output.setText(Double.toString(Math.round(pi_area * 1000.0)/1000.0) + "π");
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
