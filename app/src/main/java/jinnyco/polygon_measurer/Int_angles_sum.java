package jinnyco.polygon_measurer;

import android.os.Bundle;

public class Int_angles_sum extends FunctionActivity {
    @Override
    protected void doFunction(){
        double sides = inputs[0];

        if(sides > 2){
            output.setText(Double.toString((sides-2)*180));
        } else {
            zeroOutputs();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        input_heads = new String[]{"number of sides"};

        super.onCreate(savedInstanceState);
    }
}
