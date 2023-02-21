package com.example.quizapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView questionsTv, questionNumberTv;
    private Button option1, option2, option3, option4;
    private ArrayList<QuizModal> quizModalArrayList;
    private ImageView imageView;
    Random random;
    int currentScore=0, QuestionsAttempted=0, currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageView);
        questionNumberTv = (TextView) findViewById(R.id.QuestionsAttempted);
        option1 = (Button) findViewById(R.id.option1);
        option2 = (Button) findViewById(R.id.option2);
        option3 = (Button) findViewById(R.id.option3);
        option4 = (Button) findViewById(R.id.option4);
        quizModalArrayList = new ArrayList<>();
        random= new Random();
        getQuizQuestions(quizModalArrayList);
        currentPos =0;
        setDataView(currentPos);
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                QuestionsAttempted++;
                currentPos++;
                imageView.setAlpha(0f);
                setDataView(currentPos);
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                QuestionsAttempted++;
                currentPos++;
                imageView.setAlpha(0f);
                setDataView(currentPos);
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                QuestionsAttempted++;
                currentPos++;
                imageView.setAlpha(0f);
                setDataView(currentPos);
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                QuestionsAttempted++;
                currentPos++;
                imageView.setAlpha(0f);
                setDataView(currentPos);
            }
        });
    }
    private void getQuizQuestions(ArrayList<QuizModal>quizModalArrayList) {

     quizModalArrayList.add(new QuizModal(R.drawable.c,"java","C","Python","C++","C"));
     quizModalArrayList.add(new QuizModal(R.drawable.cpp_logo,"java","C","Python","C++","C++"));
     quizModalArrayList.add(new QuizModal(R.drawable.java,"java","C","Python","C++","java"));
     quizModalArrayList.add(new QuizModal(R.drawable.python,"java","C","Python","C++","Python"));
     quizModalArrayList.add(new QuizModal(R.drawable.javascr,"java","C","Java Script","C++","Java Script"));
     quizModalArrayList.add(new QuizModal(R.drawable.kotlin,"java","C","Python","Kotlin","Kotlin"));
     quizModalArrayList.add(new QuizModal(R.drawable.dart,"Dart","C","Python","C++","Dart"));
     quizModalArrayList.add(new QuizModal(R.drawable.ruby,"Dart","C","Ruby","C++","Ruby"));



    }

    private void displayBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.LScore));
        TextView score = bottomSheetView.findViewById(R.id.idScore);
        Button reStartQuizBtn = bottomSheetView.findViewById(R.id.restart);
        Button share = bottomSheetView.findViewById(R.id.share);
        score.setText("Your Score is : \n"+currentScore + "/8");
        reStartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos=0;
                setDataView(currentPos);
                QuestionsAttempted =1;
                currentScore=0;
                bottomSheetDialog.dismiss();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                String s ="https://meme-api.herokuapp.com/gimme";
                intent.putExtra(Intent.EXTRA_TEXT,"My Score is : "+ s + "/8");
                intent.setType("Text/Plain");
                Intent shareIntent = Intent.createChooser(intent,"Share This Score");
                startActivity(shareIntent);
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void setDataView(int currentPos) {
        Intent intent = new Intent();
        questionNumberTv.setText("Questions Attempted : " +QuestionsAttempted + "/8");

        if(QuestionsAttempted == 8){
            displayBottomSheet();
        }else{
//            imageView.animate().alpha(1).scaleX(0.5f).scaleY(0.5f).setDuration(2000);
            imageView.animate().alpha(1).scaleX(0.5f).scaleY(0.5f).setDuration(2000);
            imageView.setImageResource(quizModalArrayList.get(currentPos).imageView);
            option1.setText(quizModalArrayList.get(currentPos).getOption1());
            option2.setText(quizModalArrayList.get(currentPos).getOption2());
            option3.setText(quizModalArrayList.get(currentPos).getOption3());
            option4.setText(quizModalArrayList.get(currentPos).getOption4());

        }

    }

    public void nextQuestions(View view) {
        if(QuestionsAttempted<=9) {
            currentPos++;
            QuestionsAttempted++;
            imageView.setAlpha(0f);
            setDataView(currentPos);
        }else{
            displayBottomSheet();
        }
    }
}