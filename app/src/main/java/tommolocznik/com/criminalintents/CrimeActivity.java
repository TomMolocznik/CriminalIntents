package tommolocznik.com.criminalintents;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;


public class CrimeActivity extends SingleFragmentActivity {
 
    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }
}
