package tommolocznik.com.criminalintents;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.Date;

/**
 * Created by tommolocznik on 9/21/14.
 */
public class CrimeFragment extends Fragment{

    Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckbox;
    public Date currentDate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();

    }

    private void updateDate()
    {
        currentDate = mCrime.getDate();
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("EEE MMM dd yyyy");
        String formattedCurrentDate = simpleDateFormat.format(currentDate);
        mDateButton.setText(formattedCurrentDate);

    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle savedInstanceState) {

       View v = inflater.inflate(R.layout.fragment_crime,parent, false);


        mDateButton = (Button)v.findViewById(R.id.crime_date);
        mDateButton.setEnabled(false);
        updateDate();

        mTitleField = (EditText)v.findViewById( R.id.crime_title);
        mTitleField.addTextChangedListener(new TextWatcher()
        {
            public void onTextChanged(CharSequence c, int start, int before, int count)
            {
                mCrime.setTitle( c.toString());
            }
            public void beforeTextChanged(CharSequence c, int start, int count, int after) { }
            public void afterTextChanged(Editable c) {  }
        });

        mSolvedCheckbox = (CheckBox)v.findViewById(R.id.crime_solved);
        mSolvedCheckbox.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked)
            {
                mCrime.setSolved(isChecked);
            }
        });

            return v;
    }

}
