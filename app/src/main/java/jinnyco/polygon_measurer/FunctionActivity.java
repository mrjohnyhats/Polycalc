package jinnyco.polygon_measurer;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextWatcher;

import android.view.Gravity;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FunctionActivity extends Activity {
    protected String[] input_heads, inputs;
    protected EditText[] input_views;
    protected boolean has_pi_output = false;
    protected TextWatcher watcher;
    protected RelativeLayout dl;
    protected TextView output;
    protected TextView pi_output;

    private TextView makeoutput(int i){
        TextView o = new TextView(FunctionActivity.this);
        RelativeLayout.LayoutParams oparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        if (input_views[input_views.length - 1] != null) {
            oparams.addRule(RelativeLayout.BELOW, input_views[input_views.length - 1].getId());
        }
        oparams.setMargins(15, 15, 15, 15);

        o.setId((int) Math.floor((Math.random()+0.1) * Math.pow(10.0, input_heads.length*2+i+1)));
        o.setTextSize(50);
        o.setTextColor(Color.BLACK);
        o.setGravity(Gravity.CENTER);
        o.setPadding(20, 20, 20, 20);
        o.setLayoutParams(oparams);

        return o;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.default_funct);

        input_views = new EditText[input_heads.length];
        inputs = new String[input_heads.length];

        dl = (RelativeLayout) findViewById(R.id.defaultlayout);

        //SET INPUTS

        TextView header;
        EditText input;
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams headerparams;
        RelativeLayout.LayoutParams inputparams;

        for (int i = 0; i < input_heads.length; i++) {
            header = new TextView(FunctionActivity.this);
            header.setId((int)Math.floor((Math.random()+0.1)*Math.pow(10.0, i+1)));
            header.setGravity(Gravity.CENTER);

            input = new EditText(FunctionActivity.this);
            input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
            input.setId((int)Math.floor((Math.random()+0.1)*Math.pow(10.0, i+1+input_heads.length)));

            headerparams = new RelativeLayout.LayoutParams(params);
            inputparams = new RelativeLayout.LayoutParams(params);

            headerparams.setMargins(0, 50, 0, 0);
            if(i > 0){
                headerparams.addRule(RelativeLayout.BELOW, input_views[i-1].getId());
            }
            header.setLayoutParams(headerparams);
            header.setTextSize(16);
            header.setText(input_heads[i]);

            dl.addView(header);

            inputparams.addRule(RelativeLayout.BELOW, header.getId());
            inputparams.setMargins(20, 10, 20, 10);
            input.setLayoutParams(inputparams);

            input.addTextChangedListener(watcher);

            dl.addView(input);
            input_views[i] = input;
        }

        //SET OUTPUTS

        if(input_views.length > 0) {
            output = makeoutput(0);
            output.setText("0");

            dl.addView(output);

            if (has_pi_output) {
                pi_output = makeoutput(1);
                pi_output.setText("0π");
                dl.addView(pi_output);
            }
        }
    }
}
