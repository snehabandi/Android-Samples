package com.example.android.androidquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.drawable;
import static android.R.attr.id;
import static android.R.attr.visible;
import static android.R.attr.windowDrawsSystemBarBackgrounds;
import static android.R.attr.y;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity
{
     static int count = 1;
     static int points =0;
     String question;
     String answer;
     String option1;
     String option2;
     String option3;
     String option4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"Question can have multiple correct answers ",Toast.LENGTH_SHORT).show();
        clearAll();
        setQuestion();
        setOptions();
        displayAll();
    }
    public void setQuestion()
    {
        if(count==1)
            question = new String("Which of the following is android’s logo :");
        if(count==2)
            question = new String("The first android phone :");
        if(count==3)
            question = new String("Is the following statement true?\n'Android was originally developed by Google'.");
        if(count==4)
            question = new String("Kernel that android OS is based on");
        if(count==5)
            question = new String("Name of android version 5.0");
        if(count==6)
            question = new String("Apart from Android version ____ and _____, all other Android versions have been named after sweet treats or desserts");
        if(count == 7)
            question = new String("What is the name of latest android version released?");
        if(count == 8)
            question = new String("Hey ! You did great :)");
    }
    public void setOptions()
    {
        if(count ==1)
        {
            option1 = new String("1. Window");
            option2 = new String("2. Apple");
            option3 = new String("3. Lion");
            option4 = new String("4. Bug");
        }
        if(count ==2)
        {
            option1 = new String("1. HTC 1X");
            option2 = new String("2. T-Mobile G1");
            option3 = new String("3. HTC\nDream");
            option4 = new String("4. BlackBerry");
        }
        if(count ==3)
        {
            option1 = new String("1. True");
            option2 = new String("2. False");
            option3 = new String(" ");
            option4 = new String(" ");
        }
        if(count ==4)
        {
            option1 = new String("1. UNIX");
            option2 = new String("2. LINUX");
            option3 = new String("3. Amiga");
            option4 = new String("4. Mac");
        }
        if(count ==5)
        {
            option1 = new String("1. Nougat");
            option2 = new String("2. Oreo");
            option3 = new String("3. KitKat");
            option4 = new String("4. Lollipop");
        }

        if(count ==6)
        {
            option1 = new String("1) 1.0");
            option2 = new String("2) 1.2");
            option3 = new String("3) 1.1");
            option4 = new String("4) 2.0");
        }
        if(count ==7)
        {
            option1 = new String("");
            option2 = new String("");
            option3 = new String("");
            option4 = new String("");
        }
        if(count==8)
        {
            option1 = "";
            option2 = "";
            option3 = "";
            option4 = "";
        }
    }
    public void displayAll()
    {
        TextView questionNumberTextView = (TextView)findViewById(R.id.question_no_text_view);

        if(count ==8)           //When questions end instead of number "Ends" is printed
            questionNumberTextView.setText(" End");
        else
            questionNumberTextView.setText(" "+count);

        TextView questionTextView = (TextView)findViewById(R.id.question_text_view);
        questionTextView.setText(question);

        TextView option1TextView = (TextView)findViewById(R.id.option1_text_view);
        option1TextView.setText(option1);

        TextView option2TextView = (TextView)findViewById(R.id.option2_text_view);
        option2TextView.setText(option2);

        TextView option3TextView = (TextView)findViewById(R.id.option3_text_view);
        option3TextView.setText(option3);

        TextView option4TextView = (TextView)findViewById(R.id.option4_text_view);
        option4TextView.setText(option4);

    }

    public void showAnswer(View view)
    {
        //Show the next button until and hide submit button
        Button nextButton = (Button)findViewById(R.id.next_button);
        if(count!=8)                            //when quiz ends donot show next button
        nextButton.setVisibility(View.VISIBLE);

        Button submitAnswerButton = (Button)findViewById(R.id.submit_answer_button);
        submitAnswerButton.setVisibility(View.INVISIBLE);

        checkAnswer();
        setAnswer();
        TextView answerTextView = (TextView)findViewById(R.id.answer_text_view);
        answerTextView.setText(answer);
    }

    public void checkAnswer()
    {
        CheckBox option1CheckBox = (CheckBox)findViewById(R.id.checkbox1_text_view);
        CheckBox option2CheckBox = (CheckBox)findViewById(R.id.checkbox2_text_view);
        CheckBox option3CheckBox = (CheckBox)findViewById(R.id.checkbox3_text_view);
        CheckBox option4CheckBox = (CheckBox)findViewById(R.id.checkbox4_text_view);

        RadioButton rbTrue = (RadioButton)findViewById(R.id.radio_button_true);
        RadioButton rbFalse = (RadioButton)findViewById(R.id.radio_button_false);

        boolean checkAnswer;


        if(count == 1 && option1CheckBox.isChecked()==false && option2CheckBox.isChecked()==false && option3CheckBox.isChecked()==false && option4CheckBox.isChecked()==true)
            checkAnswer=true;
        else if(count == 2 && option1CheckBox.isChecked()==false && option2CheckBox.isChecked()==true && option3CheckBox.isChecked()==true && option4CheckBox.isChecked()==false)
            checkAnswer=true;
        else if(count == 3 && rbTrue.isChecked()==false && rbFalse.isChecked()==true)
            checkAnswer=true;
        else if(count == 4 && option1CheckBox.isChecked()==false && option2CheckBox.isChecked()==true && option3CheckBox.isChecked()==false && option4CheckBox.isChecked()==false)
            checkAnswer=true;
        else if(count == 5 && option1CheckBox.isChecked()==false && option2CheckBox.isChecked()==false && option3CheckBox.isChecked()==false && option4CheckBox.isChecked()==true)
            checkAnswer=true;
        else if(count == 6 && option1CheckBox.isChecked()==true && option2CheckBox.isChecked()==false && option3CheckBox.isChecked()==true && option4CheckBox.isChecked()==false)
            checkAnswer=true;
        else if(count==7)
        {
            EditText editTextAnswer = (EditText)findViewById(R.id.answer_edit_text);
            String answer7 = editTextAnswer.getText().toString();
            if (answer7.toLowerCase().equals("oreo")==true)
                checkAnswer=true;
            else
                checkAnswer=false;
        }
        else
            checkAnswer=false;


        if(count !=8 && checkAnswer==true) {            //either of questions 1-6 is true
            points++;
            answer = "Answer => Correct :)\n";
        }
        else if(count !=8 && checkAnswer==false)            //either of questions 1-6 is false
            answer = "Wrong Answer :(\n";
        else if(count ==8)                              //If questions end
            answer = " ";
        else
            answer = "\t\tPlease choose one option only !\n";

    }
    public void setAnswer()
    {
        if(count == 1)
            answer += new String("Option 4 : Android logo isn’t actually called android,Google unofficially calls it Bugdroid :p");
        if(count == 2)
            answer += new String("Option 2 & 3  : HTC Dream also known as T-Mobile G1");
        if(count == 3)
            answer += new String("Option 2 : Initially developed by Android Inc., which Google bought in 2005");
        if(count == 4)
            answer += new String("Option 2 : LINUX kernel");
        if(count == 5)
            answer += new String("Option 4 : Lollipop is android version 5.0, KitKat 4.4,Oreo 8.0,Nougat 7.0");
        if(count == 6)
            answer += new String("Option 1 & 3 : 1.0 and 1.1");
        if(count == 7)
            answer += new String("Oreo version 8.0");
        if(count==8) {
            answer = "\t\tQuiz Ends....\n\t\tYOUR SCORE : " + points + " out of 7 correct ;)";
            Toast.makeText(this, "Your score is " + points +" out of 7", Toast.LENGTH_SHORT).show();
        }

    }

    public void increment(View view)
    {

        if(count<7)
            count++;
        else
            count = 8;

        clearAll();
        setQuestion();
        setOptions();
        displayAll();

    }

    void clearAll()
    {
        //Hide the next button until the viewer has submitted answer
        Button nextButton = (Button)findViewById(R.id.next_button);
        nextButton.setVisibility(View.INVISIBLE);

        //Show the Submit Answer button
        Button submitAnswerButton = (Button)findViewById(R.id.submit_answer_button);
        submitAnswerButton.setVisibility(View.VISIBLE);

        //Make the end image invisible
        ImageView androidImageView = (ImageView)findViewById(R.id.android_image_view);
        androidImageView.setVisibility(View.INVISIBLE);

        //Clear the answer TextView
        TextView answerTextView = (TextView)findViewById(R.id.answer_text_view);
        answer = new String("");
        answerTextView.setText(" ");

        //clear all checked boxes
        CheckBox option1CheckBox = (CheckBox)findViewById(R.id.checkbox1_text_view);
        option1CheckBox.setChecked(false);
        CheckBox option2CheckBox = (CheckBox)findViewById(R.id.checkbox2_text_view);
        option2CheckBox.setChecked(false);
        CheckBox option3CheckBox = (CheckBox)findViewById(R.id.checkbox3_text_view);
        option3CheckBox.setChecked(false);
        CheckBox option4CheckBox = (CheckBox)findViewById(R.id.checkbox4_text_view);
        option4CheckBox.setChecked(false);

        RadioButton rbTrue = (RadioButton)findViewById(R.id.radio_button_true);
        RadioButton rbFalse = (RadioButton)findViewById(R.id.radio_button_false);
        EditText editTextAnswer = (EditText)findViewById(R.id.answer_edit_text);

        //set visibility of text boxes 3 and 4 to true if not 3
        if(count == 3) {
            option1CheckBox.setVisibility(View.INVISIBLE);
            option2CheckBox.setVisibility(View.INVISIBLE);
            option3CheckBox.setVisibility(View.INVISIBLE);
            option4CheckBox.setVisibility(View.INVISIBLE);

            //make radio button visible
            rbTrue.setVisibility(View.VISIBLE);
            rbFalse.setVisibility(View.VISIBLE);


        }
        else if(count==7)
        {
            //set visibility of text boxes to false
            option1CheckBox.setVisibility(View.INVISIBLE);
            option2CheckBox.setVisibility(View.INVISIBLE);
            option3CheckBox.setVisibility(View.INVISIBLE);
            option4CheckBox.setVisibility(View.INVISIBLE);
            //Make EdiText appear
            editTextAnswer.setVisibility(View.VISIBLE);
        }
        else if(count==8)
        {
            //Make all check boxes,radio buttons,Edit text invisible
            option1CheckBox.setVisibility(View.INVISIBLE);
            option2CheckBox.setVisibility(View.INVISIBLE);
            option3CheckBox.setVisibility(View.INVISIBLE);
            option4CheckBox.setVisibility(View.INVISIBLE);
            editTextAnswer.setVisibility(View.INVISIBLE);
            rbTrue.setVisibility(View.INVISIBLE);
            rbFalse.setVisibility(View.INVISIBLE);


            androidImageView.setVisibility(View.VISIBLE);
            submitAnswerButton.setText("Show Score");
        }
        else{
            //set visibility of text boxes to true
            option1CheckBox.setVisibility(View.VISIBLE);
            option2CheckBox.setVisibility(View.VISIBLE);
            option3CheckBox.setVisibility(View.VISIBLE);
            option4CheckBox.setVisibility(View.VISIBLE);

            //Make radio button and edit text invisible
            editTextAnswer.setVisibility(View.INVISIBLE);
            rbTrue.setVisibility(View.INVISIBLE);
            rbFalse.setVisibility(View.INVISIBLE);
        }
    }
}
