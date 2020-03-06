package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView displayQuestion;
    private Button trueButton;
    private Button falseButton;
    private ImageButton previous;
    private ImageButton next;
    private Question[] questionsArray = new Question[]{
            new Question(R.string.my_test_question, true),
            new Question(R.string.question_amendments, false),
            new Question(R.string.question_constitution, true),
            new Question(R.string.question_independence_rights, true),
            new Question(R.string.question_religion, true),
            new Question(R.string.question_government, false),
            new Question(R.string.question_government_feds, false),
            new Question(R.string.question_government_senators, true)
    };
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayQuestion = findViewById(R.id.question);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);
        previous = findViewById(R.id.previousButton);
        next = findViewById(R.id.nextButton);

        displayQuestion.setText(questionsArray[currentIndex].getAnswerID());
        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        previous.setOnClickListener(this);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.trueButton:
                checkAnswer(true);
                break;
            case R.id.falseButton:
                checkAnswer(false);
                break;
            case R.id.previousButton:
                currentIndex = (currentIndex - 1 + questionsArray.length) % questionsArray.length;
                updateQuestion();
                break;
            case R.id.nextButton:
                currentIndex = (currentIndex + 1) % questionsArray.length;
                updateQuestion();
                break;
        }
    }

    private void checkAnswer(boolean userAnswer){
        boolean correctAnswer = questionsArray[currentIndex].isCorrect();

        if (correctAnswer == userAnswer){
            Toast.makeText(MainActivity.this, "That is correct!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this, "That is incorrect!", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateQuestion(){
        displayQuestion.setText(questionsArray[currentIndex].getAnswerID());
    }
}
