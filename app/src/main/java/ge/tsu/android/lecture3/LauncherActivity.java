package ge.tsu.android.lecture3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import ge.tsu.android.lecture3.data.Storage;
import ge.tsu.android.lecture3.data.StorageSharePreferenceImpl;

public class LauncherActivity extends Activity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Storage storage = new StorageSharePreferenceImpl();

    if (storage.exists(this, "logged_user")) {
      Intent intent = new Intent(this, HomeActivity.class);
      intent.putExtra("username", storage.get(this, "logged_user"));
      Intent intent1 = new Intent(this, LoginActivity.class);
      intent1.putExtra("point", storage.get(this,storage.get(this, "logged_user")));
      intent.putExtra("point", storage.get(this,storage.get(this, "logged_user")));
      startActivity(intent);
      startActivity(intent1);
    } else {
      Intent intent = new Intent(this, LoginActivity.class);
      startActivity(intent);
    }
    finish();
  }
}
