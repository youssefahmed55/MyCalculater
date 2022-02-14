package com.example.mycalculator;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.mycalculator.databinding.FragmentCalculatorBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Calculator#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Calculator extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Calculator() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Calculater.
     */
    // TODO: Rename and change types and number of parameters
    public static Calculator newInstance(String param1, String param2) {
        Calculator fragment = new Calculator();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private FragmentCalculatorBinding binding;
    private String s = "";
    private double result;
    private static final String TAG = "youssef";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCalculatorBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        buttonssetonclicklistener();               //onClick for Buttons and EditText
        onclickback();                             //if i click back button
        binding.EdittextCalc.setKeyListener(null); // Disable click on edittext and open keyboard


        return view;
    }

    private void onclickback() {
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
                getActivity().finish();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.C_Calc:
                s = "";
                binding.EdittextCalc.setText(s);
                break;
            case R.id.mutul_Calc:
                if (caninserttool()) {
                    s = s + "%";
                    binding.EdittextCalc.setText(s);
                }
                break;
            case R.id.Clear_Calc:
                if (s.length() > 0) {
                    s = s.substring(0, s.length() - 1);
                    binding.EdittextCalc.setText(s);
                }
                break;
            case R.id.division_Calc:
                if (caninserttool()) {
                    s = s + "/";
                    binding.EdittextCalc.setText(s);
                }
                break;
            case R.id.seven_Calc:
                s = s + "7";
                binding.EdittextCalc.setText(s);
                break;
            case R.id.eight_Calc:
                s = s + "8";
                binding.EdittextCalc.setText(s);
                break;
            case R.id.nine_Calc:
                s = s + "9";
                binding.EdittextCalc.setText(s);
                break;
            case R.id.multiplyy_Calc:
                if (caninserttool()) {
                    s = s + "*";
                    binding.EdittextCalc.setText(s);
                }
                break;
            case R.id.four_Calc:
                s = s + "4";
                binding.EdittextCalc.setText(s);
                break;
            case R.id.five_Calc:
                s = s + "5";
                binding.EdittextCalc.setText(s);
                break;
            case R.id.six_Calc:
                s = s + "6";
                binding.EdittextCalc.setText(s);
                break;
            case R.id.minus_Calc:
                if(s.length()>0){
                if (caninserttool()) {
                    s = s + "-";
                    binding.EdittextCalc.setText(s);
                }}else {
                    s = s + "-";
                    binding.EdittextCalc.setText(s);
                }

                break;
            case R.id.one_Calc:
                s = s + "1";
                binding.EdittextCalc.setText(s);
                break;
            case R.id.two_Calc:
                s = s + "2";
                binding.EdittextCalc.setText(s);
                break;
            case R.id.three_Calc:
                s = s + "3";
                binding.EdittextCalc.setText(s);
                break;
            case R.id.plus_Calc:
                if (caninserttool()) {
                    s = s + "+";
                    binding.EdittextCalc.setText(s);
                }
                break;
            case R.id.multizero_Calc:
                s = s + "00";
                binding.EdittextCalc.setText(s);
                break;
            case R.id.zero_Calc:
                s = s + "0";
                binding.EdittextCalc.setText(s);
                break;
            case R.id.dot_Calc:
                s = s + ".";
                binding.EdittextCalc.setText(s);
                break;
            case R.id.equal_Calc:
                if(s.length() != 0) {
                    ArrayList<String> arrayList22 = new ArrayList<>();
                    ArrayList<Character> arrayListc = new ArrayList<>();
                    int count2 = 0;
                    for (int i = 0; i < s.length(); i++) {         //Division Operates that between + and -
                        if (i == s.length() - 1) {
                            arrayList22.add(s.substring(count2, i + 1));
                        }
                        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                            arrayList22.add(s.substring(count2, i));
                            arrayListc.add(s.charAt(i));
                            count2 = i + 1;
                        }
                    }
                    Log.d(TAG, "onClick: hhhh" + arrayList22);

                    ArrayList<Double> resultsfromequal = new ArrayList<>();
                    for (int j = 0; j < arrayList22.size(); j++) {           //Send them to Equal() that return Results of them
                        resultsfromequal.add(equall(arrayList22.get(j)));
                    }
                    Log.d(TAG, "onClick: hhhhf" + resultsfromequal);
                    if (arrayListc.size() == 0) {

                        double sresultdoublee = resultsfromequal.get(0) ;
                        int sresultintt = (int) sresultdoublee;
                        if((sresultdoublee - sresultintt) == 0){
                            s = String.valueOf(sresultintt);
                            binding.EdittextCalc.setText(s);
                        }else{
                            s = String.valueOf(sresultdoublee);
                            binding.EdittextCalc.setText(s);
                        }
                    } else {
                        String sresult2 = "";
                        for (int k = 0; k < arrayListc.size(); k++) {        //Recive Results then add + or - that between them from arraylistc and send it to equal() to get Result
                            if (k == 0) {
                                sresult2 = String.valueOf(resultsfromequal.get(k)) + arrayListc.get(k) + String.valueOf(resultsfromequal.get(k + 1));
                            } else {
                                sresult2 = sresult2 + arrayListc.get(k) + resultsfromequal.get(k + 1);
                            }
                        }
                        Log.d(TAG, "onClick: hhhhr" + sresult2);

                        double sresultdouble = equall(sresult2) ;
                        int sresultint = (int) sresultdouble;
                        if((sresultdouble - sresultint) == 0){
                            s=String.valueOf(sresultint);
                            binding.EdittextCalc.setText(s);
                        }else{
                            s=String.valueOf(sresultdouble);
                            binding.EdittextCalc.setText(s);
                        }



                    }
                }
                    break;


        }
    }

    private boolean caninserttool() {
        if(s.length() !=0){
        char c = s.charAt(s.length() - 1);
        if (s.length() > 0 && c != '+' && c != '-' && c != '/' && c != '*' && c != '%' && c != ' ') {
            return true;
        }
        }
        return false;
    }

    private void buttonssetonclicklistener() {

        binding.CCalc.setOnClickListener(this);
        binding.mutulCalc.setOnClickListener(this);
        binding.ClearCalc.setOnClickListener(this);
        binding.divisionCalc.setOnClickListener(this);
        binding.sevenCalc.setOnClickListener(this);
        binding.eightCalc.setOnClickListener(this);
        binding.nineCalc.setOnClickListener(this);
        binding.multiplyyCalc.setOnClickListener(this);
        binding.fourCalc.setOnClickListener(this);
        binding.fiveCalc.setOnClickListener(this);
        binding.sixCalc.setOnClickListener(this);
        binding.minusCalc.setOnClickListener(this);
        binding.oneCalc.setOnClickListener(this);
        binding.twoCalc.setOnClickListener(this);
        binding.threeCalc.setOnClickListener(this);
        binding.plusCalc.setOnClickListener(this);
        binding.multizeroCalc.setOnClickListener(this);
        binding.zeroCalc.setOnClickListener(this);
        binding.dotCalc.setOnClickListener(this);
        binding.equalCalc.setOnClickListener(this);

    }

    private Double equall(String ss) {
        Log.d(TAG, "equall: " + ss.length());
        if (ss.length() > 0) {
            result = 0;
            int count = 0;
            ArrayList<Character> characterArrayList = new ArrayList<>();
            char cs;
            char lastsymbol = ' ';
            char ls = ss.charAt(ss.length() - 1);
            if (!(ls == '+' || ls == '-' || ls == '*' || ls == '/' || ls == '%' || ls == '(')) {
                try {
                    for (int i = 0; i < ss.length(); i++) {
                        cs = ss.charAt(i);
                        if (count == 0) {
                            if (cs == '+' || cs == '-' || cs == '*' || cs == '/' || cs == '%') {
                                characterArrayList.add(cs);
                                Log.d(TAG, "onClick: " + ss.substring(count, i));
                                result = result + Double.parseDouble(ss.substring(count, i));
                                count = i + 1;
                                lastsymbol = cs;
                            }
                        } else {
                            if (i == ss.length() - 1) {
                                if (characterArrayList.get(characterArrayList.size() - 1).charValue() == '+') {
                                    result = result + Double.parseDouble(ss.substring(count, i + 1));
                                } else if (characterArrayList.get(characterArrayList.size() - 1).charValue() == '-') {
                                    result = result - Double.parseDouble(ss.substring(count, i + 1));
                                } else if (characterArrayList.get(characterArrayList.size() - 1).charValue() == '*') {
                                    result = result * Double.parseDouble(ss.substring(count, i + 1));
                                } else if (characterArrayList.get(characterArrayList.size() - 1).charValue() == '/') {
                                    result = result / Double.parseDouble(ss.substring(count, i + 1));
                                } else if (characterArrayList.get(characterArrayList.size() - 1).charValue() == '%') {
                                    result = result % Double.parseDouble(ss.substring(count, i + 1));
                                }
                            } else {
                                if ((characterArrayList.get(characterArrayList.size() - 1).charValue() == '+') && (cs == '+' || cs == '-' || cs == '*' || cs == '/' || cs == '%')) {
                                    characterArrayList.add(cs);
                                    result = result + Double.parseDouble(ss.substring(count, i));
                                    count = i + 1;
                                    lastsymbol = cs;
                                } else if (characterArrayList.get(characterArrayList.size() - 1).charValue() == '-' && (cs == '+' || cs == '-' || cs == '*' || cs == '/' || cs == '%')) {
                                    characterArrayList.add(cs);
                                    result = result - Double.parseDouble(ss.substring(count, i));
                                    count = i + 1;
                                    lastsymbol = cs;
                                } else if (characterArrayList.get(characterArrayList.size() - 1).charValue() == '*' && (cs == '+' || cs == '-' || cs == '*' || cs == '/' || cs == '%')) {
                                    characterArrayList.add(cs);
                                    result = result * Double.parseDouble(ss.substring(count, i));
                                    count = i + 1;
                                    lastsymbol = cs;
                                } else if (characterArrayList.get(characterArrayList.size() - 1).charValue() == '/' && (cs == '+' || cs == '-' || cs == '*' || cs == '/' || cs == '%')) {
                                    characterArrayList.add(cs);
                                    result = result / Double.parseDouble(ss.substring(count, i));
                                    count = i + 1;
                                    lastsymbol = cs;
                                } else if (characterArrayList.get(characterArrayList.size() - 1).charValue() == '%' && (cs == '+' || cs == '-' || cs == '*' || cs == '/' || cs == '%')) {
                                    characterArrayList.add(cs);
                                    result = result % Double.parseDouble(ss.substring(count, i));
                                    count = i + 1;
                                    lastsymbol = cs;
                                }
                            }
                        }
                    }
                     if(characterArrayList.size() == 0){
                         result = Double.parseDouble(ss);
                    }

                    // binding.EdittextCalc.setText(s);

                    return result;


                } catch (Exception e) {
                    Log.e(TAG, "onClick: ", e);
                }
            } else {
                Toast.makeText(getActivity().getApplicationContext(), "Exeption Error", Toast.LENGTH_SHORT).show();
                return 0.0;
            }
        }
        return 0.0;
    }
}