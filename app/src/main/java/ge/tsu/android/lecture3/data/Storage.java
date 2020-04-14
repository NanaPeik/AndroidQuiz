package ge.tsu.android.lecture3.data;

import android.content.Context;

public interface Storage {

  void save(Context context, String key, String value);

  String get(Context context, String key);

  boolean exists(Context context, String key);
}
