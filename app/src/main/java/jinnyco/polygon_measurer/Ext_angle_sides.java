package jinnyco.polygon_measurer;

import android.os.Bundle;

public class Ext_angle_sides extends FunctionActivity {
    @Override
    protected void doFunction(){
        double angle = inputs[0];
        if(angle > 0){
            output.setText(Double.toString(360.0/angle));
        } else {
            zeroOutputs();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        input_heads = new String[]{"exterior angle"};

        super.onCreate(savedInstanceState);
    }

}
