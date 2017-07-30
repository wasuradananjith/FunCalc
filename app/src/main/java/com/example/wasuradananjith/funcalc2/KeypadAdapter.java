package com.example.wasuradananjith.funcalc2;

/**
 * Created by Wasura Dananjith on 04-Jun-17.
 */

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

public class KeypadAdapter extends BaseAdapter {
    private Context mContext;

    // Declare button click listener variable
    private OnClickListener mOnButtonClick;

    public KeypadAdapter(Context c) {
        mContext = c;
    }

    // Method to set button click listener variable
    public void setOnButtonClickListener(OnClickListener listener) {
        mOnButtonClick = listener;
    }

    public int getCount() {
        return mButtons.length;
    }

    public Object getItem(int position) {
        return mButtons[position];
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ButtonView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Button btn;
        if (convertView == null) { // if it's not recycled, initialize some
            // attributes

            btn = new Button(mContext);
            KeypadButton keypadButton = mButtons[position];

            switch(keypadButton.mCategory)
            {
                case CLEAR:
                    btn.setBackgroundResource(R.drawable.keypadclear1);
                    break;
                case NUMBER:
                    btn.setBackgroundResource(R.drawable.keypad1);
                    break;
                case OPERATOR:

                    btn.setBackgroundResource(R.drawable.keypadop1);
                    break;
                case OTHER:
                    btn.setBackgroundResource(R.drawable.keypadother1);
                    break;
                case RESULT:
                    btn.setBackgroundResource(R.drawable.keypadresult1);
                    break;
                case DUMMY:
                    btn.setBackgroundResource(R.drawable.appvertical1);
                    break;
                default:
                    btn.setBackgroundResource(R.drawable.keypad1);
                    break;
            }
            // Set OnClickListener of the button to mOnButtonClick
            if(keypadButton != KeypadButton.DUMMY)
                btn.setOnClickListener(mOnButtonClick);
            else
                btn.setClickable(false);
            // Set CalculatorButton enumeration as tag of the button so that we
            // will use this information from our main view to identify what to do
            btn.setTag(keypadButton);
        } else {
            btn = (Button) convertView;
        }

        btn.setText(mButtons[position].getText());
        return btn;
    }

    // Create and populate keypad buttons array with CalculatorButton enum
    // values
    private KeypadButton[] mButtons = {KeypadButton.CE,  KeypadButton.C, KeypadButton.BACKSPACE,KeypadButton.DIV,
            KeypadButton.SEVEN,KeypadButton.EIGHT, KeypadButton.NINE,KeypadButton.MULTIPLY,
            KeypadButton.FOUR, KeypadButton.FIVE,KeypadButton.SIX, KeypadButton.MINUS,
            KeypadButton.ONE, KeypadButton.TWO, KeypadButton.THREE, KeypadButton.PLUS,
            KeypadButton.DUMMY, KeypadButton.ZERO,KeypadButton.DUMMY,KeypadButton.CALCULATE };

}
