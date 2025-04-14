package com.example.lottieanimation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;

public class MainActivity extends AppCompatActivity {

    LottieAnimationView lottieView;
    Button playPauseButton;
    boolean isPlaying = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lottieView = findViewById(R.id.surprise);
        playPauseButton = findViewById(R.id.playPauseButton);

        if (lottieView != null) {
            lottieView.setAnimation(R.raw.animation);
            lottieView.setRepeatCount(LottieDrawable.INFINITE);
            lottieView.playAnimation();
        }

        playPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    lottieView.pauseAnimation();
                    playPauseButton.setText("Play");
                } else {
                    lottieView.resumeAnimation();
                    playPauseButton.setText("Pause");
                }
                isPlaying = !isPlaying;
            }
        });
    }
}
