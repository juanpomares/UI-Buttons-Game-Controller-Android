package es.fempa.juanpomares.uicontrollers;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ButtonView.ButtonListener {

    private ButtonView mButtonView;
    private TextView mButtonPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonView=findViewById(R.id.buttonView);
        mButtonPressed=findViewById(R.id.pressedButton);

        mButtonView.setButtonListener(this);
    }


    private String getNameButton(ButtonView.ButtonName button)
    {
        switch (button)
        {
            case Up:
                return getString(R.string.button_up);
            case Right:
                return getString(R.string.button_right);
            case Down:
                return getString(R.string.button_down);
            case Left:
                return getString(R.string.button_left);
            case Center:
                return getString(R.string.button_center);
            default:
                return getString(R.string.button_none);
        }
    }

    @Override
    public void onButtonPress(View v, ButtonView.ButtonName PressedButton)
    {
        mButtonPressed.setText(getText(R.string.button_pressed)+": "+getNameButton(PressedButton));
    }

    @Override
    public void onButtonHold(View v, ButtonView.ButtonName HoldButton)
    {
        mButtonPressed.setText(getText(R.string.button_pressed)+": "+getText(R.string.button_none));
    }
}