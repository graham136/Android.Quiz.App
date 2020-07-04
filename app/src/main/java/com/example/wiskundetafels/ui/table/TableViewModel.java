package com.example.wiskundetafels.ui.table;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wiskundetafels.models.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TableViewModel extends ViewModel {

    private int tableChosen;
    public int answered;
    public int correct;
    public int wrong;
    public int totalQuestions;
    public int multiplyTable;
    public List<Question> questions;

    public TableViewModel(int _multiplyTable) {
        multiplyTable = _multiplyTable;
        answered = 0;
        correct = 0;
        wrong = 0;
        totalQuestions = 3;

        int k = 0;
        questions = new ArrayList<Question>();
        Random random = new Random();


        for (k = 0; k < totalQuestions; k++)
        {
            Question question = new Question();
            int randomNumber = random.nextInt(12)+1;
            int correctButton = random.nextInt(3)+1;

            question.questionText = _multiplyTable + " x " + randomNumber;
            question.correctAnswer =String.valueOf(_multiplyTable * randomNumber);

            switch (correctButton)
            {
                case 1:
                    question.button1Text = String.valueOf(_multiplyTable * randomNumber);
                    question.button2Text = String.valueOf(_multiplyTable * (randomNumber + 1));
                    question.button3Text = String.valueOf(_multiplyTable * (randomNumber - 1));
                    break;
                case 2:
                    question.button2Text = String.valueOf(_multiplyTable * randomNumber);
                    question.button3Text = String.valueOf(_multiplyTable * (randomNumber + 1));
                    question.button1Text = String.valueOf(_multiplyTable * (randomNumber - 1));
                    break;
                case 3:
                    question.button3Text = String.valueOf(_multiplyTable * randomNumber);
                    question.button1Text = String.valueOf(_multiplyTable * (randomNumber + 1));
                    question.button2Text = String.valueOf(_multiplyTable * (randomNumber - 1));
                    break;
            }
            questions.add(question);
        }
    }
}