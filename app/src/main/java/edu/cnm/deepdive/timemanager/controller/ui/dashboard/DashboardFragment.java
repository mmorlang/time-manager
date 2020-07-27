package edu.cnm.deepdive.timemanager.controller.ui.dashboard;

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
public class DashboardFragment extends Fragment {

  private DashboardViewModel dashboardViewModel;

  /**
   * onCreate method invokes when the app is first installed.
   * @param inflater
   * @param container
   * @param savedInstanceState
   * @return
   */
  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    dashboardViewModel =
        ViewModelProviders.of(this).get(DashboardViewModel.class);
    View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
    return root;
  }
}
