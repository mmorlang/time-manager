package edu.cnm.deepdive.timemanager.viewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import edu.cnm.deepdive.timemanager.model.AppInfo;
import edu.cnm.deepdive.timemanager.service.AppInfoRepository;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;

public class MainViewModel extends AndroidViewModel implements LifecycleObserver {

  private final MutableLiveData<Boolean> permissionsChecked;
  private final AppInfoRepository repository;
  private final MutableLiveData<List<AppInfo>> apps;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;

  public MainViewModel(@NonNull Application application) {
    super(application);
    permissionsChecked = new MutableLiveData<>(false);
    repository = new AppInfoRepository(application);
    apps = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();
  }

  public LiveData<Boolean> getPermissionsChecked() {
    return permissionsChecked;
  }

  public void setPermissionsChecked(boolean checked) {
    permissionsChecked.setValue(checked);
  }



  public LiveData<List<AppInfo>> getApps() {
    return apps;
  }

  public void refreshApps() {
    pending.add(
        repository.getPackages()
            .subscribe(
                apps::postValue,
                throwable::postValue
            )
    );
  }

  @OnLifecycleEvent(Event.ON_STOP)
  private void clearPending() {
    pending.clear();
  }

}