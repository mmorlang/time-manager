package edu.cnm.deepdive.timemanager.service;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

/**
 * adds the ability to implements google sign in services.
 */
public class GoogleSignInService {

  private static Application context;

  private final GoogleSignInClient client;
  private final MutableLiveData<GoogleSignInAccount> account;
  private final MutableLiveData<Throwable> throwable;

  /**
   * allows app to use google sign in/ requests needed information to sign in.
   */
  private GoogleSignInService() {
    account = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    GoogleSignInOptions options = new GoogleSignInOptions.Builder()
        .requestEmail()
        .requestId()
        .requestProfile()
        //  .requestIdToken(BuildConfig.CLIENT_ID)
        .build();
    client = GoogleSignIn.getClient(context, options);
  }

  public static void setContext(Application context) {
    GoogleSignInService.context = context;
  }

  public static GoogleSignInService getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public LiveData<GoogleSignInAccount> getAccount() {
    return account;
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  /**
   * refreshes google sign in account.
   * @return
   */
  public Task<GoogleSignInAccount> refresh() {
    return client.silentSignIn()
        .addOnSuccessListener(this::update)
        .addOnFailureListener(this::update);
  }

  /**
   * starts the sign in process.
   * @param activity
   * @param requestCode
   */
  public void startSignIn(Activity activity, int requestCode) {
    update((GoogleSignInAccount) null);
    Intent intent = client.getSignInIntent();
    activity.startActivityForResult(intent, requestCode);
  }

  /**
   * completes the sign in process.
   * @param data
   * @return
   */
  public Task<GoogleSignInAccount> completeSignIn(Intent data) {
    Task<GoogleSignInAccount> task = null;
    try {
      task = GoogleSignIn.getSignedInAccountFromIntent(data);
      update(task.getResult(ApiException.class));
    } catch (ApiException e) {
      update(e);
    }
    return task;
  }

  /**
   * signs the user out.
   * @return
   */
  public Task<Void> signOut() {
    return client.signOut()
        .addOnCompleteListener((ignored) -> update((GoogleSignInAccount)null));
  }

  /**
   *   updates the users account.
   */
  private void update(GoogleSignInAccount account) {
    this.account.setValue(account);
    this.throwable.setValue(null);
  }

  /**
   *   updates throwable.
   */
  private void update(Throwable throwable) {
    this.account.setValue(null);
    this.throwable.setValue(throwable);
  }

  /**
   * holds instance
   */
  private static class InstanceHolder {

    /**
     * holds instance of google sign in service.
     */
    private static final GoogleSignInService INSTANCE = new GoogleSignInService();

  }

}
