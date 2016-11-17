package jinnyco.polygon_measurer;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Arc_triangle_area extends Activity {

    EditText angle_input;
    EditText radius_input;
    TextView area;

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if(angle_input.getText().toString().length() > 0 && radius_input.getText().toString().length() > 0){
                double angle = Double.parseDouble(angle_input.getText().toString());
                double radius = Double.parseDouble(radius_input.getText().toString());
                if(angle > 0 && radius > 0) {
                    double radians = angle/360.0*Math.PI;
                    double h = Math.cos(radians) * radius;
                    double b = 2.0 * Math.sin(radians) * radius;
                    area.setText(Double.toString(Math.round(h * b / 2.0 * 1000.0) / 1000.0));
                } else {
                    area.setText("0");
                }
            } else {
                area.setText("0");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arc_triangle_area);

        area = (TextView) findViewById(R.id.area);
        angle_input = (EditText) findViewById(R.id.angle_input);
        radius_input = (EditText) findViewById(R.id.radius_input);

        angle_input.addTextChangedListener(textWatcher);
        radius_input.addTextChangedListener(textWatcher);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_arc_triangle_area, menu);
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
