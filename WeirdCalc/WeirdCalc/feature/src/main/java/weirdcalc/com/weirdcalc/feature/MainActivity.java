package weirdcalc.com.weirdcalc.feature;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText answers;
    private TextView problem;
    private TextView response;
    private TextView score;
    private TextView streak;
    private TextView downgrade;
    private Button check;
    private Button problemGiver;
    private RadioButton minus;
    private RadioButton plus;
    private RadioButton multi;
    private RadioButton divide;
    private boolean sub = false;
    private boolean add = false;
    private boolean times = false;
    private boolean div = false;
    private int gen;
    int tries = 1;
    int count = 0;
    int wrong = 0;
    int row = 0;
    int again = 0;
    int life = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //answers = findViewById(R.id.);
        answers = findViewById(R.id.Answer);
        problem = findViewById(R.id.problemView);
        response = findViewById(R.id.response);
        check = findViewById(R.id.check);
        problemGiver = findViewById(R.id.problemGiver);
        minus = findViewById(R.id.rMinus);
        plus = findViewById(R.id.rPlus);
        multi = findViewById(R.id.rMultiply);
        divide = findViewById(R.id.rDivide);
        score = findViewById(R.id.score2);
        streak = findViewById(R.id.streak2);
        downgrade = findViewById(R.id.wrong2);
        check.setEnabled(false);



    }

    public void RadioButtonClick(View view){
        boolean checked = ((RadioButton)view).isChecked();

        int id = view.getId();
        if (id == R.id.rMinus){
            if (checked)
                sub = true;
                add = false;
                times = false;
                div = false;
        }
        else if(id == R.id.rPlus){
            if (checked)
                add = true;
                sub = false;
                times = false;
                div = false;

        }
        else if (id == R.id.rMultiply ){
            if (checked)
                times = true;
                add = false;
                sub = false;
                div = false;

        }
        else if (id == R.id.rDivide){
            if (checked)
                div = true;
                add = false;
                sub = false;
                times = false;
        }

    }

    public void Subtract(){
        Random rand = new Random();
        boolean find = true;
        if(again <= 4&& row !=5) {
            while (find) {
                int num1 = rand.nextInt(89) + 10;
                int num2 = rand.nextInt(89) + 10;
                if (num1 > num2) {
                    problem.setText("" + num1 + " - " + num2 + " = ?");
                    find = false;
                    gen = num1 - num2;
                    downgrade.setText("");
                }
            }
        }
        else if(row >= 5 && wrong <= 2){
            while (find) {
                int num1 = rand.nextInt(600) + 100;
                int num2 = rand.nextInt(400) + 120;
                if (num1 > num2) {
                    problem.setText("" + num1 + " - " + num2 + " = ?");
                    find = false;
                    gen = num1 - num2;

                }
            }
        }

        else if(wrong == 3)
        {
            row = 0;
            wrong = 0;
        }
    }
    public void Plus (){
        Random rand = new Random();
        boolean find = true;
        if(again <= 4 && row !=5) {
            while(find) {
                int num1 = rand.nextInt(89) + 10;
                int num2 = rand.nextInt(89) + 10;
                problem.setText(""+num1 + " + " + num2+ " = ?");
                find = false;
                gen = num1 + num2;
                downgrade.setText("");

            }
        }
        else if(row >= 5 && wrong <= 2){
            while (find) {
                int num1 = rand.nextInt(600) + 100;
                int num2 = rand.nextInt(300) + 100;
                if (num1 > num2) {
                    problem.setText("" + num1 + " + " + num2 + " = ?");
                    find = false;
                    gen = num1 + num2;
                }
            }
        }

        else if(wrong == 3)
        {
            row = 0;
            wrong = 0;
        }
    }
    public void Multiply (){
        Random rand = new Random();

        if(again <= 4&& row !=5) {
            int num1 = rand.nextInt(89) + 10;
            int num2 = rand.nextInt(89) + 10;
            problem.setText("" + num1 + " x " + num2 + " = ?");
            gen = num1 * num2;
            downgrade.setText("");

        }
        else if(row >= 5 && wrong <= 2){
                int num1 = rand.nextInt(600) + 170;
                int num2 = rand.nextInt(400) + 300;
                if (num1 > num2) {
                    problem.setText("" + num1 + " x " + num2 + " = ?");
                    gen = num1 * num2;
                }
            }


        else if(wrong == 3)
        {
            row = 0;
            wrong = 0;
        }
    }
    public void Divide(){
        Random rand = new Random();
        boolean find = true;
        if(again <= 4 && row !=5) {
            downgrade.setText("");
            while(find) {
                int num1 = rand.nextInt(89) + 10;
                int num2 = rand.nextInt(89) + 10;
                if(num1 > num2){
                    int zero = num1%num2;
                    if(zero == 0){
                        problem.setText(""+num1 + " / " + num2 + " = ?");
                        find = false;
                        gen = num1 / num2;}
                }
            }
        }
        else if(row >= 5 && wrong <= 2) {
            while (find) {
                int num1 = rand.nextInt(600) + 100;
                int num2 = rand.nextInt(300) + 100;
                if (num1 > num2) {
                    int zero = num1 % num2;
                    int remainder = num1/num2;
                    if (zero == 0 && remainder >= 1 ) {
                        problem.setText("" + num1 + " / " + num2 + " = ?");
                        find = false;
                        gen = num1 / num2;
                    }
                }
            }
        }

         else if(wrong == 3)
        {
            row = 0;
            wrong = 0;
        }
    }

    public void giveProblem(View view) {
    check.setEnabled(true);

        if(sub == true) {
            answers.setText("");
            response.setText("");
            tries = 1;
            Subtract();
        }
        else if (add == true) {
            answers.setText("");
            response.setText("");
            tries = 1;
            Plus();
        }
        else if (div == true) {
            answers.setText("");
            response.setText("");
            tries = 1;
            Divide();
        }
        else if (times == true) {
            answers.setText("");
            response.setText("");
            tries = 1;
            Multiply();
        }


    }

    public void checkAnswer(View view) {
      try {
          InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
          inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
          String input = answers.getText().toString();
          int y = Integer.parseInt(input);


          if (gen == y) {
              check.setEnabled(false);
              response.setText("Great Job!");
              count++;
              again++;
              if(again == 5)
                  row = 5;

              score.setText("Score: "+ count);
              streak.setText("Streak: " + again);
          }
          else if (tries != 0) {
              if (gen != y) {
                  response.setText("Try 1 more time!");
                  tries = 0;
                  again = 0;
                  score.setText("Score: "+ count);
                  streak.setText("Streak: " + again);

                  if( row>= 5) {
                      wrong = wrong + 1;
                      downgrade.setText("Strike: " + wrong);
                      }

                  }
              }

          //if (answers.getText().toString().toString().isEmpty()){
          //     noInput();
          // }
          else if (tries == 0) {
              check.setEnabled(false);
              response.setText(" The correct answer is: " + gen);

          }
      }
        catch(Exception e){
            Toast.makeText(getApplicationContext(),"Please provide input",Toast.LENGTH_LONG).show();

        }

    }

}