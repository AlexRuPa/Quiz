package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void analyze(View view){
        int score = 0;
        TextView textViewUserName = (TextView) findViewById(R.id.userName);
        String userName = textViewUserName.getText().toString();
        score += calculateScore(R.id.radioButtonGroup1);
        score += calculateScore(R.id.radioButtonGroup2);
        score += calculateScore(R.id.radioButtonGroup3);
        score += calculateScore(R.id.radioButtonGroup4);
        score += calculateScore(R.id.radioButtonGroup5);
        score += calculateScore(R.id.radioButtonGroup6);
        score += calculateScore(R.id.radioButtonGroup7);
        score += calculateScore(R.id.radioButtonGroup8);
        score += calculateScore(R.id.radioButtonGroup9);
        score += calculateScore(R.id.radioButtonGroup10);
        TextView textView = (TextView) findViewById(R.id.scoreText);
        textView.setText(getText(R.string.messageIntro) + " " + userName + getMessage(score));
        textView.setVisibility(View.VISIBLE);
    }

    private String getMessage(int score){
        if (score >= 10 && score <= 20){
            if (score - 10 < 20 - score){
                return getText(R.string.messageLikert1).toString();
            }else {
                return getText(R.string.messageLikert2).toString();
            }
        }
        if (score >= 20 && score <= 30){
            if (score - 20 < 30 - score){
                return getText(R.string.messageLikert2).toString();
            }else {
                return getText(R.string.messageLikert3).toString();
            }
        }
        if (score >= 30 && score <= 40){
            if (score - 30 < 40 - score){
                return getText(R.string.messageLikert3).toString();
            }else {
                return getText(R.string.messageLikert4).toString();
            }
        }
        if (score >= 40 && score <= 50){
            if (score - 40 < 50 - score){
                return getText(R.string.messageLikert4).toString();
            }else {
                return getText(R.string.messageLikert5).toString();
            }
        }
        return "";
    }

    /**
     * Calculate score of given RadioGroup ID
     * @param RadioButtonGroupID given View ID
     * @return int score
     */
    private int calculateScore(int RadioButtonGroupID){
        RadioGroup radioButtonGroup = (RadioGroup) findViewById(RadioButtonGroupID);
        int radioButtonCheckedID = radioButtonGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(radioButtonCheckedID);
        String text = radioButton.getText().toString();
        int score = 0;
        if (text == getText(R.string.likert1)){
            score++;
        }else if (text == getText(R.string.likert2)){
            score += 2;
        }else if (text == getText(R.string.likert3)){
            score += 3;
        }else if (text == getText(R.string.likert4)){
            score += 4;
        }else if (text == getText(R.string.likert5)){
            score += 5;
        }
        return score;
    }
    /** Handle Switch action
     *  call isChecked() (Set answer Visibility)
     * @param
     */
    public void isSwitchTriggered(View view) {
        int switchViewID = view.getId();
        int textViewID = 0;
        switch (switchViewID) {
            case R.id.swithch1:
                textViewID = R.id.answer1;
                break;
            case R.id.swithch2:
                textViewID = R.id.answer2;
                break;
            case R.id.swithch3:
                textViewID = R.id.answer3;
                break;
            case R.id.swithch4:
                textViewID = R.id.answer4;
                break;
            case R.id.swithch5:
                textViewID = R.id.answer5;
                break;
            case R.id.swithch6:
                textViewID = R.id.answer6;
                break;
            case R.id.swithch7:
                textViewID = R.id.answer7;
                break;
            case R.id.swithch8:
                textViewID = R.id.answer8;
                break;
            case R.id.swithch9:
                textViewID = R.id.answer9;
                break;
            case R.id.swithch10:
                textViewID = R.id.answer10;
                break;
        }
        isSwitchChecked(switchViewID, textViewID);
    }

    /**
     * Set Visibility "VISIBLE"  or "GONE" for for TextViews answers
     * @param switchViewID
     * @param textViewID
     */
    private void isSwitchChecked(int switchViewID, int textViewID) {
        Switch switchView = (Switch) findViewById(switchViewID);
        TextView textView = (TextView) findViewById(textViewID);
        if (switchView.isChecked()) {
            textView.setVisibility(View.VISIBLE);
        } else {
            textView.setVisibility(View.GONE);
        }
    }
}
