package yonjjang.de;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView viewReportSub = (TextView)findViewById(R.id.textView11);
        TextView viewReportAvg = (TextView)findViewById(R.id.textView12);
        TextView viewFinalAvg = (TextView)findViewById(R.id.textView13);

        Intent intent = getIntent();

        String subArray[] = intent.getExtras().getStringArray("subArray"); /*배열*/
        String avgArray[] = intent.getExtras().getStringArray("avgArray");

        String addedSubArray="";
        String addedAvgArray="";
        int avgSum=0, cnt=0;
        float finalAvg;

        for(int i=0; i<subArray.length; i++){
            if (subArray[i]!=null)
                addedSubArray += subArray[i]+"\n";
            if (avgArray[i]!=null) {
                addedAvgArray += avgArray[i] + "\n";
                avgSum += Integer.parseInt(avgArray[i]);
                cnt++;
            }
        }

        finalAvg = (float)avgSum/cnt;

        if (subArray[0]==null)
            finalAvg=0.0f;

        viewReportSub.setText(addedSubArray);
        viewReportAvg.setText(addedAvgArray);
        viewFinalAvg.setText("Average: "+ String.format("%.1f" , finalAvg));

    }

    public void onButton3Clicked(View view){
        finish();
    }
}
