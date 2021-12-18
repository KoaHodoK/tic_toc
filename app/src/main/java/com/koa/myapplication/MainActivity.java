package com.koa.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void BuClick(View view) {
        Button buttonSelected= (Button) view;

        int CellID=0;
        switch(view.getId()){
            case R.id.bt1:
                CellID=1;
                break;
            case R.id.bt2:
                CellID=1;
                break;
            case R.id.bt3:
                CellID=3;
                break;
            case R.id.bt4:
                CellID=4;
                break;
            case R.id.bt5:
                CellID=5;
                break;
            case R.id.bt6:
                CellID=6;
                break;
            case R.id.bt7:
                CellID=7;
                break;
            case R.id.bt8:
                CellID=8;
                break;
            case R.id.bt9:
                CellID=9;
                break;


        }
        PlayGame(CellID,buttonSelected);
    }
    int ActivePlayer=1;

    ArrayList<Integer> Player1=new ArrayList<>();
    ArrayList<Integer> Player2=new ArrayList<>();
    void PlayGame(int cellId,Button button){


        if(ActivePlayer==1){
            button.setText("X");
            button.setBackgroundColor(Color.GREEN);
            Player1.add(cellId);
            Log.d("You: ",String.valueOf(cellId));
            ActivePlayer=2;
            AutoPlay();

        }
        else if(ActivePlayer==2){
            button.setText("O");
            button.setBackgroundColor(Color.RED);
            Player2.add(cellId);
            ActivePlayer=1;

        }

        button.setEnabled(false);
        CheckWinner();
    }
    void CheckWinner(){
        int Winner=-1;

            //First Case
            if(Player1.contains(1) && Player1.contains(2) && Player1.contains(3)){
                Winner=1;
            }
            if(Player2.contains(1) && Player2.contains(2) && Player2.contains(3)){
                Winner=2;
            }
            //Second Case
            if(Player1.contains(4) && Player1.contains(5) && Player1.contains(6)){
                Winner=1;
            }
            if(Player2.contains(4) && Player2.contains(5) && Player2.contains(6)){
                Winner=2;
            }
            //Third Case
            if(Player1.contains(7) && Player1.contains(8) && Player1.contains(9)){
                Winner=1;
            }
            if(Player2.contains(7) && Player2.contains(8) && Player2.contains(9)){
                Winner=2;
            }
            //Fourth Case
            if(Player1.contains(3) && Player1.contains(6) && Player1.contains(9)){
                Winner=1;
            }
            if(Player2.contains(3) && Player2.contains(6) && Player2.contains(9)){
                Winner=2;
            }
            //Fifth Case
            if(Player1.contains(2) && Player1.contains(5) && Player1.contains(8)){
                Winner=1;
            }
            if(Player2.contains(2) && Player2.contains(5) && Player2.contains(8)){
                Winner=2;
            }
            //Sixth Case
            if(Player1.contains(1) && Player1.contains(4) && Player1.contains(8)){
                Winner=1;
            }
            if(Player2.contains(1) && Player2.contains(4) && Player2.contains(8)){
                Winner=2;
            }
            //Seventh Case
            if(Player1.contains(1) && Player1.contains(5) && Player1.contains(9)){
                Winner=1;
            }
            if(Player2.contains(1) && Player2.contains(5) && Player2.contains(9)){
                Winner=2;
            }
            //Eighth Case
            if(Player1.contains(3) && Player1.contains(5) && Player1.contains(7)){
                Winner=1;
            }
            if(Player2.contains(3) && Player2.contains(5) && Player2.contains(7)){
                Winner=2;
            }




        if(Winner!=-1){
            if(Winner==1){
                ActivePlayer=0;
                Toast.makeText(this, "Player 1 is Winner!", Toast.LENGTH_SHORT).show();
            }
            if(Winner==2){
              ActivePlayer=0;
                Toast.makeText(this, "Player 2 is Winner!", Toast.LENGTH_SHORT).show();
            }


        }

    }
    void AutoPlay(){
        ArrayList<Integer> EmptyCells=new ArrayList<>();
        for(int i=1;i<10;i++){
            if(!(Player1.contains(i) || Player2.contains(i))){
                EmptyCells.add(i);
            }
        }
        Random random=new Random();
        int randomIndex=random.nextInt(EmptyCells.size()-0)+0;
        int Cell_Id=EmptyCells.get(randomIndex);
        Log.d("Random CELL No:",String.valueOf(Cell_Id));
        Button btnSelected;
        switch (Cell_Id){
            case 1:
                btnSelected=findViewById(R.id.bt1);
                break;
            case 2:
                btnSelected=findViewById(R.id.bt2);
                break;
            case 3:
                btnSelected=findViewById(R.id.bt3);
                break;
            case 4:
                btnSelected=findViewById(R.id.bt4);
                break;
            case 5:
                btnSelected=findViewById(R.id.bt5);
                break;
            case 6:
                btnSelected=findViewById(R.id.bt6);
                break;
            case 7:
                btnSelected=findViewById(R.id.bt7);
                break;
            case 8:
                btnSelected=findViewById(R.id.bt8);
                break;
            case 9:
                btnSelected=findViewById(R.id.bt9);
                break;
            default:
                btnSelected=findViewById(R.id.bt1);
                break;

        }
        PlayGame(Cell_Id,btnSelected);
    }
}