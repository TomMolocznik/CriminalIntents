package tommolocznik.com.criminalintents;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by tommolocznik on 9/21/14.
 */
public class CrimeLab

{
    private ArrayList<Crime> mCrimes;
    private static CrimeLab sCrimeLab;
    private Context mAppContext;

    private CrimeLab(Context appContext)
    {
        mAppContext = appContext;
        mCrimes = new ArrayList<Crime>();
        for (int i = 0; i < 100; i ++)
        {
            Crime c = new Crime();
            c.setTitle(" Crime #" + i);
            c.setSolved( i % 2 == 0);
            mCrimes.add( c);
        }
     }

    public static CrimeLab get(Context c)
    {
        if (sCrimeLab == null)
        {
            sCrimeLab = new CrimeLab(c.getApplicationContext());
        }
        return sCrimeLab;
    }

    public ArrayList<Crime> getCrimes(){ return mCrimes; }

    public void addCrime(Crime c){ mCrimes.add(c); }

    public Crime getCrime(UUID id)
    {
        for (Crime crime : mCrimes){
            if (crime.getId().equals(id))
                return  crime;
        }
        return null;
    }

}
