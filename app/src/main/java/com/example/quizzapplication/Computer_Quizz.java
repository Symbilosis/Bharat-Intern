package com.example.quizzapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Computer_Quizz extends AppCompatActivity implements View.OnClickListener{



    TextView Questions, QuesNo;
    Button ansa, ansb, ansc, ansd;
    Button submit;
    Button[] selectedButtons;
    int[] originalButtonColors;

    int score = 0;
    int totalQuestion = Questionans.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_quizz);

        QuesNo = findViewById(R.id.QuesNo);
        Questions = findViewById(R.id.Questions);
        ansa = findViewById(R.id.ansa);
        ansb = findViewById(R.id.ansb);
        ansc = findViewById(R.id.ansc);
        ansd = findViewById(R.id.ansd);
        submit = findViewById(R.id.submit);
        selectedButtons = new Button[totalQuestion];

        ansa.setOnClickListener(this);
        ansb.setOnClickListener(this);
        ansc.setOnClickListener(this);
        ansd.setOnClickListener(this);
        submit.setOnClickListener(this);

        loadNewQuestion();


        originalButtonColors = new int[] {
                R.color.tealBlue,
                R.color.tealBlue,
                R.color.tealBlue,
                R.color.tealBlue,

        };


    }

    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;

        if (clickedButton.getId() == R.id.submit) {
            if (selectedAnswer.equals(Questionans.correctAnswers[currentQuestionIndex])) {
                score++;
            }
            currentQuestionIndex++;
            if (currentQuestionIndex < totalQuestion) {
                loadNewQuestion();
            } else {
                finishQuiz();
            }
        } else {
            // Reset the background color for all answer buttons
            for (int i = 0; i < selectedButtons.length; i++) {
                Button button = selectedButtons[i];
                if (button != null) {
                    button.setBackgroundColor(originalButtonColors[i]);
                }
            }



            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
            selectedButtons[currentQuestionIndex] = clickedButton;
        }
    }

    private void finishQuiz() {
        String passStatus = "";
        if (score > totalQuestion * 0.60) {
            passStatus = "Passed";
        } else {
            passStatus = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is " + score + " out of " + totalQuestion)
                .setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        restartQuiz();
                    }
                })
                .setCancelable(false)
                .show();
    }

    private void restartQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        selectedAnswer = "";
        for (int i = 0; i < selectedButtons.length; i++) {
            selectedButtons[i] = null;
        }
        loadNewQuestion();
    }

    private void loadNewQuestion() {
        Questions.setText(Questionans.question[currentQuestionIndex]);
        ansa.setText(Questionans.choices[currentQuestionIndex][0]);
        ansb.setText(Questionans.choices[currentQuestionIndex][1]);
        ansc.setText(Questionans.choices[currentQuestionIndex][2]);
        ansd.setText(Questionans.choices[currentQuestionIndex][3]);

        String progressText = "Question " + (currentQuestionIndex + 1) + " of " + totalQuestion;
        QuesNo.setText(progressText);
    }


}