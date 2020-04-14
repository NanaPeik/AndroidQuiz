package ge.tsu.android.lecture3;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ge.tsu.android.lecture3.data.Storage;
import ge.tsu.android.lecture3.data.StorageSharePreferenceImpl;

public class HomeActivity extends AppCompatActivity {

  private TextView mPoint;
  private TextView musername;
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    mPoint=findViewById(R.id.resultid);
    musername=findViewById(R.id.usernameid);
    Intent intent = getIntent();
    if (intent.hasExtra("username")) {
      musername.setText(intent.getStringExtra("username"));
    }
    if(intent.hasExtra("point")){
      mPoint.setText(intent.getStringExtra("point"));
    }
    if(intent.hasExtra("point1")){
      mPoint.setText(intent.getStringExtra("point1"));
    }
  }

  public void logout(View view) {
    Storage storage = new StorageSharePreferenceImpl();
    storage.save(this, "logged_user", null);
    Intent intent = new Intent(this, LauncherActivity.class);
    startActivity(intent);
    finish();
  }
}
