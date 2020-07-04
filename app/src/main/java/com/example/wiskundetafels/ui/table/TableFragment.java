package com.example.wiskundetafels.ui.table;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.wiskundetafels.MainActivity;
import com.example.wiskundetafels.R;

/**
 * Table Fragment is where we display and ask the questions generated in TableViewModel
 */
public class TableFragment extends Fragment {

    public TableViewModel _viewmodel;
    private int tableChosen;
    public String answer;
    public int answered;
    public View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        tableChosen = MainActivity.GetTableChosen();
        _viewmodel = new TableViewModel(tableChosen);
        root = inflater.inflate(R.layout.fragment_table, container, false);

        Button button1 = (Button) root.findViewById(R.id.answerButton1);
        Button button2 = (Button) root.findViewById(R.id.answerButton2);
        Button button3 = (Button) root.findViewById(R.id.answerButton3);
        TextView question = (TextView) root.findViewById((R.id.question));


        button1.setText(_viewmodel.questions.get(0).button1Text);
        button2.setText(_viewmodel.questions.get(0).button2Text);
        button3.setText(_viewmodel.questions.get(0).button3Text);
        question.setText(_viewmodel.questions.get(0).questionText);
        answer = _viewmodel.questions.get(0).correctAnswer;
        answered = 0;

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnswerButton_Clicked(view);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnswerButton_Clicked(view);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnswerButton_Clicked(view);
            }
        });

        return root;
    }

    /**
     *
     * @param view the answer button clicked
     */
    public void AnswerButton_Clicked(View view) {
        Button button1 = (Button) root.findViewById(R.id.answerButton1);
        Button button2 = (Button) root.findViewById(R.id.answerButton2);
        Button button3 = (Button) root.findViewById(R.id.answerButton3);
        TextView question = (TextView) root.findViewById((R.id.question));
        Button button = (Button) root.findViewById(view.getId());

        if (button.getText()==answer){
            _viewmodel.correct++;
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setTitle("");
            builder.setMessage("Korrek: " + question.getText() + " = " + answer);
            builder.setPositiveButton("Volgende", null);
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setTitle("");
            builder.setMessage("Jammer, dit is verkeerd. \nDie korrekte antwoord is " + question.getText() + " = " + answer);
            builder.setPositiveButton("Volgende", null);
            AlertDialog dialog = builder.create();
            dialog.show();
        }

        if (answered + 1 == _viewmodel.totalQuestions)
        {
            AlertDialog.Builder builderEnd = new AlertDialog.Builder(view.getContext());
            builderEnd.setTitle("");
            builderEnd.setMessage("Knap gedaan. \nU het " + _viewmodel.correct + " korrek uit " + _viewmodel.totalQuestions);
            builderEnd.setPositiveButton("Volgende", null);
            AlertDialog dialogEnd = builderEnd.create();
            dialogEnd.show();
            Navigation.findNavController(view).navigate(R.id.nav_home);
        }
        else
        {
            answered++;
            button1.setText(_viewmodel.questions.get(answered).button1Text);
            button2.setText(_viewmodel.questions.get(answered).button2Text);
            button3.setText(_viewmodel.questions.get(answered).button3Text);
            question.setText(_viewmodel.questions.get(answered).questionText);
            answer = _viewmodel.questions.get(answered).correctAnswer;
        }
    }
}