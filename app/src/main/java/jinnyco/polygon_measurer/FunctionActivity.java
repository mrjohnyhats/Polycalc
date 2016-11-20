package jinnyco.polygon_measurer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FunctionActivity extends Activity {
    int input_quan;
    protected String[] input_heads, inputs;
    EditText[] input_views;
    protected boolean has_pi_output = false;

    protected TextWatcher watcher;
    protected RelativeLayout dl;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.default_funct);

        input_views = new EditText[input_quan];
        inputs = new String[input_quan];
        input_heads = new String[input_quan];

        dl = (RelativeLayout) findViewById(R.id.defaultlayout);

        TextView header;
        EditText input;

        for (int i = 1; i < input_heads.length; i++) {
            header = new TextView(FunctionActivity.this);
            input = new EditText(FunctionActivity.this);
            header.setText(input_heads[i]);
            input.addTextChangedListener(watcher);
            dl.addView(header);
            dl.addView(input);
            input_views[i] = input;
            inputs[i] = "";
        }

        TextView output, pi_output;

        dl.addView(output);
        if(has_pi_output){
            pi_output.setText("0π");
            dl.addView(pi_output);
        }
    }
}
