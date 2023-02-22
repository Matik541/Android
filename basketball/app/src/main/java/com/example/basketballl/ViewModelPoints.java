package com.example.basketballl;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelPoints extends ViewModel {
    private MutableLiveData<Integer> scoreA = new MutableLiveData<>(0);
    private MutableLiveData<Integer> scoreB = new MutableLiveData<>(0);

    public void setScoreA(MutableLiveData<Integer> score) {
        this.scoreA = score;
    }
    public MutableLiveData<Integer> getScoreA() {
        if (scoreA == null) {
            scoreA = new MutableLiveData<>();
            scoreA.setValue(0);
        }
        return scoreA;
    }
    public void addScoreA(int score) {
        this.scoreA.setValue(this.scoreA.getValue() + score);
    }
    public void setScoreB(MutableLiveData<Integer>  score) {
        this.scoreB = score;
    }
    public MutableLiveData<Integer> getScoreB() {
        if (scoreB == null) {
            scoreB = new MutableLiveData<>();
            scoreB.setValue(0);
        }
        return scoreB;
    }
    public void addScoreB(int score) {
        this.scoreB.setValue(this.scoreB.getValue() + score);
    }
}
