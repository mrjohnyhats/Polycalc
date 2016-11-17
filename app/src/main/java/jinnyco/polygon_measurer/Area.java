package jinnyco.polygon_measurer;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Area extends Activity {

    TextView area_view;
    EditText side_input;
    EditText len_input;

    void calc_area(){
        if (len_input.getText().toString().length() > 0 && side_input.getText().toString().length() > 0) {
            int sides;
            double len;
            Toast etoast = Toast.makeText(Area.this, "please insert a number", Toast.LENGTH_SHORT);
            try {
                sides = Integer.parseInt(side_input.getText().toString());
                len = Float.parseFloat(len_input.getText().toString());
            } catch (NumberFormatException e) {
                area_view.setText("0");
                etoast.show();
                return;
            }

            if (sides > 2 && len > 0) {
                double t_len = len/2.0;
                double angle = 2.0*Math.PI/sides;
                double h = t_len / Math.tan(angle/2.0);
                double area = (sides*len*h)/2.0;
                Log.i("polygon finder", "sides = " + sides);
                Log.i("polygon finder", "len = " + len);
                area_view.setText(Double.toString(Math.round(area*10000.0)/10000.0));
            } else {
                area_view.setText("0");
            }
        } else {
            area_view.setText("0");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        area_view = (TextView) findViewById(R.id.area);
        side_input = (EditText) findViewById(R.id.angle_input);
        len_input = (EditText) findViewById(R.id.len_input);

        TextWatcher input_handler = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calc_area();
            }
        };

        side_input.addTextChangedListener(input_handler);

        len_input.addTextChangedListener(input_handler);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_area, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
