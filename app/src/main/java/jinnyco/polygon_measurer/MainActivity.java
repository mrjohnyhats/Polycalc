package jinnyco.polygon_measurer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.HashMap;

public class MainActivity extends Activity {
    GridView optsg;
    HashMap<String, Intent> functs = new HashMap<String, Intent>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        functs.put("ext angle to sides", new Intent(this, Ext_angle_sides.class));
        functs.put("polygon area", new Intent(this, Area.class));
        functs.put("interior angle", new Intent(this, Int_angles.class));
        functs.put("interior angle sum", new Intent(this, Int_angles_sum.class));
        functs.put("arc length", new Intent(this, Arc_len.class));
        functs.put("arc area", new Intent(this, Arc_area.class));
        functs.put("arc triangle area", new Intent(this, Arc_triangle_area.class));
        functs.put("hypotenuse", new Intent(this, Hypotenuse.class));
        functs.put("tri-prism surface area", new Intent(this, Tri_prism_sa.class));
        functs.put("rect-prism surface area", new Intent(this, Rect_prism_sa.class));
        functs.put("reg polygon prism surface area", new Intent(this, Polyprism_sa.class));

        String[] keys = Arrays.copyOf(functs.keySet().toArray(), functs.size(), String[].class);

        optsg = (GridView) findViewById(R.id.optsg);
        optsg.setAdapter(new ArrayAdapter<String>(this, R.layout.menu_item, keys));

        optsg.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                MainActivity.this.startActivity(functs.get(((TextView) v).getText().toString()));
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
