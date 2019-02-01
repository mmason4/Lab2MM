package com.example.jsu.lab2mm;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import java.util.Random;
public class MainActivity extends AppCompatActivity {

    Button rock, paper, scissors;
    String result;
    int playerWins;
    int computerWins;



    private Weapon playerWeapon, computerWeapon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rock = findViewById(R.id.ButtonOne);
        paper = findViewById(R.id.ButtonTwo);
        scissors = findViewById(R.id.ButtonThree);
        playerWins = 0;
        computerWins = 0;


    }
         public void onClick(View v){

                Random r = new Random();

                int computerSelection = r.nextInt(3);


                if(computerSelection == 0){
                    computerWeapon = Weapon.ROCK;
                }
                else if (computerSelection == 1){
                    computerWeapon = Weapon.PAPER;
                }
                else if (computerSelection == 2){
                    computerWeapon = Weapon.SCISSORS;
                }

                Button b = (Button)v;

                if (b == rock) {
                    playerWeapon = Weapon.ROCK;
                }

                else if (b == paper) {
                    playerWeapon = Weapon.PAPER;

                }
                else if (b == scissors){
                    playerWeapon = Weapon.SCISSORS;

                }
                TextView one = (TextView) findViewById(R.id.textView);
                TextView two = (TextView) findViewById(R.id.textView2);
                TextView three = (TextView) findViewById(R.id.textView3);
                TextView four = (TextView) findViewById(R.id.textView4);
                checkResult();
                one.setText("Player: " + getPlayerWins() + " " + "Computer: " + getComputerWins());
                two.setText("Player's Weapon: " + playerWeapon.toString());
                three.setText("Computer's Weapon: " + computerWeapon.toString());
                four.setText(result);


         }

         private void checkResult() {


            if (playerWeapon == computerWeapon) {
                result = "Draw!";
            }
            else if (playerWeapon.equals(Weapon.ROCK) && computerWeapon.equals(Weapon.PAPER)) {
                result = "You lose! Paper covers Rock";
                computerWins++;

            }
            else if (playerWeapon.equals(Weapon.PAPER) && computerWeapon.equals(Weapon.ROCK)) {
                result = "You Win! Paper covers Rock ";
                playerWins++;

            }
            else if (playerWeapon.equals(Weapon.SCISSORS) && computerWeapon.equals(Weapon.ROCK)) {
                result = "You lose! Rock blunts Scissors";
                computerWins++;
            }
            else if (playerWeapon.equals(Weapon.ROCK) && computerWeapon.equals(Weapon.SCISSORS)) {
                result = "You Win! Rock blunts Scissors";
                playerWins++;

            }
            else if (playerWeapon.equals(Weapon.PAPER) && computerWeapon.equals(Weapon.SCISSORS)) {
                result = "You lose! Scissors cuts Paper";
                computerWins++;

            }
            else if (playerWeapon.equals(Weapon.SCISSORS) && computerWeapon.equals(Weapon.PAPER)) {
                result = "You Win! Scissors cuts Paper";
                playerWins++;

            }
    }

    public String getPlayerWins(){
        return String.valueOf(this.playerWins);
    }
    public String getComputerWins(){
        return String.valueOf(this.computerWins);
    }




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

        public enum Weapon {

            ROCK("Rock"),
            PAPER("Paper"),
            SCISSORS("Scissors");

            private String message;

            private Weapon(String msg) { message = msg; }

            @Override
            public String toString() { return message; }

        };
}
