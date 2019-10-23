package ru.pereudin.hw5;

import android.util.Log;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class RoomPresenter {

    private static final String TAG = "RoomPresenter";

    private UserDao userDao;

    public RoomPresenter() {
        userDao = App.getAppDatabase().userDao();
    }

    public void addUser(String name, String surname, String age) {
        User user = new User();
        user.name = name;
        user.surname = surname;
        user.age = age;

        Disposable disposable = userDao.insert(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> {
                    Log.d(TAG, "addUser: " + id);
                }, throwable -> {
                    Log.d(TAG, "addUser: ", throwable);
                });
    }

    public void updateUser(int user_id, String name, String surname, String age) {
        User user = new User();
        user.id = user_id;
        user.name = name;
        user.surname = surname;
        user.age = age;

        Disposable disposable = userDao.update(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> {
                    Log.d(TAG, "updateUser: " + id);
                }, throwable -> {
                    Log.d(TAG, "updateUser: ", throwable);
                });
    }

    public void deleteUser(int user_id) {
        User user = new User();
        user.id = user_id;

        Disposable disposable = userDao.delete(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> {
                    Log.d(TAG, "deleteUser: " + id);
                }, throwable -> {
                    Log.d(TAG, "deleteUser: ", throwable);
                });
    }

}
