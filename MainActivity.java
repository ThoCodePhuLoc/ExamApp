package com.midtern.project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    private TextView textQuestion;
    private RadioGroup radioGroup;
    private Button btnNext,btnSubmit;
    private int score = 0;
    private int currentQuestionIndex = 0;

    private String[] questions = {"Câu hỏi 1: 1+2= ?",
            "Câu hỏi 2: 2+3=?","Câu hỏi 3: 2*3= ?"
    };

    private String[][] options = {{"4", "5", "3","2"},
            {"5", "2", "4","6"}, {"5", "2", "4","6"}

    };
    private String[] correctAnswers = {"3", "5","6"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textQuestion = findViewById(R.id.textQuestion);
        radioGroup = findViewById(R.id.radioGroup);
        btnNext = findViewById(R.id.btnNext);
        btnSubmit = findViewById(R.id.btnSubmit);

        showQuestion();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showNextQuestion();
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResult();
            }});
    }

    private void showQuestion() {
        textQuestion.setText(questions[currentQuestionIndex]);

        radioGroup.removeAllViews();

        for (String option : options[currentQuestionIndex]) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(option);
            radioGroup.addView(radioButton);
        }

    }

    private void showNextQuestion() {
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Vui lòng chọn một đáp án", Toast.LENGTH_SHORT).show();
            return;
        }
        currentQuestionIndex++;

        if (currentQuestionIndex < questions.length) {
            showQuestion();
        } else {

        }
    }

    private void checkAnswer() {
        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();

        if (selectedRadioButtonId == -1) {
            Toast.makeText(this, "Vui lòng chọn một đáp án", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
        String selectedAnswer = selectedRadioButton.getText().toString();
        String correctAnswer = correctAnswers[currentQuestionIndex];

        if (selectedAnswer.equals(correctAnswer)) {
            score++;
        }


       if (currentQuestionIndex < questions.length) {
         showQuestion();
       } else {
            showResult();
       }
    }

    private void showResult() {
        Toast.makeText(this, "Điểm của bạn: " + score + "/" + questions.length, Toast.LENGTH_SHORT).show();

    }
}

