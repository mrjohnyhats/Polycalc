package jinnyco.polygon_measurer;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by jonbu on 11/19/2016.
 */

public class Area extends FunctionActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        input_heads = new String[]{"number of sides", "side length"};
        watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int sides;
                double len;
                for(int i = 0; i < input_views.length; i++){
                    if(input_views[i].getText().toString().length() <= 0){
                        Toast.makeText(Area.this, "please put something into each input box", Toast.LENGTH_SHORT);
                        output.setText("0");
                        return;
                    }
                    inputs[i] = input_views[i].getText().toString();
                }
                try {
                    sides = Integer.parseInt(inputs[0]);
                    len = Double.parseDouble(inputs[1]);
                } catch(NumberFormatException e){
                    return;
                }
                if (sides > 2 && len > 0) {
                    double t_len = len/2.0;
                    double angle = 2.0*Math.PI/sides;
                    double h = t_len / Math.tan(angle/2.0);
                    double area = (sides*len*h)/2.0;
                    output.setText(Double.toString(Math.round(area*10000.0)/10000.0));
                } else {
                    output.setText("0");
                }
            }
        };
        super.onCreate(savedInstanceState);
    }
}
