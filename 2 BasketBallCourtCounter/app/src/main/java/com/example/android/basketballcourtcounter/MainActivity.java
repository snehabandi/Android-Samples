package com.example.android.basketballcourtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA;
    int scoreTeamB;
    int foulTeamA;
    int foulTeamB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreTeamA = 0;
        scoreTeamB = 0;
        foulTeamA = 0;
        foulTeamB = 0;
    }
    /**
     * Increase the scoreTeamA for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        scoreTeamA += 1;
        displayForTeamA();
    }

    /**
     * Increase the scoreTeamA for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        scoreTeamA +=  2;
        displayForTeamA();
    }

    /**
     * Increase the scoreTeamA for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {
        scoreTeamA += 3;
        displayForTeamA();
    }

    public void displayFoulTeamA(View v) {
        foulTeamA += 1;
        displayFoulTeamA();
    }
    //Displays the given scoreTeamA for Team A.
    public void displayForTeamA() {
        if(foulTeamA<5 && foulTeamB<5){                    //Team A foul check
            TextView scoreView = (TextView) findViewById(R.id.team_a_score);
            scoreView.setText(String.valueOf(scoreTeamA));
            //-----> Updation disabled if either team is disqualified
        }
        else                                //If fouls greater than 5 team is disqualified
            displayFoulTeamA();
    }

    //Count the fouls by Team A
    public void countFoulTeamA(View v) {
        foulTeamA += 1;
        displayFoulTeamA();
    }

    //Displays the fouls by Team A.
    public void displayFoulTeamA() {

        TextView scoreView = (TextView) findViewById(R.id.team_a_foul);
        scoreView.setText(String.valueOf("Fouls : \n"+foulTeamA));

        TextView scoreView1 = (TextView) findViewById(R.id.team_foul_message);
        if(foulTeamA==4)            //Warning message for 4 fouls by team A
            scoreView1.setText(String.valueOf("Warning!Team A will be disqualified on 5th foul!"));
        if(foulTeamA==5)            //Disqualification of team A
            scoreView1.setText(String.valueOf("Team A is disqualified as 5 team fouls!"));
        if(foulTeamA>5)            //After Disqualification of team A if button pressed
        {
            scoreView1.setText(String.valueOf("MATCH IS OVER"));
            foulTeamA = 5;
            scoreView.setText(String.valueOf("Fouls : \n"+foulTeamA));
        }

    }

    //---------------------------->> TEAM B

    //Increase the scoreTeamB for Team B by 1 point.
    public void addOneForTeamB(View v) {
        scoreTeamB += 1;
        displayForTeamB();
    }

    //Increase the scoreTeam B for Team B by 2 points.
    public void addTwoForTeamB(View v) {
        scoreTeamB += 2;
        displayForTeamB();
    }

    // Increase the scoreTeamB for Team B by 3 points.
    public void addThreeForTeamB(View v) {
        scoreTeamB += 3;
        displayForTeamB();
    }

    //Displays the given scoreTeamB for Team B.
    void displayForTeamB() {
        if(foulTeamB<5 && foulTeamA<5) {               //Team B foul check
            TextView scoreView = (TextView) findViewById(R.id.team_b_score);
            scoreView.setText(String.valueOf(scoreTeamB));
            //-----> Updation disabled if either team is disqualified
        }
        else                            //If team B fouls greater than 5 B team is disqualified
            displayFoulTeamB();
    }

    //Count the fouls by Team A
    public void countFoulTeamB(View v) {
        foulTeamB += 1;
        displayFoulTeamB();
    }

    //Displays the fouls by Team B.
    public void displayFoulTeamB() {
        TextView scoreView = (TextView) findViewById(R.id.team_b_foul);
        scoreView.setText(String.valueOf("Fouls : \n"+foulTeamB));

        TextView scoreView1 = (TextView) findViewById(R.id.team_foul_message);
        if(foulTeamB==4)                    //Warning message for 4 fouls by team B
            scoreView1.setText(String.valueOf("Warning! Team B will be disqualified on 5th foul!"));
        if(foulTeamB==5)                    //Disqualification of team B
            scoreView1.setText(String.valueOf("Team B is disqualified as 5 team fouls!"));
        if(foulTeamB>5)            //After Disqualification of team B if button pressed
        {
            scoreView1.setText(String.valueOf("MATCH IS OVER"));
            foulTeamB=5;
            scoreView.setText(String.valueOf("Fouls : \n"+foulTeamB));

        }

    }

    //--------------------------------> RESET SCORE AND FOULS OF BOTH TEAMS
    public void resetScoreForBoth(View v) {
        foulTeamA = 0;
        displayFoulTeamA();
        foulTeamB = 0;
        displayFoulTeamB();
        //--- **** Logically foul statements habe to be first or else two clicks will
        // be needed to reset the score of disqualified team as technical
        // updation of scores is allowed only if fouls<5
        scoreTeamB = 0;
        displayForTeamB();
        scoreTeamA = 0;
        displayForTeamA();

        TextView scoreView = (TextView) findViewById(R.id.team_foul_message);
        scoreView.setText("Teams are in foul count limit !!");
    }
}

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/