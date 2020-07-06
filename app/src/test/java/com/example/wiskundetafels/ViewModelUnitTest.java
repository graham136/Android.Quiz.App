package com.example.wiskundetafels;

import com.example.wiskundetafels.ui.table.TableViewModel;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ViewModelUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void tableViewModel_answered_is_0()
    {
        TableViewModel tableViewModel = new TableViewModel(5);
        assertEquals(tableViewModel.answered, 0);
    }
    @Test
    public void tableViewModel_correct_is_0()
    {
        TableViewModel tableViewModel = new TableViewModel(5);
        assertEquals(tableViewModel.correct, 0);
    }
    @Test
    public void tableViewModel_wrong_is_0()
    {
        TableViewModel tableViewModel = new TableViewModel(5);
        assertEquals(tableViewModel.wrong, 0);
    }
    @Test
    public void tableViewModel_totalQuestions_is_0()
    {
        TableViewModel tableViewModel = new TableViewModel(5);
        assertEquals(tableViewModel.totalQuestions, 3);
    }
    @Test
    public void tableViewModel_questions_is_not_null()
    {
        TableViewModel tableViewModel = new TableViewModel(5);
        assertNotNull(tableViewModel.questions);
    }
}