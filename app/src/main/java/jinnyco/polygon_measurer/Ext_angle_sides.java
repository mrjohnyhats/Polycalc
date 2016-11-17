package jinnyco.polygon_measurer;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ext_angle_sides extends Activity {

    EditText angle_input;
    TextView sides;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ext_angle_sides);

        angle_input = (EditText) findViewById(R.id.angle_input);
        sides = (TextView) findViewById(R.id.sides);

        angle_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (angle_input.getText().toString().length() > 0) {
                    Toast etoast = Toast.makeText(Ext_angle_sides.this, "please insert a valid angle measure", Toast.LENGTH_SHORT);
                    double anglem;
                    try {
                        anglem = Double.parseDouble(angle_input.getText().toString()) % 360;
                    } catch (NumberFormatException e) {
                        etoast.show();
                        return;
                    } catch (NullPointerException e) {
                        etoast.show();
                        return;
                    }

                    if (anglem < 180) {
                        sides.setText(Integer.toString((int) Math.floor(360 / anglem)));
                    } else {
                        sides.setText("0");
                    }
                } else {
                    sides.setText("0");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ext_angle_sides, menu);
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
