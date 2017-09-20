package workprog.clix.workprog;

import io.realm.RealmObject;

/**
 * Created by CLiST on 0020, September 20, 2017.
 */

public class BodyMeasure extends RealmObject {
    private float bodyWeight, bodyFat, bodyWater, bodyMuscles, bodyBone;
    private int dailyKilocaries;

    public BodyMeasure(float bodyWeight, float bodyFat, float bodyWater, float bodyMuscles, float bodyBone, int dailyKilocaries) {
        this.bodyWeight      = bodyWeight;
        this.bodyFat         = bodyFat;
        this.bodyWater       = bodyWater;
        this.bodyMuscles     = bodyMuscles;
        this.bodyBone        = bodyBone;
        this.dailyKilocaries = dailyKilocaries;
    }

    public BodyMeasure() {
        this.bodyWeight      = 0;
        this.bodyFat         = 0;
        this.bodyWater       = 0;
        this.bodyMuscles     = 0;
        this.bodyBone        = 0;
        this.dailyKilocaries = 0;
    }

    public float getBodyWeight() {
        return bodyWeight;
    }

    public void setBodyWeight(float bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    public float getBodyFat() {
        return bodyFat;
    }

    public void setBodyFat(float bodyFat) {
        this.bodyFat = bodyFat;
    }

    public float getBodyWater() {
        return bodyWater;
    }

    public void setBodyWater(float bodyWater) {
        this.bodyWater = bodyWater;
    }

    public float getBodyMuscles() {
        return bodyMuscles;
    }

    public void setBodyMuscles(float bodyMuscles) {
        this.bodyMuscles = bodyMuscles;
    }

    public float getBodyBone() {
        return bodyBone;
    }

    public void setBodyBone(float bodyBone) {
        this.bodyBone = bodyBone;
    }

    public int getDailyKilocaries() {
        return dailyKilocaries;
    }

    public void setDailyKilocaries(int dailyKilocaries) {
        this.dailyKilocaries = dailyKilocaries;
    }
}
