package ge.tsu.android.lecture3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import ge.tsu.android.lecture3.data.Storage;
import ge.tsu.android.lecture3.data.StorageSharePreferenceImpl;

public class LoginActivity extends AppCompatActivity {

  private EditText mUsername;
  private TextView showpoint;
  private Button tryAgainButton;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    mUsername = findViewById(R.id.username);
    showpoint=findViewById(R.id.pointOfExistingusername);
    tryAgainButton=findViewById(R.id.tryagainid);
    tryAgainButton.setVisibility(View.INVISIBLE);
  }

  public void login(View view) {
    String username = mUsername.getText().toString().trim();
    if (username.isEmpty()) {
      Toast.makeText(this, "Please enter credentials", Toast.LENGTH_LONG).show();
      return;
    }
    Storage storage = new StorageSharePreferenceImpl();
    if(storage.exists(this,username)){
      Toast.makeText(this, "User already exists, please enter another", Toast.LENGTH_LONG).show();
      tryAgainButton.setVisibility(View.VISIBLE);
      Intent intent = getIntent();
      if (intent.hasExtra("point")) {
        showpoint.setText("Your Last Point Is :  "+intent.getStringExtra("point"));
//        String string=String.valueOf(showpoint);
//        showpoint.setText("Your Last Point Is :  "+string);
      }
      return;
    }
    Toast.makeText(this, "Successfully login", Toast.LENGTH_LONG).show();
    storage.save(this, "logged_user", username);
    Intent intent = new Intent(this, QuizActivity.class);
    intent.putExtra("username", username);
    startActivity(intent);
    finish();
  }
  public void TryAgain(View view) {
//    Storage storage = new StorageSharePreferenceImpl();
//    storage.save(this, "logged_user", null);
    String username = mUsername.getText().toString().trim();
    Storage storage = new StorageSharePreferenceImpl();
    storage.save(this, "logged_user", username);
    Intent intent = new Intent(this, QuizActivity.class);
    intent.putExtra("username", username);
    startActivity(intent);
    finish();
  }
}
