package com.farhan.registrationandlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RegistrationFragment.SingupInterface {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        RegistrationFragment registrationFragment = new RegistrationFragment();
        fragmentTransaction.add(R.id.fragmentContainer,registrationFragment);
        fragmentTransaction.commit();




    }


    public void getEmail(String email){


    }

    @Override
    public void onSingUpComplete(String name,String phone,String email) {

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("name",name);
        bundle.putString("phone",phone);
        bundle.putString("email",email);
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.fragmentContainer,homeFragment);
        fragmentTransaction.commit();



    }
}
