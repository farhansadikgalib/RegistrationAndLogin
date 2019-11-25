package com.farhan.registrationandlogin;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFragment extends Fragment {
    EditText emailET;
    EditText numberET;
    EditText passET;
    Button reg_btn;

    private SingupInterface singupInterface;



    public RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        emailET = view.findViewById(R.id.emailET);
        numberET = view.findViewById(R.id.phoneET);
        passET = view.findViewById(R.id.passET);
        reg_btn = view.findViewById(R.id.btn_singUp);
        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = emailET.getText().toString();
                String phone = numberET.getText().toString();
                String pass= passET.getText().toString();

                singupInterface = (SingupInterface) getActivity();
                singupInterface.onSingUpComplete(email);

            }
        });




    }

    interface SingupInterface {

        void  onSingUpComplete(String email);


    }
}
