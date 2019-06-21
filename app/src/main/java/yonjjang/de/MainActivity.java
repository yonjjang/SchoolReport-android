package yonjjang.de;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    SeekBar seekBar1, seekBar2, seekBar3, seekBar4, seekBar5, seekBar6;
    EditText editText, editText1, editText2, editText3, editText4, editText5, editText6;
    String subject;
    Button button1, button2;
    TextView viewAvg, viewSubNum;
    String[] reportSub = new String[20];
    String[] reportAvg = new String[20];
    int val1=0, val2=0, val3=0, val4=0, val5=0, val6=0, num=0;
    int red=0, green=255, blue=0;
    float avg=0.00f, sum=0.00f, fullSum=0.00f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewAvg = (TextView)findViewById(R.id.textView8);
        viewSubNum = (TextView)findViewById(R.id.textView9);

        editText = (EditText)findViewById(R.id.editText);
        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        editText4 = (EditText)findViewById(R.id.editText4);
        editText5 = (EditText)findViewById(R.id.editText5);
        editText6 = (EditText)findViewById(R.id.editText6);

        seekBar1 = (SeekBar)findViewById(R.id.seekBar1);
        seekBar2 = (SeekBar)findViewById(R.id.seekBar2);
        seekBar3 = (SeekBar)findViewById(R.id.seekBar3);
        seekBar4 = (SeekBar)findViewById(R.id.seekBar4);
        seekBar5 = (SeekBar)findViewById(R.id.seekBar5);
        seekBar6 = (SeekBar)findViewById(R.id.seekBar6);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);

        seekBar1.setEnabled(false);
        seekBar2.setEnabled(false);
        seekBar3.setEnabled(false);
        seekBar4.setEnabled(false);
        seekBar5.setEnabled(false);
        seekBar6.setEnabled(false);


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                seekBar1.setEnabled(true);
                seekBar2.setEnabled(true);
                seekBar3.setEnabled(true);
                seekBar4.setEnabled(true);
                seekBar5.setEnabled(true);
                seekBar6.setEnabled(true);
                editText1.setEnabled(true);
                editText2.setEnabled(true);
                editText3.setEnabled(true);
                editText4.setEnabled(true);
                editText5.setEnabled(true);
                editText6.setEnabled(true);
                button1.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    subject = s.toString();
                    if (subject.length()==0) {
                        seekBar1.setEnabled(false);
                        seekBar2.setEnabled(false);
                        seekBar3.setEnabled(false);
                        seekBar4.setEnabled(false);
                        seekBar5.setEnabled(false);
                        seekBar6.setEnabled(false);
                        editText1.setEnabled(false);
                        editText2.setEnabled(false);
                        editText3.setEnabled(false);
                        editText4.setEnabled(false);
                        editText5.setEnabled(false);
                        editText6.setEnabled(false);
                        button1.setEnabled(false);
                    }

                } catch (Exception ex) { }
            }
        });


        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (s.toString().length()==0)
                        seekBar1.setProgress(0);
                    val1 = Integer.parseInt(s.toString());
                    if (val1 > 40)
                        seekBar1.setProgress(40);
                    else if (val1 >= 0)
                        seekBar1.setProgress(val1);
                    else
                        seekBar1.setProgress(0);
                    editText1.setSelection(editText1.length());
                } catch (Exception ex){}
            }
        });
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                calcSum();
                viewAvg.setText(String.format("%.2f" , avg));
                editText1.setText(String.valueOf(i));
                red = (int)(avg*42.5);
                green = 255-red;
                button1.setBackgroundColor(Color.rgb(red, green, blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                calcSum();
                viewAvg.setText(String.format("%.2f" , avg));
                red = (int)(avg*42.5);
                green = 255-red;
                button1.setBackgroundColor(Color.rgb(red, green, blue));
            }

            });

        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (s.toString().length()==0)
                        seekBar2.setProgress(0);
                    val2 = Integer.parseInt(s.toString());
                    if (val2 > 40)
                        seekBar2.setProgress(40);
                    else if (val2 >= 0)
                        seekBar2.setProgress(val2);
                    else
                        seekBar2.setProgress(0);
                    editText2.setSelection(editText2.length());
                } catch (Exception ex){}
            }
        });

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                calcSum();
                viewAvg.setText(String.format("%.2f" , avg));
                editText2.setText(String.valueOf(i));
                red = (int)(avg*42.5);
                green = 255-red;
                button1.setBackgroundColor(Color.rgb(red, green, blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                calcSum();
                viewAvg.setText(String.format("%.2f" , avg));
                red = (int)(avg*42.5);
                green = 255-red;
                button1.setBackgroundColor(Color.rgb(red, green, blue));
            }

        });

        editText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (s.toString().length()==0)
                        seekBar3.setProgress(0);
                    val3 = Integer.parseInt(s.toString());
                    if (val3 > 40)
                        seekBar3.setProgress(40);
                    else if (val3 >= 0)
                        seekBar3.setProgress(val3);
                    else
                        seekBar3.setProgress(0);
                    editText3.setSelection(editText3.length());
                } catch (Exception ex){}
            }
        });

        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                calcSum();
                viewAvg.setText(String.format("%.2f" , avg));
                editText3.setText(String.valueOf(i));
                red = (int)(avg*42.5);
                green = 255-red;
                button1.setBackgroundColor(Color.rgb(red, green, blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                calcSum();
                viewAvg.setText(String.format("%.2f" , avg));
                red = (int)(avg*42.5);
                green = 255-red;
                button1.setBackgroundColor(Color.rgb(red, green, blue));
            }

        });

        editText4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (s.toString().length()==0)
                        seekBar4.setProgress(0);
                    val4 = Integer.parseInt(s.toString());
                    if (val4 > 40)
                        seekBar4.setProgress(40);
                    else if (val4 >= 0)
                        seekBar4.setProgress(val4);
                    else
                        seekBar4.setProgress(0);
                    editText4.setSelection(editText4.length());
                } catch (Exception ex){}
            }
        });

        seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                calcSum();
                viewAvg.setText(String.format("%.2f" , avg));
                editText4.setText(String.valueOf(i));
                red = (int)(avg*42.5);
                green = 255-red;
                button1.setBackgroundColor(Color.rgb(red, green, blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                calcSum();
                viewAvg.setText(String.format("%.2f" , avg));
                red = (int)(avg*42.5);
                green = 255-red;
                button1.setBackgroundColor(Color.rgb(red, green, blue));
            }

        });

        editText5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (s.toString().length()==0)
                        seekBar5.setProgress(0);
                    val5 = Integer.parseInt(s.toString());
                    if (val5 > 40)
                        seekBar5.setProgress(40);
                    else if (val5 >= 0)
                        seekBar5.setProgress(val5);
                    else
                        seekBar5.setProgress(0);
                    editText5.setSelection(editText5.length());
                } catch (Exception ex){}
            }
        });

        seekBar5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                calcSum();
                viewAvg.setText(String.format("%.2f" , avg));
                editText5.setText(String.valueOf(i));
                red = (int)(avg*42.5);
                green = 255-red;
                button1.setBackgroundColor(Color.rgb(red, green, blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                calcSum();
                viewAvg.setText(String.format("%.2f" , avg));
                red = (int)(avg*42.5);
                green = 255-red;
                button1.setBackgroundColor(Color.rgb(red, green, blue));
            }

        });

        editText6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (s.toString().length()==0)
                        seekBar6.setProgress(0);
                    val6 = Integer.parseInt(s.toString());
                    if (val6 > 40)
                        seekBar6.setProgress(40);
                    else if (val6 >= 0)
                        seekBar6.setProgress(val6);
                    else
                        seekBar6.setProgress(0);
                    editText6.setSelection(editText6.length());
                } catch (Exception ex){}
            }
        });

        seekBar6.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                calcSum();
                viewAvg.setText(String.format("%.2f" , avg));
                editText6.setText(String.valueOf(i));
                red = (int)(avg*42.5);
                green = 255-red;
                button1.setBackgroundColor(Color.rgb(red, green, blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                calcSum();
                viewAvg.setText(String.format("%.2f" , avg));
                red = (int)(avg*42.5);
                green = 255-red;
                button1.setBackgroundColor(Color.rgb(red, green, blue));
            }

        });

    }


    public void calcSum(){
        fullSum = 1*val1 + 2*val2 + 3*val3 + 4*val4 + 5*val5 + 6*val6;
        sum = val1 + val2 + val3 + val4 + val5 + val6;
        if (sum == 0)
            avg = 0.00f;
        else
            avg = (float)fullSum/sum;
    }

    public void onButton1Clicked(View v){
        if (subject.length()!=0) {
            reportSub[num] = subject;
            reportAvg[num] = Integer.toString(Math.round(avg));
            num++;
            Toast.makeText(getApplicationContext(), "Subject has been added to school report.", Toast.LENGTH_LONG).show();
        }

        editText.setText(null);
        editText1.setText("0");
        editText2.setText("0");
        editText3.setText("0");
        editText4.setText("0");
        editText5.setText("0");
        editText6.setText("0");
        viewSubNum.setText(String.valueOf(num)+" subjects added to school report so far.");

    }


    public void onButton2Clicked(View v){
        Toast.makeText(getApplicationContext(), "All data has been deleted.", Toast.LENGTH_LONG).show();
        for (int i=0; i<20; i++){
                reportSub[i] = null;
                reportAvg[i] = null;
        }
        num = 0;
        viewSubNum.setText(String.valueOf(num)+" subjects added to school report so far.");
    }


    public void onFabClicked(View v){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("subArray", reportSub);
        intent.putExtra("avgArray", reportAvg);

        startActivity(intent);

    }

}
