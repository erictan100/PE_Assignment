package com.example.pe_assignment.initialFragment.game;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class QuizDatabase extends SQLiteOpenHelper {

    public static final String DatabaseName = "Quiz.db";
    public static final String TABLE_NAME = "quiz";
    public static final String COLUMN_INDEX = "ID";
    public static final String COLUMN_QUESTION = "QUESTIONS";
    public static final String COLUMN_SELECTION1 = "SELECT1";
    public static final String COLUMN_SELECTION2 = "SELECT2";
    public static final String COLUMN_SELECTION3 = "SELECT3";
    public static final String COLUMN_SELECTION4 = "SELECT4";
    public static final String COLUMN_ANSWER = "ANSWER";

    public static int QuestionNo = 5;

    public static String quizQuestions[] = {
            "How many meters of social distance is enough during Covid-19 situation",
            "What are the organs most affected by COVID-19",
            "How long does the virus that causes COVID-19 last on surfaces of plastic",
            "Below which are not the common symptoms for Covid-19",
            "Which is not the preventative measures for Covid-19"
    };

    public static String Selection1[] = {
            "1 meter", "Liver", "12", "Fever", "Joining Party"
    };

    public static String Selection2[] = {
            "2 meter", "Lungs", "24", "Cough", "Social Distancing"
    };

    public static String Selection3[] = {
            "1.2 meter", "Heart ", "72", "Tiredness", "Quarantine"
    };

    public static String Selection4[] = {
            "1.5 meter", "Brain", "84", "Heart Attack", "Covering coughs"
    };

    public static String Answer[] = {
            "A", "B", "C", "D", "A"
    };

    public QuizDatabase(@Nullable Context context) {
        super(context, DatabaseName, null, 1);

        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate (SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + " (" + COLUMN_INDEX + " TEXT PRIMARY KEY," +
                COLUMN_QUESTION + " TEXT NOT NULL," +
                COLUMN_SELECTION1 + " TEXT NOT NULL," +
                COLUMN_SELECTION2 + " TEXT NOT NULL," +
                COLUMN_SELECTION3 + " TEXT NOT NULL," +
                COLUMN_SELECTION4 + " TEXT NOT NULL," +
                COLUMN_ANSWER + " TEXT NOT NULL )");
    }

    @Override
    public void onUpgrade (SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(sqLiteDatabase);
    }

    public void createQuestion()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        for(int i = 0; i < quizQuestions.length; i++)
        {
            int j = i + 1;
            ContentValues values = new ContentValues();
            values.put(COLUMN_INDEX, j);
            values.put(COLUMN_QUESTION, quizQuestions[i]);
            values.put(COLUMN_SELECTION1, Selection1[i]);
            values.put(COLUMN_SELECTION2, Selection2[i]);
            values.put(COLUMN_SELECTION3, Selection3[i]);
            values.put(COLUMN_SELECTION4, Selection4[i]);
            values.put(COLUMN_ANSWER, Answer[i]);

            db.insert(TABLE_NAME, null, values);
        }
    }

    public Cursor getQuestion(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery(" SELECT * FROM " + TABLE_NAME + " WHERE ID = '" + id + "'", null);
        return res;
    }
}
