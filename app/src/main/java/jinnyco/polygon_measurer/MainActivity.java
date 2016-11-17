package jinnyco.polygon_measurer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {

    Button ext_angle_sides_button;
    Button area_button;
    Button int_angles_button;
    Button int_angles_sum_button;
    Button arc_len_button;
    Button arc_area_button;
    Button arc_t_area_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        ext_angle_sides_button = (Button) findViewById(R.id.ext_angle_sides_button);
        area_button = (Button) findViewById(R.id.area_button);
        int_angles_button = (Button) findViewById(R.id.int_angles_button);
        int_angles_sum_button = (Button) findViewById(R.id.int_angles_sum_button);
        arc_len_button = (Button) findViewById(R.id.arc_len_button);
        arc_area_button = (Button) findViewById(R.id.arc_area_button);
        arc_t_area_button = (Button) findViewById(R.id.arc_t_area_button);

        final Intent ext_angle_click = new Intent(MainActivity.this, Ext_angle_sides.class);
        final Intent area_click = new Intent(MainActivity.this, Area.class);
        final Intent int_angles_click = new Intent(MainActivity.this, Int_angles.class);
        final Intent int_angles_sum_click = new Intent(MainActivity.this, Int_angles_sum.class);
        final Intent arc_len_click = new Intent(MainActivity.this, Arc_len.class);
        final Intent arc_area_click = new Intent(MainActivity.this, Arc_area.class);
        final Intent arc_t_area_click = new Intent(MainActivity.this, Arc_triangle_area.class);

        ext_angle_sides_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(ext_angle_click);
            }
        });
        area_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(area_click);
            }
        });
        int_angles_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(int_angles_click);
            }
        });
        int_angles_sum_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(int_angles_sum_click);
            }
        });
        arc_len_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                MainActivity.this.startActivity(arc_len_click);
            }
        });
        arc_area_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(arc_area_click);
            }
        });
        arc_t_area_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(arc_t_area_click);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
