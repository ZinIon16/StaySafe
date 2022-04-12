package com.example.staysafe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {

    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String[] questions = {
            "What does COVID-19 stand for?",
            "What other viruses belong to the coronavirus family",
            "There are currently vaccines for the following coronaviruses:",
            "How many vaccine candidates for COVID-19 have been proposed?",
            "How does weather seem to affect the novel coronavirus?",
            "Currently, which group has had more severe effects of COVID-19?",
            "How is COVID-19 passed on?",
            "What are the common symptoms of COVID-19?",
            "Can washing your hands protect you from COVID-19? ",
            "Which of the following people is COVID-19 more dangerous for?"
    };
    String[] answers = {"It's a term for Coronavirus Disease 19","SARS and MERS","None of the above","120+","It is not yet known.","Man","Through droplets that come from your mouth and nose when you cough or breathe out","All of the above","Yes – normal soap and water or hand sanitizer is enough","People with certain underlying health conditions"};
    String[] opt = {
            "It's a term for Coronavirus Disease 19","It's a term that stands for Chirum Virus Disease 2019","It's a term that stands for Curry Virus Disease 2019","None of the above",
            "SARS and influenza","SARS and MERS","SARS and HIV","SARS and Malaria",
            "SARS","MERS","SARS and MERS","None of the above",
            "25","<25","100","120+",
            "The virus can’t survive in hot, humid climates.","Cold temperatures can kill the virus.","It is not yet known.","A and B",
            "Man","Woman","Cats","Dogs",
            "Through droplets that come from your mouth and nose when you cough or breathe out","In sexual fluids, including semen, vaginal fluids or anal mucous","By drinking unclean water","None of the mentioned",
            "A new and continuous cough","Fever","Tiredness","All of the above",
            "Yes – normal soap and water or hand sanitizer is enough","No – Washing your hands doesn’t stop COVID-19","Yes – but only if you use a strong bleach","Probably",
            "People with certain underlying health conditions","European people","Adults","Children"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final TextView score = (TextView)findViewById(R.id.textView4);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(v -> {

            if(radio_g.getCheckedRadioButtonId()==-1)
            {
                Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                return;
            }
            RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
            String ansText = uans.getText().toString();
            if(ansText.equals(answers[flag])) {
                correct++;
                Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
            }
            else {
                wrong++;
                Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
            }

            flag++;

            if (score != null)
                score.setText(""+correct);

            if(flag<questions.length)
            {
                tv.setText(questions[flag]);
                rb1.setText(opt[flag*4]);
                rb2.setText(opt[flag*4 +1]);
                rb3.setText(opt[flag*4 +2]);
                rb4.setText(opt[flag*4 +3]);
            }
            else
            {
                marks=correct;
                Intent in = new Intent(getApplicationContext(),Result.class);
                startActivity(in);
            }
            radio_g.clearCheck();
        });

        quitbutton.setOnClickListener(v -> {
            Intent intent1 =new Intent(getApplicationContext(),Result.class);
            startActivity(intent1);
        });
    }

}