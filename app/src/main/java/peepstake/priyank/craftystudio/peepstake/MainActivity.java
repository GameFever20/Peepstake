package peepstake.priyank.craftystudio.peepstake;

import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.hookedonplay.decoviewlib.DecoView;
import com.hookedonplay.decoviewlib.charts.EdgeDetail;
import com.hookedonplay.decoviewlib.charts.SeriesItem;
import com.hookedonplay.decoviewlib.charts.SeriesLabel;
import com.hookedonplay.decoviewlib.events.DecoEvent;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    DecoView arcView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        arcView = (DecoView)findViewById(R.id.dynamicArcView);

        int yourPercent = (int)(Math.random() *100);
        int classAveragePercent =40;
        int classMaximumPercent =80;
        int classHighestPercent =90;

        TextView yourPercentTextView = (TextView)findViewById(R.id.yourPercent_textview);
        TextView classAveragePercentTextView = (TextView)findViewById(R.id.classAveragePercent_textview);
        TextView classMaximumPercentTextView = (TextView)findViewById(R.id.classMaximumPercent_textview);
        TextView classHighestPercentTextView = (TextView)findViewById(R.id.classHighestPercent_textview);

        yourPercentTextView.setText("Your Percent = "+String.valueOf(yourPercent));
        classAveragePercentTextView.setText("Class Average Percent = "+String.valueOf(classAveragePercent));
        classHighestPercentTextView.setText("Class Highest Percent = "+String.valueOf(classHighestPercent));
        classMaximumPercentTextView.setText("Class Maximum Percent = "+String.valueOf(classMaximumPercent));



        SeriesItem seriesItem1 = new SeriesItem.Builder(Color.argb(255,244,67,54))
                .setRange(0, 100, 0)
                .setLineWidth(64)
                .setInset(new PointF(64f,64f))

                .setSeriesLabel(new SeriesLabel.Builder("Class Average %.0f%%")
                        .setColorBack(Color.argb(255,244,67,54))
                        .setColorText(Color.argb(255, 255, 255, 255))
                        .build())                .build();

        int series1Index =arcView.addSeries(seriesItem1);
        arcView.addEvent(new DecoEvent.Builder(classAveragePercent).setIndex(series1Index).setDelay(120).build());


        SeriesItem seriesItem2 = new SeriesItem.Builder(Color.argb(255, 142,36,170))
                .setRange(0, 100, 0)
                .setLineWidth(32f)
                .setInset(new PointF(64f,64f))

                .setSeriesLabel(new SeriesLabel.Builder("You %.0f%%")
                        .setColorBack(Color.argb(255, 142,36,170))
                        .setColorText(Color.argb(255, 255, 255, 255))
                        .build())                .build();

        int series2Index =arcView.addSeries(seriesItem2);
        arcView.addEvent(new DecoEvent.Builder(yourPercent).setIndex(series2Index).setDelay(1000).build());


        SeriesItem seriesItem3 = new SeriesItem.Builder(Color.argb(255, 0,137,123))
                .setRange(0, 100, 0)
                .setLineWidth(32f)
                .setInset(new PointF(128f,128f))

                .setSeriesLabel(new SeriesLabel.Builder("Class Max %.0f%%")
                        .setColorBack(Color.argb(255, 0,137,123))
                        .setColorText(Color.argb(255, 255, 255, 255))
                        .build())                .build();

        int series3Index =arcView.addSeries(seriesItem3);
        arcView.addEvent(new DecoEvent.Builder(classMaximumPercent).setIndex(series3Index).setDelay(4000).build());


        SeriesItem seriesItem4 = new SeriesItem.Builder(Color.argb(255, 255,179,0))
                .setRange(0, 100, 0)
                .setLineWidth(32f)
                .setInset(new PointF(0f,0f))

                .setSeriesLabel(new SeriesLabel.Builder("Class Highest %.0f%%")
                        .setColorBack(Color.argb(255, 255,179,0))
                        .setColorText(Color.argb(255, 255, 255, 255))
                        .build())                .build();

        int series4Index =arcView.addSeries(seriesItem4);
        arcView.addEvent(new DecoEvent.Builder(classHighestPercent).setIndex(series4Index).setDelay(6000).build());



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
