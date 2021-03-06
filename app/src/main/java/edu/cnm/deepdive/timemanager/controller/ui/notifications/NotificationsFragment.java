package edu.cnm.deepdive.timemanager.controller.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.timemanager.R;

/**
 * This class contains an onCreate method that only invokes when the app is first installed.
 */
public class NotificationsFragment extends Fragment {

  private NotificationsViewModel notificationsViewModel;

  /**
   * onCreate method invokes when the app is first installed.
   * @param inflater
   * @param container
   * @param savedInstanceState
   * @return
   */
  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    notificationsViewModel =
        ViewModelProviders.of(this).get(NotificationsViewModel.class);
    View root = inflater.inflate(R.layout.fragment_notifications, container, false);
    final TextView textView = root.findViewById(R.id.text_notifications);
    notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
        textView.setText(s);
      }
    });
    return root;
  }
}
