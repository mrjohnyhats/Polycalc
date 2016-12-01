package jinnyco.polygon_measurer;

import android.os.Bundle;

public class Hypotenuse extends FunctionActivity {
    @Override
    protected void doFunction(){
        double s = inputs[0];
        double l = inputs[1];
        if(s > 0 || l > 0){
            output.setText(Double.toString(Math.sqrt(s*s+l*l)));
        } else {
            zeroOutputs();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        input_heads = new String[]{"short leg", "long leg"};
        super.onCreate(savedInstanceState);
    }
}
