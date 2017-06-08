package ca.bart.tp1minesweeper;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import java.util.Random;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

class GridCell
{
    public boolean has_mine = false;
    public boolean is_marked = false;
}

public class MineSweeperRicardo extends Activity
{
    public static final String TAG = "SWAG";
    public static final String SHARED_PREFS = "Prefs";

    public int mine_count = 10;

    public int max_width = 10;
    public int max_height = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        Log.d(TAG, "OnCreate(" + savedInstanceState + ")");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_sweeper_ricardo);

        GridManager();

    }

    public void GridManager()
    {
        GridLayout gridLayout = (GridLayout) findViewById(R.id.grid);

        int x_random = randInt(0, max_width);
        int y_random = randInt(0, max_height);

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                final int x = j;
                final int y = i;

                Button button = (Button) gridLayout.getChildAt(j * 10 + i);
                button.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        onCellClick(x, y);
                    }
                });
            }
        }
    }

    public Button getButtonByCoordinate(int x, int y)
    {
        GridLayout gridLayout = (GridLayout) findViewById(R.id.grid);
        return (Button) gridLayout.getChildAt(y * 10 + x);
    }

    public void onCellClick(int x, int y)
    {
        exposeCell(x,y);
    }

    public void exposeCell(int x, int y)
    {
        GridCell grid = new GridCell();

        boolean check_mine = grid.has_mine;
        boolean check_marked = grid.is_marked;
        check_mine = true;

        // if(already exposed)
        //      do nothing ( return )
        //      set flag to true
         if(check_mine == true)
         {

         }
        //  Game Over
         if(check_mine == false)
         {
             //Refresh(x, y);
             setButton(x, y);
         }
        //  expose Cell on 8 neighbours
    }

    public void Refresh(int x, int y)
    {
        // Update the drawables
        for(int i = 0; i < x; i++)
        {
            for(int j = 0; j < y; j++)
            {
                setButton(i, j);
            }
        }
    }


    public void setButton(int x, int y)
    {
        Button button_to_mod = (Button) getButtonByCoordinate(x, y);
        button_to_mod.setBackgroundResource(R.drawable.button_empty);
    }


    public void OnMyButtonClick(View v)
    {
        TextView text = (TextView) findViewById(R.id.new_game_button);
        text.setText(("Goodbye World"));
    }

    public int randInt(int min, int max)
    {
    Random rand = new Random();
    int random_number = rand.nextInt((max - min) + 1) + min;
    return random_number;
    }


    @Override
    protected void onStart()
    {
        Log.d(TAG, "onStart()");
        super.onStart();

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, 0);
    }


    @Override
    protected void onRestart()
    {
        Log.d(TAG, "onRestart()");
        super.onRestart();
    }

    protected void OnPause(){
        Log.d(TAG, "onPause()");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume()");
        super.onResume();
    }

    protected void onStop(){
        Log.d(TAG, "onStop()");
        super.onStop();

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
    }

    protected void onSaveInstanceState(Bundle outState){
        Log.d(TAG, "onSaveInstanceState(" +outState+")");
        super.onSaveInstanceState(outState);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState){
        Log.d(TAG, "onRestoreInstanceState(" + savedInstanceState + ")");
        super.onRestoreInstanceState(savedInstanceState);
    }
}
