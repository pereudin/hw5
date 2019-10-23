package ru.pereudin.hw5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RoomActivity extends AppCompatActivity {

    @BindView(R.id.name_activity_room)
    EditText name_edit_text;

    @BindView(R.id.surname_activity_room)
    EditText surname_edit_text;

    @BindView(R.id.age_activity_room)
    EditText age_edit_text;

    @BindView(R.id.user_id_activity_room)
    EditText user_id_edit_text;

    private RoomPresenter roomPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        ButterKnife.bind(this);

        roomPresenter = new RoomPresenter();
    }

    @OnClick(R.id.button_add_user_activity_room)
    public void onClickButton1(View view) {
        roomPresenter.addUser(name_edit_text.getText().toString(),
                              surname_edit_text.getText().toString(),
                              age_edit_text.getText().toString());
    }

    @OnClick(R.id.button_update_user_activity_room)
    public void onClickButton2(View view) {
        roomPresenter.updateUser(Integer.parseInt(user_id_edit_text.getText().toString()),
                                 name_edit_text.getText().toString(),
                                 surname_edit_text.getText().toString(),
                                 age_edit_text.getText().toString());
    }

    @OnClick(R.id.button_delete_user_activity_room)
    public void onClickButton3(View view) {
        roomPresenter.deleteUser(Integer.parseInt(user_id_edit_text.getText().toString()));
    }

}
