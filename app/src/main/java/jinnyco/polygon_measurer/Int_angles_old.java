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

public class Int_angles_old extends Activity {

    EditText side_input;
    TextView angle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_int_angles);

        side_input = (EditText) findViewById(R.id.angle_input);
        angle = (TextView) findViewById(R.id.angle);

        side_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (side_input.getText().toString().length() > 0) {
                    int sides;
                    Toast etoast = Toast.makeText(Int_angles_old.this, "please insert a number", Toast.LENGTH_SHORT);
                    try {
                        sides = Integer.parseInt(side_input.getText().toString());
                    } catch (NumberFormatException e) {
                        etoast.show();
                        return;
                    } catch (NullPointerException e) {
                        etoast.show();
                        return;
                    }

                    if (sides > 2) {
                        angle.setText(Double.toString((sides - 2) * 180.0 / sides));
                    } else {
                        angle.setText("0");
                    }
                } else {
                    angle.setText("0");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_int_angles, menu);
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
