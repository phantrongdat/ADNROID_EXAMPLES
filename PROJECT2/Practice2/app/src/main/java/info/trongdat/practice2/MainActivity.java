package info.trongdat.practice2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtScore, txtQuestion;
    LinearLayout layoutAnswer;

    Button btnReset;
    String[] question = {"...ị sỹ", "cái ...a", "con ...á", "con ...ua", "...ây khế", "...uả dừa", "...ể chuyển", "con ..à", "cái ...ế", "cái ...e"};
    String[] answer = {"k", "c", "q", "g", "gh", "l", "n", "ng", "ngh"};
    int[] result = {0, 1, 1, 1, 1, 2, 0, 3, 4, 4};
    ArrayList<Question> questions;
    Button[] btnAnswer;

    int questionIndex = 1, score = 0;
    Question currentQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initialize();
    }


    // phương thức thiết lập, ánh xạ các đối tượng.
    public void initialize() {
        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        txtScore = (TextView) findViewById(R.id.txtScore);
        layoutAnswer = (LinearLayout) findViewById(R.id.layoutAnswer);
        btnReset = (Button) findViewById(R.id.btnReset);
        btnReset.setOnClickListener(this);

        questions = new ArrayList<>();
        txtScore.setText(score + "");
        btnAnswer = new Button[answer.length];

        // khởi tạo các nút chọn đáp án.
        for (int i = 0; i < btnAnswer.length; i++) {
            btnAnswer[i] = new Button(this);
            btnAnswer[i].setBackgroundResource(R.drawable.button_background);
            btnAnswer[i].setTextColor(Color.WHITE);
            int resourceId = this.getResources().getIdentifier("btn" + i, "id", this.getPackageName());
            btnAnswer[i].setId(resourceId);
            btnAnswer[i].setOnClickListener(this);

            // thêm nút chọn đáp án
            layoutAnswer.addView(btnAnswer[i]);
        }
        loadQuestion();
        getQuestion(questionIndex);
    }

    // phương thức lấy danh sách câu hỏi.
    public void loadQuestion() {
        for (int i = 0; i < answer.length; i++) {
            Question question1 = new Question(question[i], answer, answer[result[i]]);
            questions.add(question1);
        }
    }

    // phương thức lấy ra câu hỏi trong danh sách.
    public void getQuestion(int index) {
        if (index <= questions.size()) {
            currentQuestion = questions.get(index-1);
            txtQuestion.setText(currentQuestion.getQuestion());
            for (int i = 0; i < answer.length; i++) {
                btnAnswer[i].setText(currentQuestion.getAnswer()[i]);

            }
        } else {
            txtQuestion.setText("Chúc mừng bạn đã hoàn thành bài kiểm tra!");
            TextView txtDisplay= (TextView)findViewById(R.id.txtDisplay);
            txtDisplay.setText("");
        }
    }


    // phương thức thiết lập về ban đầu.
    public void resetQuestion() {
        score = 0;
        txtScore.setText(score+"");
        questionIndex = 1;
        getQuestion(questionIndex);
    }

    // phương thức xử lý xự kiện khi chọn kết quả.
    @Override
    public void onClick(View view) {
        if (view == btnReset) resetQuestion();
        for (int i = 0; i < btnAnswer.length; i++) {
            if (view == btnAnswer[i]) {
                if (btnAnswer[i].getText().equals(currentQuestion.getResult())) {
                    // cộng và cập nhật điểm.
                    score += 10;
                    txtScore.setText(score + "");

                    // hiệu ứng khi trả lời đúng.
                    Animation animation= AnimationUtils.loadAnimation(this,R.anim.anim_correct);
                    txtScore.startAnimation(animation);
                }
                // chuyển tới câu hỏi tiếp theo.
                questionIndex++;
                getQuestion(questionIndex);
            }
        }
    }
}
