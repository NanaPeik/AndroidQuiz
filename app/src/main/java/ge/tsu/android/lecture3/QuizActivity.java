package ge.tsu.android.lecture3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import ge.tsu.android.lecture3.data.Storage;
import ge.tsu.android.lecture3.data.StorageSharePreferenceImpl;

public class QuizActivity extends AppCompatActivity {

    private String username;
    private TextView answer1;
    private TextView answer2;
    private TextView answer3;
    private TextView answer4;
    private TextView answer5;
    private TextView answer6;
    private TextView answer7;
    private int sumpoint=0;
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_quiz);
    answer1=findViewById(R.id.ans12);
    answer2=findViewById(R.id.ans21);
    answer3=findViewById(R.id.ans33);
    answer4=findViewById(R.id.ans42);
    answer5=findViewById(R.id.ans53);
    answer6=findViewById(R.id.ans62);
    answer7=findViewById(R.id.ans73);
    Intent intent = getIntent();
    if (intent.hasExtra("username")) {
      username=intent.getStringExtra("username");
    }
  }
    public void pluspoint(View view){
      TextView tv=(TextView)view;
      TextView textView=(TextView)findViewById(tv.getId());
      textView.setTextColor(Color.GREEN);
      sumpoint++;
    }
    Storage storage = new StorageSharePreferenceImpl();
    public void showAnswer(View view) {
        if(sumpoint!=0){
            String string=String.valueOf(sumpoint);
            storage.save(this, username, string);
            Intent intent = new Intent(this, HomeActivity.class);
            Intent intent1=new Intent(this,LauncherActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("point",string);
            intent1.putExtra("point",string);
            startActivity(intent1);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "You have not done a Test yet", Toast.LENGTH_LONG).show();
            return;
        }
    }
}
