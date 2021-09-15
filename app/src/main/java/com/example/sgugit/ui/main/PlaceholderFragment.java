package com.example.sgugit.ui.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.sgugit.Exercises_Op;
import com.example.sgugit.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {


    private int key;

    private static final String ARG_SECTION_NUMBER = "section_number";
    private PageViewModel pageViewModel;
    private int i_currentIndex = 0;

    public static PlaceholderFragment newInstance(int index, int key) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        fragment.i_currentIndex = index;
        fragment.key = key;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }


    @SuppressLint("ResourceAsColor")
    private void appendButton(LinearLayout layout, String name, int index) {
        Button button = new Button(layout.getContext());
        button.setBackground(this.getResources().getDrawable(R.drawable.b_view));
        button.setText(name);
        button.setPadding(20,20,20,20);
        button.setTextSize(14);
        button.setTypeface(Typeface.DEFAULT); //шрифт
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(layout.getContext(), Exercises_Op.class);
                intent.putExtra("category", i_currentIndex);
                intent.putExtra("key", key);
                intent.putExtra("position", index);
                startActivity(intent);
            }
        });

        layout.addView(button, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
    }

    private void populatePage(LinearLayout layout) {
        if (SectionsPagerAdapter.validateExcerciseIndex(i_currentIndex, 0) == false)
            return;

        String[] t = SectionsPagerAdapter.TAB_EXERCISES[i_currentIndex];
        for (int i = 0; i < t.length; i++) {
            appendButton(layout, t[i], i);
        }
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.list_exercises, container, false);
        LinearLayout test = root.findViewById(R.id.vert_buttons);
        populatePage(test);
        pageViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return root;
    }
}