package edu.cnm.deepdive.timemanager.controller.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * This class contains methods that invoke the viewmodel
 */
public class NotificationsViewModel extends ViewModel {

  private MutableLiveData<String> mText;

  /**
   * this method displays text on the screen to designate the page.
   */
  public NotificationsViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue("");
  }

  /**
   * this method returns the text
   * @return mText
   */
  public LiveData<String> getText() {
    return mText;
  }
}