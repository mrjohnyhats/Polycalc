package jinnyco.polygon_measurer;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by jonbu on 11/20/2016.
 */

public class Ext_angle_sides extends FunctionActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        input_heads = new String[]{"exterior angle"};

        watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(input_views[0].getText().toString().length() > 0){
                    double angle = Double.parseDouble(input_views[0].getText().toString());
                    if(angle <= 360){
                        output.setText(Double.toString(Math.round(360.0/angle*1e4)/1e4));
                    } else {
                        output.setText("0");
                    }
                } else {
                    output.setText("0");
                }
            }
        };

        super.onCreate(savedInstanceState);
    }

}
