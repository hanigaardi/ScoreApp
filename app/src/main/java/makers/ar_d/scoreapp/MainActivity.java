package makers.ar_d.scoreapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int totalPointTeamA = 0;
    int totalPointTeamB = 0;
    int quarter = 1;
    String quarterStr = "";

    TextView pointTeamATextView;
    TextView pointTeamBTextView;
    TextView quarterTextView;
    TextView currentQuarterTextview;
    Button resetButton;
    Button breakButton;
    ImageView funnyImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pointTeamATextView = (TextView) findViewById(R.id.pointTeamATextView);
        pointTeamBTextView = (TextView) findViewById(R.id.pointTeamBTextView);
        quarterTextView = (TextView) findViewById(R.id.quarterTextView);
        currentQuarterTextview = (TextView) findViewById(R.id.currentQuarterTextview);
        resetButton = (Button) findViewById(R.id.resetButton);
        breakButton = (Button) findViewById(R.id.breakButton);
        funnyImageView = (ImageView) findViewById(R.id.funnyImageView);

        enabledButton();
    }

    //team A
    public void aPoint6(View view) {
        totalPointTeamA += 6;
        pointTeamATextView.setText(totalPointTeamA + "");
        enabledButton();
    }

    public void aPoint3(View view) {
        totalPointTeamA += 3;
        pointTeamATextView.setText(totalPointTeamA + "");
        enabledButton();
    }

    public void aPoint2(View view) {
        totalPointTeamA += 2;
        pointTeamATextView.setText(totalPointTeamA + "");
        enabledButton();
    }

    public void aPoint1(View view) {
        totalPointTeamA += 1;
        pointTeamATextView.setText(totalPointTeamA + "");
        enabledButton();
    }

    //team B

    public void bPoint6(View view) {
        totalPointTeamB += 6;
        pointTeamBTextView.setText(totalPointTeamB + "");
        enabledButton();
    }

    public void bPoint3(View view) {
        totalPointTeamB += 3;
        pointTeamBTextView.setText(totalPointTeamB + "");
        enabledButton();
    }

    public void bPoint2(View view) {
        totalPointTeamB += 2;
        pointTeamBTextView.setText(totalPointTeamB + "");
        enabledButton();
    }

    public void bPoint1(View view) {
        totalPointTeamB += 1;
        pointTeamBTextView.setText(totalPointTeamB + "");
        enabledButton();
    }

    public void reset(View view) {
        totalPointTeamA = 0;
        totalPointTeamB = 0;
        pointTeamATextView.setText(totalPointTeamA + "");
        pointTeamBTextView.setText(totalPointTeamB + "");

        quarter = 1;
        quarterStr = "";
        currentQuarterTextview.setText("Quarter " + quarter);
        quarterTextView.setText("");

        enabledButton();
    }


    public void breakQuarter(View view) {
        if (quarter == 4) {

            quarterStr = quarterStr + "Quarter " + quarter + "   ------>   " + totalPointTeamA + ":" + totalPointTeamB + "\n";
            quarterTextView.setText(quarterStr);

            if (totalPointTeamA > totalPointTeamB) {
                currentQuarterTextview.setText("The winner is team A");
                funnyImageView.setVisibility(View.VISIBLE);
            } else if (totalPointTeamB > totalPointTeamA) {
                currentQuarterTextview.setText("The winner is team B");
                funnyImageView.setVisibility(View.VISIBLE);
            } else {
                currentQuarterTextview.setText("Seri euy");
                funnyImageView.setVisibility(View.VISIBLE);
            }

            currentQuarterTextview.setTextSize(24);

            breakButton.setEnabled(false);

        } else {
            quarterStr = quarterStr + "Quarter " + quarter + "   ------>   " + totalPointTeamA + ":" + totalPointTeamB + "\n";
            quarterTextView.setText(quarterStr);

            quarter += 1;
            currentQuarterTextview.setText("Quarter " + quarter);
        }
    }

    void enabledButton() {
        if (totalPointTeamA != 0 || totalPointTeamB != 0) {
            resetButton.setEnabled(true);
        } else {
            resetButton.setEnabled(false);
        }
        currentQuarterTextview.setTextSize(16);
        breakButton.setEnabled(true);
        funnyImageView.setVisibility(View.GONE);
    }
}
