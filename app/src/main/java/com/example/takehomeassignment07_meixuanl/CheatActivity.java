package com.example.takehomeassignment07_meixuanl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {


        private boolean mAnswerIsTrue;
        private static final String EXTRA_ANSWER_IS_TRUE = "com.example.takehomeassignment07_meixuanl.answer_is_true";
        private static final String EXTRA_ANSWER_SHOWN = "com.example.takehomeassignment07_meixuanl.answer_shown";

        private TextView mAnswerTextView;
        private Button mShowAnswerButton;

        public static Intent newIntent(Context packageContext, boolean answerIsTrue){
            Intent intent = new Intent (packageContext, CheatActivity.class);
            intent.putExtra(EXTRA_ANSWER_IS_TRUE,answerIsTrue);
            return intent;
        }

        public static boolean isAnswerShown(Intent result){
            return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cheat);

            mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

            mAnswerTextView = (TextView)findViewById(R.id.answer_text_view);
            mShowAnswerButton = (Button)findViewById(R.id.show_answer_button);

            mShowAnswerButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    if (mAnswerIsTrue){
                        mAnswerTextView.setText(R.string.true_button);
                    }else{
                        mAnswerTextView.setText(R.string.false_button);
                    }
                    setAnswerShownResult(true);
                }
            });
        }

        private void setAnswerShownResult(boolean isAnswerShown){
            Intent data = new Intent();
            data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
            setResult(RESULT_OK,data);
        }

    }